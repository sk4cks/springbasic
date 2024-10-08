package toby_project.springbasic;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import toby_project.config.MySpringBootApplication;

@MySpringBootApplication
public class SpringbasicApplication {
	private final JdbcTemplate jdbcTemplate;

	public SpringbasicApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	void init() {
		jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
	}

	public static void main(String[] args) {
//		MySpringApplication.run(SpringbasicApplication.class, args);
		SpringApplication.run(SpringbasicApplication.class, args);
	}



}
