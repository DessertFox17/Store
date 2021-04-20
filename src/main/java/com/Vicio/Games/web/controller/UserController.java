package com.Vicio.Games.web.controller;

import com.Vicio.Games.domain.dto.UserDto;
import com.Vicio.Games.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public Map<String, Object> findAllUSers() {
        return userService.findAllUSers();
    }

    @GetMapping("/{id}")
    public Map<String, Object> findUserByID(@PathVariable("id") int uid){
        return userService.findUserByID(uid);
    }

    @PostMapping("/new")
    public Map<String, Object> newUser(@RequestBody UserDto userDto){
        return userService.newUser(userDto);
    }

    @PutMapping("/{id}")
    public Map<String, Object> updateUser(@RequestBody UserDto userDto, @PathVariable("id") int id) {

       return userService.updateUser(userDto, id);

    }

}
