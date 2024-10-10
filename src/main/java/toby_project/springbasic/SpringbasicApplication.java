package toby_project.springbasic;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionEvaluationReport;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringbasicApplication {
	private final JdbcTemplate jdbcTemplate;

	public SpringbasicApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@PostConstruct
	void init() {
		jdbcTemplate.execute("create table if not exists hello(name varchar(50) primary key, count int)");
	}

	@Bean
	ApplicationRunner run(ConditionEvaluationReport report) {
		return args -> {
			System.out.println(report.getConditionAndOutcomesBySource().entrySet().stream()
					.filter(co -> co.getValue().isFullMatch())
					.map(co -> {
						System.out.println(co.getKey());
						co.getValue().forEach(c -> {
							System.out.println("\t"+c.getOutcome());
						});
						System.out.println();
						return co;
					}).count());
		};
	}

	public static void main(String[] args) {
//		MySpringApplication.run(SpringbasicApplication.class, args);
		SpringApplication.run(SpringbasicApplication.class, args);
	}



}
