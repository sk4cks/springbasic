package toby_project.springbasic.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import toby_project.springbasic.hello.service.SimpleHelloService;

import java.util.Objects;

public class HelloController {

    public String hello(String name){
        SimpleHelloService helloService = new SimpleHelloService();

        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
