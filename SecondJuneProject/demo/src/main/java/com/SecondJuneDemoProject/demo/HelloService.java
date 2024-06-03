package com.SecondJuneDemoProject.demo;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@RestController

public class HelloService{
    @RequestMapping(value="/hello",method = RequestMethod.GET)
    
    public String SayHello(){
        return "Hello from the service";
    };

    @RequestMapping(value="/user/{id}",method = RequestMethod.PUT)
    public String ModifyUser(@PathVariable("id") String ID){
        return "User modified " + ID;
    };

    @RequestMapping(value="/user/{id}",method = RequestMethod.GET)
    public String GettingUser(@PathVariable("id") String ID){
        return "User name is : " + ID;
    };

}