package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class DeptProvider8003_App extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003_App.class,args);
    }
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.setInitParameter("org.eclipse.jetty.servlet.SessionIdPathParameterName", "none");
    }
}
