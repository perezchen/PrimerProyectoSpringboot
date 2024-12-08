package com.chencho.curso.springboot.webapp.springboot_web.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.chencho.curso.springboot.webapp.springboot_web.models.User;


@Controller
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        User user = new User("Chencho", "Jimenez");

        user.setEmail("chencho@gmail.com");
        model.addAttribute("title", "Hola Mundo!!!");
        model.addAttribute("user", user);

        return "details"; //devuelve una pantilla html
    }

    @GetMapping("/list")
    public String list(ModelMap model) {
        List<User> users = Arrays.asList(new User("pepa", "Gonzalez"),
        new User("paco", "vela", "paco@gmail.com"),
        new User("lucas", "martin"),
        new User("pepa", "Gonzalez", "pepa@gmail.com")
        );
        
        model.addAttribute("users", users);
        model.addAttribute("title", "Listado de usuarios");
        
        return "list";
    }
    

    //// ESTA ES UNA FORMA QUE PERMITE USAR LOS MISMOS DATOS EN DISTINTOS METODOS, PARA LAS PLANTILLAS
    // @ModelAttribute("users")
    // public List<User> userModel() {
    //     List<User> users = Arrays.asList(new User("pepa", "Gonzalez"),
    //     new User("paco", "vela", "paco@gmail.com"),
    //     new User("lucas", "martin"),
    //     new User("pepa", "Gonzalez", "pepa@gmail.com")
    //     );

    //     return users;
    // }
    

}
