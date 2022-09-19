package com.excercise.lesson2.controller;

import com.excercise.lesson2.dto.UserDto;
import com.excercise.lesson2.entity.User;
import com.excercise.lesson2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto user){
        UserDto resultUser = userService.addUser(user);
        return null;
    }

    @GetMapping("/getAllUser")
    public ResponseEntity<List<UserDto>> getAllUser(){
        List<UserDto> users = userService.getAllUser();
        return null;
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable ("id") Long id){
        UserDto user = userService.getUser(id);
        return ResponseEntity.ok(user);

    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long id,
                                           @RequestBody UserDto user){
        UserDto resultUser = userService.updateUser(id,user);
        return ResponseEntity.ok(resultUser);

    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
        Boolean status = userService.deleteUser(id);
        return ResponseEntity.ok(status);

    }



}
