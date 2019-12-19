package com.an.an_be.mapper;

import com.an.an_be.entity.Blog;

import java.util.List;

public interface BlogMapper {
    int saveBlog(Blog blog) throws Exception;
    public List<Blog> findBlog() throws Exception;
    public Blog findBlogById(Blog blog) throws Exception;

}
