package com.gygproductions.blog.controllers;

import com.gygproductions.blog.services.StringTransformSvc;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServiceTestController {

    // injecting the StringTransformSvc
    StringTransformSvc stSvc;

    public ServiceTestController(StringTransformSvc stSvc) {
        this.stSvc = stSvc;
    }

    @GetMapping("/word/{word}")
    @ResponseBody
    public String returnFirstLetter(@PathVariable String word) {
        String firstLetter = stSvc.getFirstLetter(word);
        return "The first letter is: " + firstLetter;
    }

}