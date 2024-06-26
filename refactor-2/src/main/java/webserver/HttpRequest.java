package webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.HttpRequestUtils;
import util.HttpRequestUtils.Pair;

public class HttpRequest {
	private static final Logger log = LoggerFactory.getLogger(HttpRequest.class);
	InputStream inputStream;

	private String method;
	private String path;
	private Map<String, String> header;
	private Map<String, String> parameter;

	HttpRequest(InputStream inputStream) {
		this.inputStream = inputStream;
		try {
			header = new HashMap<>();
			BufferedReader br = new BufferedReader(new InputStreamReader(this.inputStream, StandardCharsets.UTF_8));
			String line = br.readLine();
			if(line == null) {
				return;
			}

			String[] requestLine = line.split(" ");
			method = requestLine[0];
			path = requestLine[1];

			if(method.equals("GET") && path.contains("?")) {
				parameter = HttpRequestUtils.parseQueryString(path.split("\\?")[1]);
				path = path.split("\\?")[0];
			}

			while (!(line = br.readLine()).isEmpty()) {
				Pair pair = HttpRequestUtils.parseHeader(line);
				header.put(pair.getKey(), pair.getValue());
			}

			if(method.equals("POST")) {
				int contentLength = Integer.parseInt(header.get("Content-Length"));
				char[] body = new char[contentLength];
				br.read(body, 0, contentLength);
				parameter = HttpRequestUtils.parseQueryString(new String(body));
			}

		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}

	public String getParameter(String name) {
		return parameter.get(name);
	}

	public String getHeader(String key) {
		return header.get(key);
	}

	public String getMethod() {
		return method;
	}

	public String getPath() {
		return path;
	}

}
