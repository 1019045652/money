package com.an.an_be.service;

import com.an.an_be.entity.Blog;

import java.util.List;

public interface BlogService {
    public int saveBlog(Blog blog) throws Exception;
    public List<Blog> findBlog() throws Exception;
    Blog findBlogById(Blog blog)throws Exception;
}
