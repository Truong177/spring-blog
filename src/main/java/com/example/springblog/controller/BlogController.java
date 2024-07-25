package com.example.springblog.controller;

import com.example.springblog.model.Blog;
import com.example.springblog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("/blogs")
    public String getAllBlogs(Model model){
        List<Blog> blogs = blogService.findAll();
        model.addAttribute("blogs", blogs);
        return "blog-list";
    }

    @GetMapping("/blogs/new")
    public String createForm(Model model){
        model.addAttribute("blog", new Blog());
        return "blog-form";
    }

    @PostMapping("/blogs")
    public String createBlog(@ModelAttribute Blog blog){
        blogService.save(blog);
        return "redirect:/blogs";
    }

    @GetMapping("/blogs/{id}")
    public String getBlogById(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog-detail";
    }

    @GetMapping("/blogs/{id}/edit")
    public String updateBlogForm(@PathVariable Long id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "blog-form";
    }

    @PostMapping("/blogs/{id}")
    public String updateBlog(@PathVariable Long id, @ModelAttribute Blog blog) {
        blogService.updateBlog(id, blog);
        return "redirect:/blogs";
    }

    @GetMapping("/blogs/{id}/delete")
    public String deleteBlog(@PathVariable Long id) {
        blogService.deleteBlog(id);
        return "redirect:/blogs";
    }
}
