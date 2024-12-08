package com.chencho.curso.springboot.webapp.springboot_web.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chencho.curso.springboot.webapp.springboot_web.models.User;
import com.chencho.curso.springboot.webapp.springboot_web.models.dto.UserDto;

@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public UserDto details(){

        UserDto userDto = new UserDto();
        User user = new User("Chencho", "Jimenez");
        userDto.setUser(user);
        userDto.setTitle("Hola Mundo con DTOi!!!");



        return userDto;
    }

    @GetMapping("/list")
    public List<User> list() {
        User user1 = new User("Chencho", "Jimenez");
        User user2 = new User("Inocencio", "Galvez");
        User user3 = new User("Marta", "Perez");

        List<User> users = new ArrayList<>();
        users = Arrays.asList(user1, user2, user3);

        // users.add(user1);
        // users.add(user2);
        // users.add(user3);

        return users;
    }

    @GetMapping("/details-map")
    public Map<String, Object> detailsMap(){

        User user = new User("Chencho", "Jimenez");

        Map<String, Object> body = new HashMap<>();

        body.put("title", "Hola Mundo con map!!!");
        body.put("user", user);

        return body;
    }
}
