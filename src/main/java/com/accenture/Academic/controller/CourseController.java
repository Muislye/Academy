package com.accenture.Academic.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.accenture.Academic.interfaceService.InterfaceCourseService;
import com.accenture.Academic.model.Courses;

@RequestMapping
@Controller
public class CourseController {
	
	@Autowired
	private InterfaceCourseService service;
	
	@GetMapping("/courses")
	public String get(Model model) {
		List<Courses> courses = service.get();
		model.addAttribute("courses", courses);
		return "courses";
	}
	
	@GetMapping("/newCourse")
	public String post(Model model) {
		model.addAttribute("courses", new Courses());
		return "NewCourse";
	}
	
	@PostMapping("/saveCourse")
	public String save(@Validated Courses c, Model model, @RequestParam("estimatedDate") String estimated) {
		java.util.Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		estimated = strDate;
		service.save(c);
		return "redirect:/courses";
	}
	
	@GetMapping("/updateCourse/{idCourses}")
	public String edit(@PathVariable int idCourses, Model model) {
		Optional<Courses> course = service.getById(idCourses);
		model.addAttribute("courses", course);
		return "NewCourse";
	}
	
	@GetMapping("/deleteCourse/{idCourses}")
	public String delete(Model model, @PathVariable int idCourses) {
		service.delete(idCourses);
		return "redirect:/courses";
	}
	

}
