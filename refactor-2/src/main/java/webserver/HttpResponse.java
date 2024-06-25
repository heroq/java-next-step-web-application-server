package webserver;

import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpResponse {

	private static final Logger log = LoggerFactory.getLogger(HttpResponse.class);

	DataOutputStream dos;
	private Map<String, String> header = new HashMap<String, String>();

	HttpResponse(OutputStream dos) {
		this.dos = new DataOutputStream(dos);
	}

	// forward (직접 읽어 응답)
	// sendRedirect (리다이렉션)
	// 응답 데이터 처리 중복 제거
	// 헤더 정보는 Map으로 관리

	public void addHeader(String key, String value) {
		header.put(key,	value);
	}

	public void forward(String url) throws IOException {
		byte[] body = Files.readAllBytes(new File("./webapp/" + url).toPath());
		response200Header(dos, body.length);
		responseBody(dos, body);
	}

	public void sendRedirect(String url) {
		response302Header(dos, url);
	}

	private void response200Header(DataOutputStream dos, int lengthOfBodyContent) {
		try {
			dos.writeBytes("HTTP/1.1 200 OK \r\n");
			dos.writeBytes("Content-Type: text/html;charset=utf-8\r\n");
			dos.writeBytes("Content-Length: " + lengthOfBodyContent + "\r\n");
			header.forEach((k,v) -> {
				try {
					dos.writeBytes(k + ": " + v + "\r\n");
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});
			dos.writeBytes("\r\n");
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	private void response302Header(DataOutputStream dos, String url) {
		try {
			dos.writeBytes("HTTP/1.1 302 Redirect \r\n");
			dos.writeBytes("Location: " + url + "\r\n");
			header.forEach((k,v) -> {
				try {
					dos.writeBytes(k + ": " + v + "\r\n");
				} catch (IOException e) {
					throw new RuntimeException(e);
				}
			});
			dos.writeBytes("\r\n");
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	private void responseBody(DataOutputStream dos, byte[] body) {
		try {
			dos.write(body, 0, body.length);
			dos.writeBytes("\r\n");
			dos.flush();
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
}