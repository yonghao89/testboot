package com.test.testboot.service;

import com.test.testboot.domain.Person;
import com.test.testboot.repository.GirlRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class GirlService {


    @Autowired
    private GirlRepository girlRepository;


    @Transactional
    public void insertTwo() {

        Person personA = new Person();
        personA.setName("pA");
        personA.setAge(23);
        girlRepository.save(personA);

        Person personB = new Person();
        personB.setName("pBBBBBBBBBBBBBBBBBBBBBBBBBB");
        personB.setAge(43);

        girlRepository.save(personB);

    }

}
