package com.vankhulup.blog.controllers;

import com.vankhulup.blog.models.User;
import com.vankhulup.blog.service.UserManagementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigInteger;

/**
 * Created by Vans on 22.08.2014.
 */
@Controller(value = "/users")
public class UsersController {

    private static final Logger logger = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    UserManagementService service;

    @RequestMapping(method = RequestMethod.GET)
    public String getAll(Model uiModel){
        uiModel.addAttribute("users", service.getAllUsers());
        return "/users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/add")
    public String getAddForm(Model uiModel){
        User user = new User();
        user.setRole(User.ROLES.ROLE_USER);
        uiModel.addAttribute("user", user);
        return "/add_user_form";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public String addUser(@ModelAttribute("user") User user){
        service.saveUser(user);
        return "redirect:/users";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit")
    public ModelAndView showEditForm(@RequestParam(required = true) BigInteger id){
        return new ModelAndView("/add_user_form", "user", service.getUserById(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) String errorMsg,
                               @RequestParam(value = "msg", required = false) String msg,
                               Model uiModel){
        if (errorMsg != null){
            uiModel.addAttribute("error", "Incorrect credentials! Please, try again");
        }
        if (msg !=null){
            uiModel.addAttribute("msg", "Logged out");
        }
        return "/login";
    }
}
