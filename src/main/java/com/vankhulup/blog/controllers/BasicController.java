package com.vankhulup.blog.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Vans on 21.08.2014.
 */
@Controller
@RequestMapping("/index")
public class BasicController {

    final Logger logger = LoggerFactory.getLogger(BasicController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String getRoot(Model uiModel){
        logger.debug("We are in the root controller!!");
        uiModel.addAttribute("parameter", "Vans");
        return "/root";
    }
}
