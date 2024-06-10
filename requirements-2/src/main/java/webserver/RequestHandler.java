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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.io.ByteStreams;

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
            String line, requestLine = "";
            HashMap<String, String> header = new HashMap<>();
            while(!(line = bufferedReader.readLine()).isEmpty()) {
                HttpRequestUtils.Pair pair = HttpRequestUtils.parseHeader(line);
                // 첫번째 줄 요청 라인 저장
                if(pair == null) {
                    requestLine = line;
                    continue;
                }
                header.put(pair.getKey(), pair.getValue());
            }

            // 요청에 따른 응답 변경

            // 0 METHOD, 1 URL, 2 HTTP VERSION
            String[] request = requestLine.split(" ");

            File file = new File("requirements-1/webapp/index.html");

            if(header.get("Sec-Fetch-Dest").equals("document")) {
                if(request[0].equals("GET") && request[1].contains("/user/create?")) {
                    String userQueryString = request[1].split("\\?")[1];
                    RequestCreate.create(HttpRequestUtils.parseQueryString(userQueryString));
                    response200Header(dos, 0);
                    return;
                }

                file = new File("requirements-1/webapp" + request[1]);
            }

             // 응답
            byte[] bytes = ByteStreams.toByteArray(new FileInputStream(file));
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

    private void responseBody(DataOutputStream dos, byte[] body) {
        try {
            dos.write(body, 0, body.length);
            dos.flush();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }
}
