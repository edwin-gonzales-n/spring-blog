
package com.example.blog.controllers;


import com.gygproductions.blog.models.Post;
import com.gygproductions.blog.models.User;
import com.gygproductions.blog.services.PostService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {

    PostService postSvc;

    public PostController(PostService postSvc) {
        this.postSvc = postSvc;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postSvc.getAllPosts());
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String show(@PathVariable long id, Model model) {
        model.addAttribute("post", postSvc.getPost(id));
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String create() {
        return "Here is the post create form...";
    }

    @PostMapping("/posts/create")
    public String insert() {
        User loggedInUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return "Inserted new post!";
    }

}