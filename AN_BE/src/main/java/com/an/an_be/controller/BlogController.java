package com.an.an_be.controller;

import com.alibaba.fastjson.JSONObject;
import com.an.an_be.entity.Blog;
import com.an.an_be.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:8080",allowCredentials="true")
public class BlogController {

    @Autowired
    private BlogService blogService;

    /**
     * 发布博客
     * */
    @PostMapping("/saveBlog")
    public JSONObject saveBlog(HttpServletRequest request, HttpServletResponse response,@RequestBody Blog blog){
        JSONObject json = new JSONObject();
        try {
            UUID uuid = UUID.randomUUID();
            blog.setBlogId(uuid.toString());
            blog.setCreateDate(new Date());
            String a = request.getSession().getAttribute("userName").toString();
            blog.setUserName(request.getSession().getAttribute("userName").toString());
            blogService.saveBlog(blog);
            json.put("code","200");
        } catch (Exception e) {
            e.printStackTrace();
            json.put("code","401");
        }
        return json;
    }
    /**
     * 查询所有博客
     * */
    @RequestMapping("/getBlogList")
    public JSONObject toReadBlog(HttpServletRequest request, HttpServletResponse response){
        JSONObject json = new JSONObject();
        try {
            String a = request.getSession().getAttribute("userName").toString();
            json.put("code","200");
            json.put("blogList",blogService.findBlog());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
    /**
     * 根据博客id查询博客内容
     * */
    @RequestMapping("/findBlogById")
    public JSONObject findBlogById(@RequestBody Blog blog,HttpServletRequest request, HttpServletResponse response){
        JSONObject json = new JSONObject();
        try {
            json.put("blog",blogService.findBlogById(blog));
            json.put("code","200");
            json.put("msg","操作成功");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
