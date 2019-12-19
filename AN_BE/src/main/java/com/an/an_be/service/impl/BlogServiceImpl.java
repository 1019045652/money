package com.an.an_be.service.impl;

import com.an.an_be.entity.Blog;
import com.an.an_be.mapper.BlogMapper;
import com.an.an_be.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("BlogService")
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogMapper blogMapper;
    @Override
    public int saveBlog(Blog blog) throws Exception {
        return blogMapper.saveBlog(blog) ;
    }

    @Override
    public List<Blog> findBlog() throws Exception {
        return blogMapper.findBlog();
    }

    @Override
    public Blog findBlogById(Blog blog) throws Exception {
        return blogMapper.findBlogById(blog);
    }
}
