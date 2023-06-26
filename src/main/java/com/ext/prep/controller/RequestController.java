package com.ext.prep.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/request/")
public class RequestController {


    @GetMapping("/req")
    public ResponseEntity<Result> request(){
        return ResponseEntity.ok(new Result("OK", 200));
    }

    record Result(String status, int statusCode){}
}
