package webserver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;

import db.DataBase;
import model.User;
import util.HttpRequestUtils;

public class RequestHandler extends Thread {
    private static final Logger log = LoggerFactory.getLogger(RequestHandler.class);

    private final Socket connection;

    public RequestHandler(Socket connectionSocket) {
        this.connection = connectionSocket;
    }

    public void run() {
        log.debug("New Client Connect! Connected IP : {}, Port : {}", connection.getInetAddress(), connection.getPort());

        try (InputStream in = connection.getInputStream(); OutputStream out = connection.getOutputStream()) {
            // TODO 사용자 요청에 대한 처리는 이 곳에 구현하면 된다.
            DataOutputStream dos = new DataOutputStream(out);

            // 요청
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String line, requestBody = "", requestLine = bufferedReader.readLine();

            if(requestLine == null) return;

            // 0 METHOD, 1 URL, 2 HTTP VERSION
            String[] request = requestLine.split(" ");

            HashMap<String, String> header = new HashMap<>();
            while(!(line = bufferedReader.readLine()).isEmpty()) {
                HttpRequestUtils.Pair pair = HttpRequestUtils.parseHeader(line);
                header.put(pair.getKey(), pair.getValue());
            }

            if(request[0].equals("GET") && request[1].contains("?")) {
                requestBody = request[1].split("\\?")[1];
            } else if(request[0].equals("POST")) {
                // Content-Length 헤더를 통해 본문의 길이를 파악
                String contentLengthValue = header.get("Content-Length");
                if (contentLengthValue != null) {
                    int contentLength = Integer.parseInt(contentLengthValue);
                    char[] body = new char[contentLength];
                    bufferedReader.read(body, 0, contentLength);
                    requestBody = new String(body);
                }
            }

            // 요청에 따른 응답 변경

            File file = new File("requirements-5/webapp/index.html");

            if(header.get("Sec-Fetch-Dest").equals("document")) {

                Map<String, String> requestMap = HttpRequestUtils.parseQueryString(requestBody);

                if (request[1].equals("/")) {
                    request[1] = "/index.html";
                } else if(request[1].contains("/user/create") && (request[0].equals("GET") || request[0].equals("POST"))) {
                    User.create(requestMap);
                    response302Header(dos, "/");
                    return;
                } else if(request[1].contains("/user/login") && request[0].equals("POST")) {
                    User user = DataBase.findUserById(requestMap.getOrDefault("userId", ""));
                    response302Header(dos, "/",
                        "logined="+(user != null && user.getPassword().equals(requestMap.get("password"))));
					return;
                }

                file = new File("requirements-5/webapp" + request[1]);
            }

             // 응답
            byte[] bytes = Files.readAllBytes(file.toPath());
            response200Header(dos, bytes.length);
            responseBody(dos, bytes);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void response200Header(DataOutputStream dos, int lengthOfBodyContent) {
        response200Header(dos, lengthOfBodyContent, null);
    }

    private void response200Header(DataOutputStream dos, int lengthOfBodyContent, String cookieValue) {
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            if(cookieValue != null) dos.writeBytes("Set-Cookie: " + cookieValue + "; Path=/ \r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void response302Header(DataOutputStream dos, String url) {
        response302Header(dos, url, null);
    }

    private void response302Header(DataOutputStream dos, String url, String cookieValue) {
        try {
            dos.writeBytes("HTTP/1.1 302 Found \r\n");
            dos.writeBytes("Location: " + url + "\r\n");
            if(cookieValue != null) dos.writeBytes("Set-Cookie: " + cookieValue + "; Path=/ \r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
