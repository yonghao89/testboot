package com.test.testboot.controller;


import com.test.testboot.properties.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 *
 */

//@RestController
//@Controller

@ResponseBody
@Controller
public class HelloController {

    @Value("${cupSize}")
    private String cupSize;

    @Value("${age}")
    private int age;

    @Autowired
    private Girl girl;


    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String SayHi() {


//        System.out.println("id:"+id);
        System.out.println("Girl Info getAge:"+girl.getAge()+"   getCupSize:"+girl.getCupSize());

        System.out.println("Say Hello My Spring Boot cupSize: " + cupSize +"  age:"+ age);

        return "Say Hello My Spring Boot cupSize: " + cupSize + age;
    }
}
//@PathVariable(value = "mid",required = false) Integer id

//RequestParam(value = "mid",required = false,defaultValue = "98"