package com.gygproductions.blog.services;

import com.gygproductions.blog.models.Post;
import com.gygproductions.blog.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postDao;

    public PostService(PostRepository postDao) {
        this.postDao = postDao;
    }

    public Post findOne(long id) {
        return postDao.findOne(id);
    }

    public Iterable<Post> findAll() {
        return postDao.findAll();
    }

    public void save(Post post) {
        postDao.save(post);
    }

    public void delete(long id) {
        postDao.deleteById(id);
    }
}
