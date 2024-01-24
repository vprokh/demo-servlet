package com.example.server;

import com.example.servlets.MyFirstServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class TomcatServer {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.setHostname("localhost");
        tomcat.getHost().setAppBase(".");

        File docBase = new File(System.getProperty("java.io.tmpdir"));
        Context context = tomcat.addContext("", docBase.getAbsolutePath());

        Tomcat.addServlet(context, MyFirstServlet.class.getSimpleName(), MyFirstServlet.class.getName());

        context.addServletMappingDecoded("/my-servlet", MyFirstServlet.class.getSimpleName());

        tomcat.start();
        tomcat.getServer().await();
    }
}
