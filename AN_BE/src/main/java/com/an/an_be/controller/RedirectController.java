package com.an.an_be.controller;

import com.an.an_be.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
/**
 * 页面跳转Controller
 * */
@Controller
public class RedirectController {

    @Autowired
    private BlogService blogService;

    @RequestMapping("/")
    public String toIndex(){
        return "login";
    }
    @RequestMapping("/toPlan")
    public String toPlan(){
        return "plan/plan";
    }

    @RequestMapping("/toWriteBlog")
    public String toWriteBlog(){
        return "blog/writeBlog";
    }

    @RequestMapping("/toRead")
    public String toReadBlog(HttpServletRequest request){
        try {
            request.setAttribute("blogList",blogService.findBlog());
            System.out.println(blogService.findBlog());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "blog/readBlog";
    }


}
