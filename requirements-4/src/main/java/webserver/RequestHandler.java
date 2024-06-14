package webserver;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInput;
import java.io.DataInputStream;
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

            File file = new File("requirements-4/webapp/index.html");

            if(header.get("Sec-Fetch-Dest").equals("document")) {

                if(request[1].equals("/")) request[1] = "/index.html";
                if(request[1].contains("/user/create") && (request[0].equals("GET") || request[0].equals("POST"))) {
                    User.create(HttpRequestUtils.parseQueryString(requestBody));
                    response302Header(dos, "/");
                    return;
                }

                file = new File("requirements-4/webapp" + request[1]);
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
        try {
            dos.writeBytes("HTTP/1.1 200 OK \r\n");
            dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
            dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
            dos.writeBytes("\r\n");
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    private void response302Header(DataOutputStream dos, String url) {
        try {
            dos.writeBytes("HTTP/1.1 302 Found \r\n");
            dos.writeBytes("Location: " + url + "\r\n");
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
