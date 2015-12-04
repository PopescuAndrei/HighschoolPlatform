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
import org.springframework.web.bind.annotation.ResponseBody;
import ro.fils.highschoolplatform.dto.GradeDTO;
import ro.fils.highschoolplatform.service.GradeService;
import ro.fils.highschoolplatform.service.impl.GradeServiceImpl;

/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/grades")
public class GradeController {
    GradeService gradeService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/{studentId}")
    public @ResponseBody
    ArrayList<GradeDTO> getGradesOfStudent(@PathVariable("studentId") int studentId) {
        gradeService = new GradeServiceImpl();
        return gradeService.getAllGradesForStudent(studentId);
    }
}
