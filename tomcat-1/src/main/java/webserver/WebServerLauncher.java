package webserver;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebServerLauncher {
    private static final Logger log = LoggerFactory.getLogger(WebServerLauncher.class);
    private static final int DEFAULT_PORT = 8085;

    public static void main(String args[]) throws Exception {
        String webAppDir = "tomcat-1/webapp/";
        int port = 0;

        if (args == null || args.length == 0) {
            port = DEFAULT_PORT;
        } else {
            port = Integer.parseInt(args[0]);
        }

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(port);
        tomcat.getConnector();

        Context ctx = tomcat.addWebapp("/", new File(webAppDir).getAbsolutePath());
        Tomcat.addServlet(ctx, "helloWorld", new HelloWorldController());
        ctx.addServletMappingDecoded("/hello", "helloWorld");

        tomcat.start();
        tomcat.getServer().await();
    }
}
