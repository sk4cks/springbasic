package toby_project.springbasic.hello.service;

import org.springframework.stereotype.Service;
import toby_project.springbasic.hello.HelloRepository;

@Service
public class SimpleHelloService implements HelloService {
    private final HelloRepository helloRepository;

    public SimpleHelloService(HelloRepository helloRepository) {
        this.helloRepository = helloRepository;
    }

    @Override
    public String sayHello(String name){
        this.helloRepository.increaseCount(name);

        return "Hello "+name;
    }

    @Override
    public int countOf(String name) {
        return this.helloRepository.countOf(name);
    }
}
