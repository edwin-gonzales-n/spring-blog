package com.gygproductions.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @GetMapping("/hello/{name}")
    public String sayHelloFL(@PathVariable String name,
                Model model){
        model.addAttribute("name", name);
        return "hello";
    }

    @RequestMapping(path = "/lights", method = RequestMethod.GET)
    @ResponseBody
    public String lights(){
        return "Lights On";
    }
}
