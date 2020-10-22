package com.example;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

@WebListener
public class SessionListener implements HttpSessionActivationListener {
    public void sessionWillPassivate(HttpSessionEvent se) {
        System.out.println("sessionWillPassivate");
    }

    public void sessionDidActivate(HttpSessionEvent se) {
        System.out.println("sessionDidActivate");
    }
}
