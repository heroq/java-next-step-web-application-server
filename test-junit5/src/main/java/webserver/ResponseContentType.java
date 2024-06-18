package webserver;

import java.util.Arrays;

public enum ResponseContentType {
	HTML("document", "text/html;charset=utf-8"),
	CSS("style", "text/css"),
	SCRIPT("script", "text/javascript");

	private String secFetchDest;
	private String contentType;

	ResponseContentType(String secFetchDest, String contentType) {
		this.secFetchDest = secFetchDest;
		this.contentType = contentType;
	}

	public static String getContentType(String secFetchDest) {
		return Arrays.stream(ResponseContentType.values())
			.filter(e -> e.secFetchDest.equals(secFetchDest))
			.map(e -> e.contentType)
			.findFirst()
			.orElse(null);
	}
}
