package toby_project.springbasic.hello.service;

public interface HelloService {
    String sayHello(String name);

    default int countOf(String name){
        return 0;
    }
}
