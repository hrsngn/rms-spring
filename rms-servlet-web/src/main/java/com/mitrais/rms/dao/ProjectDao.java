package com.mitrais.rms.dao;

import com.mitrais.rms.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDao extends JpaRepository<Project,Integer> {

}
