package com.gygproductions.blog.repositories;

import com.gygproductions.blog.models.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface PostRepository extends CrudRepository<Post, Long> {

    @Transactional
    void deleteById(Long id);

}
