/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.fils.highschoolplatform.domain.Professor;
import ro.fils.highschoolplatform.service.ProfessorService;
import ro.fils.highschoolplatform.service.impl.ProfessorServiceImpl;

/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/professors")
public class ProfessorController {
    
    ProfessorService professorService;
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Professor> getAllProfessors() {
        professorService = new ProfessorServiceImpl();
        return (ArrayList) professorService.findAllProfessors();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/{professorId}")
    public @ResponseBody
    Professor getOneProject(@PathVariable("professorId") int professorId) {
        professorService = new ProfessorServiceImpl();
        return professorService.getProfessor(professorId);
    }
}
