package com.Vicio.Games.web.controller;

import com.Vicio.Games.domain.dto.NewUserDto;
import com.Vicio.Games.domain.service.UserService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/all")
    @ApiOperation(value = "Get all users", notes = "This endpoint gets the list of all users")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbiden")
    })
    public Map<String, Object> findAllUsers() {
        return userService.findAllUSers();
    }

    @GetMapping("/specific")
    @ApiOperation(value = "Get a specific user", notes = "This endpoint gets a user by its id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbiden"),
            @ApiResponse(code = 404, message = "Not found")
    })
    public Map<String, Object> findUserByID(@RequestParam int id){
        return userService.findUserByID(id);
    }

    @PostMapping("/new")
    @ApiOperation(value = "Create a new user", notes = "This endpoint creates a new user")
    @ApiResponses({
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 404, message = "Bad Request")
    })
    public Map<String, Object> newUser(@RequestBody NewUserDto userPayload){
        return userService.newUser(userPayload);
    }

    @PutMapping("/update")
    @ApiOperation(value = "Update an user", notes = "This endpoint updates an user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbiden"),
            @ApiResponse(code = 400, message = "Bad Request")
    })
    public Map<String, Object> updateUser(@RequestBody NewUserDto userPayload, @RequestParam int id) {

       return userService.updateUser(userPayload,id);

    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "Delete an user", notes = "This endpoint deletes an user")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 403, message = "Forbiden"),
            @ApiResponse(code = 404, message = "Not Found")
    })
    public Map<String, String> deleteUsers(@RequestParam int id){

        return userService.deleteUsers(id);
    }
}
