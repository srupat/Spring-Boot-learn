package com.srujan.joblisting.controller;

import com.srujan.joblisting.repository.PostRepository;
import com.srujan.joblisting.model.Post;
import com.srujan.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
public class PostController {
    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;
    @GetMapping("/posts")
    public List<Post> getAllPosts()
    {
        return repo.findAll();
    }
    @GetMapping("/posts/{text}")
    public List<Post> search(@PathVariable String text){
        return srepo.findByText(text);
    }

    @PostMapping("/post")
    public Post submitPost(@RequestBody Post post){
        return repo.save(post);
    }
}
