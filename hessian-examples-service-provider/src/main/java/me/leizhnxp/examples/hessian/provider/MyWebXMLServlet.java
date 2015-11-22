package me.leizhnxp.examples.hessian.provider;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

public class MyWebXMLServlet implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		org.apache.log4j.BasicConfigurator.configure();
        ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher", new DispatcherServlet());
        servletContext.addListener(Log4jConfigListener.class);
        servletContext.setInitParameter("contextConfigLocation", "classpath:hessian-examples-ctx-dao.xml");
        servletContext.addListener(ContextLoaderListener.class);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
	}

}
