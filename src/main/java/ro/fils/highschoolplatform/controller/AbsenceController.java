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
import ro.fils.highschoolplatform.dto.AbsenceDTO;
import ro.fils.highschoolplatform.service.AbsenceService;
import ro.fils.highschoolplatform.service.impl.AbsenceServiceImpl;

/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/absences")
public class AbsenceController {
    
    AbsenceService absenceService;

    @RequestMapping(method = RequestMethod.GET, value = "/{studentId}")
    public @ResponseBody
    ArrayList<AbsenceDTO> getAbsencesOfStudent(@PathVariable("studentId") int studentId) {
        absenceService = new AbsenceServiceImpl();
        return absenceService.getAllAbsencesForStudent(studentId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    boolean addAbsenceToStudent(@RequestParam("studentId") int studentId, @RequestParam("courseId") int courseId){
        absenceService = new AbsenceServiceImpl();
        return absenceService.addAbsenceToStudent(studentId, courseId);
    }
}
