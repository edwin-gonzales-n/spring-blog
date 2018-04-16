package com.gygproductions.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello from Spring!";
    }

    @GetMapping("/logout")
    @ResponseBody
    public String logout(){
        return "You have been logged out";
    }

    @GetMapping("/hello/{name}/{lastname}")
    @ResponseBody
    public String sayHelloFL(@PathVariable String name, @PathVariable String lastname){
        return String.format("Hello there %s %s", name, lastname);
    }

    @RequestMapping(path = "/lights", method = RequestMethod.GET)
    @ResponseBody
    public String lights(){
        return "Lights On";
    }
}
