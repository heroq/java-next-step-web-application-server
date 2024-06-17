package webserver;

public enum RequestURL {
	INDEX("/"),
	SIGNUP("/user/create"),
	LOGIN("/user/login"),
	LIST("/user/list");

	private String url;

	RequestURL(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
