package com.accenture.Academic.interfaceService;

import java.util.List;
import java.util.Optional;
import com.accenture.Academic.model.Courses;

public interface InterfaceCourseService {
	
    public List<Courses> get();
    public Optional<Courses> getById(int idCourse);
    public int save(Courses c);
    public void delete(int idCourse);
    
}
