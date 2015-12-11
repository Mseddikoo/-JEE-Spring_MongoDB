package com.vankhulup.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Vans on 22.08.2014.
 */
@RequestMapping("/")
@Controller
public class StaticContentController {

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String getLinkOne(){
        return "/static/about";
    }

    @RequestMapping(value = "/contacts", method = RequestMethod.GET)
    public String getLinkTwo(){
        return "/static/contacts";
    }

}
