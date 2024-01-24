package com.example.listener;

//javax.servlet.ServletContextListener
//javax.servlet.ServletContextAttributeListener
//javax.servlet.ServletRequestListener
//javax.servlet.ServletRequestAttributeListener
//javax.servlet.http.HttpSessionListener
//javax.servlet.http.HttpSessionAttributeListener

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class MyServletListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("Request destroyed");
        ServletRequestListener.super.requestDestroyed(sre);
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Request init");
        ServletRequestListener.super.requestInitialized(sre);
    }
}
