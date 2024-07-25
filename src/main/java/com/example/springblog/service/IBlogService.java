package com.example.springblog.service;

import com.example.springblog.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    void save(Blog blog);
    Blog findById(Long id);
    Blog updateBlog(Long id, Blog blog);
    void deleteBlog(Long id);
}
