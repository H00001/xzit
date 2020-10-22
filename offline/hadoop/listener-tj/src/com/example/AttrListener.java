package com.example;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AttrListener implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent scae) {
        System.out.println("attr added"+scae.getName());
    }

    public void attributeRemoved(ServletContextAttributeEvent scae) {
        System.out.println("attr removed"+scae.getName());
    }

    public void attributeReplaced(ServletContextAttributeEvent scae) {
        System.out.println("attr replaced"+scae.getName());
    }
}
