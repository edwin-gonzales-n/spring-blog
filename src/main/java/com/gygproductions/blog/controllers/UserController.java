package com.gygproductions.blog.controllers;

import com.gygproductions.blog.models.User;
import com.gygproductions.blog.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private UserRepository usersDao;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository usersDao, PasswordEncoder passwordEncoder) {
        this.usersDao = usersDao;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/sign-up")
    public String showSignUpForm(Model model) {
                User user = new User();
                model.addAttribute("user", user);
                return "users/sign-up";
            }

    @PostMapping("/sign-up")
    public String registerUser(@ModelAttribute User user) {
                String hash = passwordEncoder.encode(user.getPassword());
                user.setPassword(hash);
                usersDao.save(user);
                return "redirect:/login";
    }

//    @GetMapping("/login")
//    public String showLoginForm() {
//               return "users/login";
//            }
}
