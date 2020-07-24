package com.employees.controllers;


import com.employees.entities.ManagerEmployee;
import com.employees.entities.User;
import com.employees.formaters.RoleFormater;
import com.employees.services.RoleService;
import com.employees.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class LoginController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @InitBinder
    private void customizeBinding (WebDataBinder binder) {
        binder.registerCustomEditor(String.class,"roles", new RoleFormater());
    }

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
        User u = userService.findByEmailAndPassword(user.getEmail(),user.getPassword());
        if(u != null){
            return "redirect:/home";
        }else {
            model.addAttribute("msg","utilisateur introuvable !");
            return "login";
        }

    }

    @PostMapping({"/register"})
    public String postregister(@Valid @ModelAttribute("user") User user, BindingResult result, ModelMap model, HttpServletRequest request) {
        if(result.hasErrors()){
            model.addAttribute("user", userService.getAllUser());
            model.addAttribute("roles", roleService.getAllroles());
            return "register";
        }
        userService.save(user);
        return "redirect:/auth/login";
    }
    @GetMapping({"/register"})
    public String register(ModelMap model, User user, HttpServletRequest request) {
        model.addAttribute("roles", roleService.getAllroles());
        model.addAttribute("user", user);
        return "register";
    }
}
