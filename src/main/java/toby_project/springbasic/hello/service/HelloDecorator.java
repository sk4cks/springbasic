package toby_project.springbasic.hello.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import toby_project.springbasic.hello.service.HelloService;

@Service
@Primary
public class HelloDecorator implements HelloService {
    private final HelloService helloService;

    public HelloDecorator(HelloService helloService) {
        this.helloService = helloService;
    }

    @Override
    public String sayHello(String name) {
        return "*"+this.helloService.sayHello(name)+"*";
    }

    @Override
    public int countOf(String name) {
        return this.helloService.countOf(name);
    }
}
