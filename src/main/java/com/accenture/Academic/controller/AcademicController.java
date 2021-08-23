package com.accenture.Academic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.Academic.interfaceService.InterfaceCourseService;
import com.accenture.Academic.interfaceService.InterfaceUserService;
import com.accenture.Academic.interfaces.InterfaceAcademic;
import com.accenture.Academic.interfaces.InterfaceCourse;
import com.accenture.Academic.interfaces.InterfaceUser;
import com.accenture.Academic.model.Academic;
import com.accenture.Academic.model.Courses;
import com.accenture.Academic.model.User;

@RequestMapping
@Controller
public class AcademicController {
	
	@Autowired
	InterfaceAcademic academic;
	@Autowired
	InterfaceUserService usersS;
	@Autowired
	InterfaceCourseService coursesS;
	
	@GetMapping("/academic")
	public String getAcademic(Model model) {
		model.addAttribute("academics", academic.findAll());
		return "academic";
	}
	
	@GetMapping("/newAcademic")
	public String newAcademy(Model model) {
		model.addAttribute("academic", new Academic());
		List<User> users = usersS.get();
		model.addAttribute("users", users);
		List<Courses> courses = coursesS.get();
		model.addAttribute("courses", courses);
		return "NewAcademic";
	}
	
	@PostMapping("/saveAcademic")
	public String saveAcademy(@Validated Academic a, Model model) {
		System.out.println("Este es lo que se va a guardar: " +a.toString());
		System.out.println(model);
		System.out.println(a.getUsers());
		academic.save(a);
		return "redirect:/academic";
	}
}