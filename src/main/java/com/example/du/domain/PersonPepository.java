package com.example.du.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource
public interface PersonPepository extends JpaRepository<Person,Long> {
    List<Person> findAllByName(String name);
    Person findDistinctByIdContaining(Long id);
}
