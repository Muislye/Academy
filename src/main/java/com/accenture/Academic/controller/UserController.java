package com.accenture.Academic.controller;

import com.accenture.Academic.interfaceService.InterfaceUserService;
import com.accenture.Academic.model.User;


import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@RequestMapping
@org.springframework.stereotype.Controller
public class UserController {

	@Autowired
	private InterfaceUserService service;

	@GetMapping("/get")
	public String get(Model model) {
		List<User> users = service.get();
		model.addAttribute("users", users);
		return "index";
	}

	@GetMapping("/new")
	public String post(Model model) {
		model.addAttribute("user", new User());
		return "form";
	}

	@PostMapping("/save")
	public String save(@Validated User u, Model model, @RequestParam("birthdate") String birth) {
		java.util.Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
		String strDate = dateFormat.format(date);
		birth = strDate;
		service.save(u);
		return "redirect:/get";
	}

	@GetMapping("/update/{idUser}")
	public String edit(@PathVariable int idUser, Model model) {
		Optional<User> user = service.getById(idUser);
		model.addAttribute("user", user);
		return "form";
	}
	
	@GetMapping("/delete/{idUser}")
	public String delete(Model model, @PathVariable int idUser) {
		System.out.println("Esto es lo que imprime el delete: "+idUser);
		service.delete(idUser);
		return "redirect:/get";
	}
	

}