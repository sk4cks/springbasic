package toby_project.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@Configuration
@ComponentScan
public class SpringbasicApplication {

	@Bean
	public ServletWebServerFactory serverFactory(){
		return new TomcatServletWebServerFactory();
	}

	@Bean
	DispatcherServlet dispatcherServlet(){
		return new DispatcherServlet();
	}
	public static void main(String[] args) {
		MySpringApplication.run(SpringbasicApplication.class, args);


//		SpringApplication.run(SpringbasicApplication.class, args);
	}



}
