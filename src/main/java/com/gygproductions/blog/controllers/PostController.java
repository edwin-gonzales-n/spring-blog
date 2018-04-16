package com.gygproductions.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {

    @GetMapping("/posts")
    @ResponseBody
    public String viewPosts() {
        return "This is the post index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String viewPostsById() {
        return "View an individual post.";
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String postsCreateForm() {
        return "View the form for creating a post.";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String postsCreate() {
        return "create a new post";
    }

}
