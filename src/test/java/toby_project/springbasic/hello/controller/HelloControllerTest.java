package toby_project.springbasic.hello.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import toby_project.springbasic.hello.service.HelloService;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class HelloControllerTest {

    @Test
    void hello() {
        //http localhost:8080/hello?name=Spring
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res = rest.getForEntity("http://localhost:9090/app/hello?name={name}", String.class, "Spring");

        // status code 200
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
        //header(content-type) text/plain
        assertThat(res.getHeaders().getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE);
        //body Hello Spring
        assertThat(res.getBody()).isEqualTo("*Hello Spring*");
    }

    @Test
    void failsHello() {
        //http localhost:8080/hello?name=Spring
        TestRestTemplate rest = new TestRestTemplate();

        ResponseEntity<String> res = rest.getForEntity("http://localhost:9090/app/hello?name=", String.class);

        // status code 500
        assertThat(res.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Test
    void helloController() {
        HelloController helloController = new HelloController(name -> name);

        String ret = helloController.hello("Test");

        assertThat(ret).isEqualTo("Test");
    }

    @Test
    void failsHelloController() {
        HelloController helloController = new HelloController(name -> null);

        assertThatThrownBy(() -> {
            helloController.hello(null);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            helloController.hello("");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}