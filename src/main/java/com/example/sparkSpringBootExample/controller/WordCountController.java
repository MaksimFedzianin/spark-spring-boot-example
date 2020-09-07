package com.example.sparkSpringBootExample.controller;

import com.example.sparkSpringBootExample.service.MyEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordCountController {

    @Autowired
    private MyEntityService myEntityService;

    @RequestMapping(method = RequestMethod.POST, path = "/wordcount")
    public ResponseEntity<String> count() {
        myEntityService.save();
        return ResponseEntity.ok("OK");
    }
}
