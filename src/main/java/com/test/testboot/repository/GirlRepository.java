package com.test.testboot.repository;

import com.test.testboot.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GirlRepository extends JpaRepository<Person,Integer> {

    public List<Person> findByAge(Integer age);

}
