package com.mitrais.rms.controller;

import com.mitrais.rms.dao.ProjectDao;
import com.mitrais.rms.model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("projects")
public class ProjectController {
    @Autowired
    ProjectDao projectDao;

    @RequestMapping("/list")
    public String getList(Model model){
        List<Project> data = projectDao.findAll();
        model.addAttribute("projects",data);
        return "projects/list";
    }
}
