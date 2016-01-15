/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.fils.highschoolplatform.domain.Professor;
import ro.fils.highschoolplatform.domain.Student;
import ro.fils.highschoolplatform.service.ProfessorService;
import ro.fils.highschoolplatform.service.StudentService;
import ro.fils.highschoolplatform.service.impl.ProfessorServiceImpl;
import ro.fils.highschoolplatform.service.impl.StudentServiceImpl;
import ro.fils.highschoolplatform.util.Encryption;

/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/loginProfessor")
public class ProfessorLoginController {

    ProfessorService professorService = new ProfessorServiceImpl();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Professor loginUser(@RequestParam("mail") String mail, @RequestParam("password") String password) {
        ArrayList<Professor> professors = (ArrayList<Professor>) professorService.findAllProfessors();
        Professor professor = null;
        for (Professor p : professors) {
            if (p.getEmail().equals(mail) && p.getPassword().equals(Encryption.getHash(password))) {
                professor = p;
                System.out.println("il gaseste");
                break;
            }
        }
        return professor;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Professor insertProfessor(@RequestBody Professor professor) {
        professorService.insertProfessor(professor);
        return professor;
    }
}
