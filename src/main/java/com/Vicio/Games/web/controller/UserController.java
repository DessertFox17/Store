package com.Vicio.Games.web.controller;

import com.Vicio.Games.domain.dto.NewUserDto;
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
    public Map<String, Object> findAllUsers() {
        return userService.findAllUSers();
    }

    @GetMapping("/{uId}")
    public Map<String, Object> findUserByID(@PathVariable("uId") int uid){
        return userService.findUserByID(uid);
    }

    @PostMapping("/new")
    public Map<String, Object> newUser(@RequestBody NewUserDto newUserDto){
        return userService.newUser(newUserDto);
    }

    @PutMapping("/{uId}")
    public Map<String, Object> updateUser(@RequestBody NewUserDto newUserDto, @PathVariable("uId") int uId) {

       return userService.updateUser(newUserDto, uId);

    }

    @DeleteMapping("/{uId}")
    public Map<String, String> deleteUsers(@PathVariable("uId") int uId){

        return userService.deleteUsers(uId);
    }


}
