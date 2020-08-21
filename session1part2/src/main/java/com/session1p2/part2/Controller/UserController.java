package com.session1p2.part2.Controller;

import com.session1p2.part2.Service.UserService;
import com.session1p2.part2.Shared.UserRequestModel;
import com.session1p2.part2.Shared.UserResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Transactional
    @GetMapping("/add")
    public ResponseEntity<UserResponseModel> addNewUser(@RequestBody UserRequestModel userRequestModel){
        return new ResponseEntity<UserResponseModel>(userService.addNewUser(userRequestModel), HttpStatus.OK);

    }
}
