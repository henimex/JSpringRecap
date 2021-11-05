package com.henimex.jspringrecap.api.controllers;

import com.henimex.jspringrecap.business.abstracts.UserService;
import com.henimex.jspringrecap.core.entities.User;
import com.henimex.jspringrecap.core.utilities.results.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/users/")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("add")
    public ResponseEntity<?> add(@Valid @RequestBody User user) {
        var result = this.userService.add(user);
        if (result.isSuccess()) return ResponseEntity.ok(result);
        //return ResponseEntity.badRequest(new ErrorResult());
        //return new ResponseEntity.badRequest(500);
        return null;
    }

    @GetMapping("getByMail")
    public ResponseEntity<DataResult<User>> getByMailAddress(@RequestParam String email) {
        var result = this.userService.findByEmail(email);
        if (result.isSuccess()) return ResponseEntity.ok(result);
        return null;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors = new HashMap<String,String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors = new ErrorDataResult<>(validationErrors,"Validation Errors");
        return errors;
    }
}
