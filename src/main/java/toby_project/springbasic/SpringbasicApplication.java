package toby_project.springbasic;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import toby_project.config.MySpringBootApplication;

@MySpringBootApplication
public class SpringbasicApplication {


	public static void main(String[] args) {
//		MySpringApplication.run(SpringbasicApplication.class, args);
		SpringApplication.run(SpringbasicApplication.class, args);
	}



}
