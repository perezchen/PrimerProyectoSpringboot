package com.chencho.curso.springboot.webapp.springboot_web.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chencho.curso.springboot.webapp.springboot_web.models.User;
import com.chencho.curso.springboot.webapp.springboot_web.models.dto.ParamDto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;    

    @Value("${config.message}")
    private String message;
    
    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    
    @Value("${config.code}")
    private Integer code;

    //Se pueden usar expresiones para trabajar sobre los dtaos inyectados
    @Value("#{'${config.username}'.toUpperCase()}")
    private String usernameUpper;

    @Value("#{${config.valuesMap}}")
    private Map<String, Object> valuesMap;

    @Autowired
    private Environment environment;


    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message) {
        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;
    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> getmixPathVar(@PathVariable String product, @PathVariable Integer id) {
        
        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id", id);
    
        return json;
    }


    @PostMapping("/create")
    public User create(@RequestBody User user) {
        user.setName(user.getName().toUpperCase());

        return user;
    }
    

    @GetMapping("/values")
    public Map<String, Object> values() {
        Map<String, Object> json = new HashMap<>();
        json.put("username", username);
        json.put("code", code);
        json.put("message", message);
        json.put("listOfValues", listOfValues);
        json.put("usernameUpper", usernameUpper);
        json.put("valuesMap", valuesMap);
        
        json.put("username2", environment.getProperty("config.message"));
        json.put("code2", environment.getProperty("config.code", Integer.class)); // para convertir el valor a Integer
        
        return json;
    }
    
    

    
}
