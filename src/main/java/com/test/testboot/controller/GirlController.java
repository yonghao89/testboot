package com.test.testboot.controller;


import com.test.testboot.repository.GirlRepository;
import com.test.testboot.service.GirlService;
import com.test.testboot.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class GirlController {

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;


    @RequestMapping(value = "girls", method = RequestMethod.GET)
    public List<Person> girlList() {

        return girlRepository.findAll();
    }


    //    public Person girlsAdd(@RequestParam("name") String name, @RequestParam("age") Integer age) {

    @RequestMapping(value = "girls", method = RequestMethod.POST)
    public Person girlsAdd(@Valid Person person, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        Person p = new Person();
        p.setName(person.getName());
        p.setAge(person.getAge());

//        ModelMap model
//        model.addAttribute("attnamefdfdf","atttfdsfdfsd");

//        Map<String, String> map = new HashMap<String, String>();
//        map.put("result", "后台返回index4");
//
//        ModelAndView modelAndView = new ModelAndView("carList",map);
//        modelAndView.addObject(map);
//
//        modelAndView.addObject("","");



        System.out.println("girlsAdd name:" + person.getName());
        System.out.println("girlsAdd age:" + person.getAge());

        System.out.println(p.toString());
        return girlRepository.save(p);
    }


    @RequestMapping(value = "girls/{id}", method = RequestMethod.GET)
    public Person girlsAdd(@PathVariable("id") Integer id) {


        System.out.println("id::" + id);
        //return girlRepository.findByName(name);


        //return girlRepository.findById(id).orElse(null);
        return girlRepository.findById(id).get();


    }

    @RequestMapping(value = "girls/age/{age}", method = RequestMethod.GET)
    public List<Person> findByAge(@PathVariable("age") Integer age) {


        System.out.println("age::" + age);
        //return girlRepository.findByName(name);

        return girlRepository.findByAge(age);
        //return girlRepository.findOne(new Person())

    }


    @RequestMapping(value = "girls/{id}", method = RequestMethod.DELETE)
    public void girlDelete(@PathVariable("id") Integer id) {


        System.out.println("Delete id::" + id);
        //return girlRepository.findByName(name);

        try {
            girlRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            System.out.println("Can not Delete by id :" + id);
            //return null;
        }


//        return girlRepository.deleteAll();;
        //return girlRepository.findOne(new Person())

    }

    @RequestMapping(value = "girls/{id}", method = RequestMethod.PUT)
    public Person girlUpdate(@PathVariable("id") Integer id,
                             @RequestParam("name") String name,
                             @RequestParam("age") Integer age) {

        Person p = new Person();
        p.setId(id);
        p.setName(name);
        p.setAge(age);
        System.out.println("girlUpdate id::" + id);
        //return girlRepository.findByName(name);

        return girlRepository.save(p);

    }

    @RequestMapping(value = "girls/two", method = RequestMethod.POST)
    public void girlTow() {
        System.out.println("girlTow---------");
        girlService.insertTwo();
    }


}
