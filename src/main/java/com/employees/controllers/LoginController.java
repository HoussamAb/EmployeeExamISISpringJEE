package com.employees.controllers;


import com.employees.entities.ManagerEmployee;
import com.employees.entities.User;
import com.employees.services.RoleService;
import com.employees.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping({"/login"})
    public String add(ModelMap model, User user, HttpServletRequest request) {
        model.addAttribute("user", user);
        return "login";
    }
    @PostMapping({"/login"})
    public String postlogin(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model, HttpServletRequest request) {
        if(result.hasErrors()){
            model.addAttribute("user", userService.getAllUser());
            return "login";
        }
        return "redirect:/home";
    }

    @PostMapping({"/register"})
    public String postregister(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model, HttpServletRequest request) {
        if(result.hasErrors()){
            model.addAttribute("user", userService.getAllUser());
            model.addAttribute("roles", roleService.getAllroles());
            return "register";
        }
        return "redirect:/login";
    }
    @GetMapping({"/register"})
    public String register(ModelMap model, User user, HttpServletRequest request) {
        model.addAttribute("user", user);
        return "register";
    }
}
