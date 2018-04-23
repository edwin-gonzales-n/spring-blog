package com.gygproductions.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String hello() {
        return "home";
    }

    @GetMapping("/home/{name}")
    public String welcomeUser(
            @PathVariable String name,
             Model model
    ){
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/home/users")
    public String welcomeUsers(Model model){

        List<String> users = new ArrayList<>();
        users.add("Edwin");
        users.add("Gonzito");
        users.add("Manuelito");

        model.addAttribute("users", users);
        return "home";
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDiceGetGuess(@PathVariable String guess, Model model){
        Random rand = new Random();
        int  n = rand.nextInt(6) + 1;
        model.addAttribute("number",n);
        return "roll-dice";
    }

}
