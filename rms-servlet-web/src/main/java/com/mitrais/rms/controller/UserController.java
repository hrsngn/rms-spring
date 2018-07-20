package com.mitrais.rms.controller;

import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("user")
public class UserController
{
    @Autowired
    UserDao userDao;

    @RequestMapping("/list")
    public String listUser(Model model){
        List<User> users = userDao.findAll();
        model.addAttribute("users",users);
        return "user/list";
    }

    @RequestMapping("/{id}")
    public String findUser(@PathVariable int id, Model model){
        Optional<User> data= userDao.findById(id);
        if(data.isPresent()){
            model.addAttribute("users",data);
            return "user/form";
        }else{
            return "redirect:" + "list";
        }
    }

}