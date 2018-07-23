package com.mitrais.rms.controller;

import com.mitrais.rms.dao.UserDao;
import com.mitrais.rms.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("users")
public class UserController
{
    @Autowired
    UserDao userDao;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public String listUser(Model model){
        List<User> users = userDao.findAll();
        model.addAttribute("users",users);
        return "users/list";
    }

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String getAdd(Model model){
        User user = new User();
        model.addAttribute("user",user);
        return "users/form";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public String findUser(@PathVariable int id, Model model){
        Optional<User> data= userDao.findById(id);
        if(data.isPresent()){
            model.addAttribute("user",data);
            return "users/form";
        }else{
            return "redirect:" + "list";
        }
    }

    @RequestMapping(value ="/" ,method = RequestMethod.POST)
    public String save(@Valid User user){
        userDao.save(user);
        return "redirect:list";
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable int id){
        userDao.deleteById(id);
        return "redirect:list";
    }

}