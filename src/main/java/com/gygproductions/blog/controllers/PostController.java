package com.gygproductions.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    public String viewPosts() {
        return "/posts/index";
    }

    @GetMapping("/posts/{id}")
    public String viewPostsById() {
        return "/posts/show";
    }

    @GetMapping("/posts/create")
    public String postsCreateForm() {
        return "/posts/show";
    }

    @PostMapping("/posts/create")
    public String postsCreate() {
        return "index";
    }

}
