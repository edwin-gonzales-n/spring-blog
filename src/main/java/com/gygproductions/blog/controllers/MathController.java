package com.gygproductions.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @GetMapping("/add/{a}/and/{b}")
    @ResponseBody
    public String addition(@PathVariable int a, @PathVariable int b) {
        return String.format("The addition of %s and %s is %s", a, b, (a+b));
    }

    @GetMapping("/subtract/{a}/from/{b}")
    @ResponseBody
    public String subtraction(@PathVariable int a, @PathVariable int b) {
        return String.format("The subtraction of %s from %s is %s", a, b, (b-a));
    }

    @GetMapping("/multiply/{a}/and/{b}")
    @ResponseBody
    public String multiplication(@PathVariable int a, @PathVariable int b) {
        return String.format("The multiplication of %s and %s is %s", a, b, (a*b));
    }

    @GetMapping("/divide/{a}/by/{b}")
    @ResponseBody
    public String division(@PathVariable int a, @PathVariable int b) {
        return String.format("The division of %s by %s is %s", a, b, (a/b));
    }

}
