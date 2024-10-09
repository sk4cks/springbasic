package toby_project.springbasic.hello;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class HelloRepositoryTest {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    HelloRepository helloRepository;

    @Order(1)
    @Test
    void findHello() {
        Assertions.assertThat(helloRepository.findHello("Toby")).isNull();
    }

    @Test
    void increaseCount() {
        Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(0);

        helloRepository.increaseCount("Toby");
        Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(1);

        helloRepository.increaseCount("Toby");
        Assertions.assertThat(helloRepository.countOf("Toby")).isEqualTo(2);
    }
}