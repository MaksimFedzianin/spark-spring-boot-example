package com.example.sparkSpringBootExample.controller;

import com.example.sparkSpringBootExample.service.BasicElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SparkParserController {

    @Autowired
    private BasicElementService basicElementService;

    @RequestMapping(method = RequestMethod.POST, path = "/parse")
    public ResponseEntity<String> parse() {
        basicElementService.save();
        return ResponseEntity.ok("OK");
    }
}
