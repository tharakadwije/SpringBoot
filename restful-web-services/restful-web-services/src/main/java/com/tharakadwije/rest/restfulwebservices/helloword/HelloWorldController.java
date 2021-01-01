package com.tharakadwije.rest.restfulwebservices.helloword;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    //GET
    //URI hello-world
    //method - "hello-world
    @GetMapping(path="/hello-world")
    public String helloWorld(){
        return "HelloWorld";
    }

    @GetMapping(path="/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("HelloWorld");
    }

    @GetMapping(path="/hello-world-bean/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldBean(String.format("HelloWorld,%s", name));
    }
}
