package com.accenture.Academic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.Academic.interfaceService.InterfaceCourseService;
import com.accenture.Academic.interfaces.InterfaceCourse;
import com.accenture.Academic.model.Courses;

@Service
public class CourseService implements InterfaceCourseService {
	
	@Autowired
	private InterfaceCourse data;

	@Override
	public List<Courses> get() {

		return (List<Courses>) data.findAll();
	}

	@Override
	public Optional<Courses> getById(int idCourse) {
		// TODO Auto-generated method stub
		 return data.findById(idCourse);
	}

	@Override
	public int save(Courses c) {
        int res=0;
        Courses course = data.save(c);
        if(!course.equals(null)){
            res=1;
        }
        return res;
	}

	@Override
	public void delete(int idCourse) {
		data.deleteById(idCourse);
	}

}
