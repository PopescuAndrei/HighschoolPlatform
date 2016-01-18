/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.fils.highschoolplatform.domain.Professor;
import ro.fils.highschoolplatform.repository.ProfessorDAO;
import ro.fils.highschoolplatform.service.ProfessorService;
import ro.fils.highschoolplatform.service.impl.ProfessorServiceImpl;
import ro.fils.highschoolplatform.util.Encryption;

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
        return (ArrayList) professorService.getAllProfessorsDTO();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{professorId}")
    public @ResponseBody
    Professor getOneProject(@PathVariable("professorId") int professorId) {
        professorService = new ProfessorServiceImpl();
        System.out.println("getOneProj");
        return professorService.getProfessor(professorId);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    void insertProfessor(@RequestParam(value = "name", required = false) String name
            , @RequestParam(value = "email", required = false) String email
            , @RequestParam(value = "course", required = false) String course
            , @RequestParam(value = "password", required = false) String pass)
    {
        ProfessorDAO pDao = new ProfessorDAO();
        Professor p = new Professor();
        String split[] = name.split(" ");
        p.setFirstName(split[0]);
        p.setEmail(email);
        p.setPassword(Encryption.getHash(pass));
        p.setCourseId(Integer.parseInt(course));
        if(split.length > 1)
            p.setLastName(name.split(" ")[1]);
        pDao.insertProfessor(p);
    }

}
