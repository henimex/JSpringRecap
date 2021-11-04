package com.henimex.jspringrecap.api.controllers;

import com.henimex.jspringrecap.business.abstracts.UserService;
import com.henimex.jspringrecap.core.entities.User;
import com.henimex.jspringrecap.core.utilities.results.ErrorResult;
import com.henimex.jspringrecap.core.utilities.results.Result;
import com.henimex.jspringrecap.core.utilities.results.SuccessDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users/")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("add")
    public ResponseEntity<Result> add(User user) {
        var result = this.userService.add(user);
        if (result.isSuccess()) return ResponseEntity.ok(result);
        //return ResponseEntity.badRequest(new ErrorResult());
        //return new ResponseEntity.badRequest(500);
        return null;
    }

    @GetMapping("getByMail")
    public SuccessDataResult<User> getByMailAddress(@RequestParam String email) {
        return null;
    }
}
