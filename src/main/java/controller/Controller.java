package controller;

import interfaceService.InterfaceUserService;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping
public class Controller {

    @Autowired
    private InterfaceUserService service;

    @GetMapping("/get")
    public String get(Model model){
        List<User> users = service.get();
        model.addAttribute("users", users);
        return "index";
    }

}
