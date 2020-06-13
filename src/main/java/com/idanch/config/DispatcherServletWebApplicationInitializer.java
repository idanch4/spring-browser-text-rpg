package com.idanch.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class DispatcherServletWebApplicationInitializer implements WebApplicationInitializer {
    public static final Logger log = LoggerFactory.getLogger(DispatcherServletWebApplicationInitializer.class);

    private static final String DISPATCHER_SERVLET_NAME = "DispatcherServlet";

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // create application context
        AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        appContext.register(WebConfig.class);

        DispatcherServlet dispatcherServlet = new DispatcherServlet(appContext);

        // create and register the dispatcher servlet
        ServletRegistration.Dynamic registration =
                servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);

        // dispatcher servlet configuration
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
    }
}
