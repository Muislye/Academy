package com.accenture.Academic.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accenture.Academic.model.Academic;

@Repository
public interface InterfaceAcademic extends CrudRepository<Academic, Integer> {

}
