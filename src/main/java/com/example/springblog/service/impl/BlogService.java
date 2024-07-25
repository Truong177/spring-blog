package com.example.springblog.service.impl;

import com.example.springblog.model.Blog;
import com.example.springblog.repository.IBlogRepository;
import com.example.springblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public Blog updateBlog(Long id, Blog blog) {
        Blog existingBlog = blogRepository.findById(id).orElse(null);
        if (existingBlog != null) {
            existingBlog.setTitle(blog.getTitle());
            existingBlog.setContent(blog.getContent());
            return blogRepository.save(existingBlog);
        }
        return null;
    }

    @Override
    public void deleteBlog(Long id) {
        blogRepository.deleteById(id);
    }
}
