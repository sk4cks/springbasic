package toby_project.springbasic.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import toby_project.springbasic.hello.service.HelloService;

import java.util.Objects;

@RestController
public class HelloController {

    private final HelloService helloService;

    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("/hello")
    public String hello(String name){
        return helloService.sayHello(Objects.requireNonNull(name));
    }
}
