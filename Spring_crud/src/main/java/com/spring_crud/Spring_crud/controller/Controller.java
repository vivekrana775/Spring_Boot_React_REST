package com.spring_crud.Spring_crud.controller;

import com.spring_crud.Spring_crud.entities.Users;
import com.spring_crud.Spring_crud.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {
    @Autowired //automatically create object
    private UserService userService;
    @GetMapping("/home")
    public String home(){

        return "This is home Page";
    }

    @GetMapping("/users")
    public List<Users> getUsers(){
        return this.userService.getUsers();
    }

    @PostMapping("register")
    public Users addUser(@RequestBody Users user){

        return this.userService.addUser(user);
    }

    @PostMapping("login")
    public boolean findUser(@RequestBody Users user){

        return this.userService.findUser(user);

    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable String userId){
        try{
            this.userService.deleteUser(Long.parseLong(userId));
            return new ResponseEntity<>(HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
