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

    @GetMapping("/{uId}")
    public Map<String, Object> findUserByID(@PathVariable("uId") int uid){
        return userService.findUserByID(uid);
    }

    @PostMapping("/new")
    public Map<String, Object> newUser(@RequestBody UserDto userDto){
        return userService.newUser(userDto);
    }

    @PutMapping("/{uId}")
    public Map<String, Object> updateUser(@RequestBody UserDto userDto, @PathVariable("uId") int uId) {

       return userService.updateUser(userDto, uId);

    }

    @DeleteMapping("/{uId}")
    public Map<String, String> deleteUsers(@PathVariable("uId") int uId){

        return userService.deleteUsers(uId);
    }


}
