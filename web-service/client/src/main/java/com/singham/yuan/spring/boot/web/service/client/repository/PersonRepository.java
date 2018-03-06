package com.singham.yuan.spring.boot.web.service.client.repository;

import com.singham.yuan.spring.boot.web.service.client.model.db.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person getById(Long id);

    Person getByName(String name);
}
