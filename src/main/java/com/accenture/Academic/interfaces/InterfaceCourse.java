package com.accenture.Academic.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accenture.Academic.model.Courses;

@Repository
public interface InterfaceCourse extends CrudRepository<Courses, Integer> {

}
