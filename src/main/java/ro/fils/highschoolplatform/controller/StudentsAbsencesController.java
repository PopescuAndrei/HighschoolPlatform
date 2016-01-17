/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.controller;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.fils.highschoolplatform.dto.StudentWithAbsenceDTO;
import ro.fils.highschoolplatform.dto.StudentWithGradeDTO;
import ro.fils.highschoolplatform.service.StudentService;
import ro.fils.highschoolplatform.service.impl.StudentServiceImpl;

/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/studentsAbsencesClass")
public class StudentsAbsencesController {
    
    StudentService stdService;
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<StudentWithAbsenceDTO> getStudentClazz(@RequestParam("classId") int classId, @RequestParam("courseId") int courseId) {
        stdService = new StudentServiceImpl();
        return (ArrayList) stdService.getAllStudentsAbsencesInClassInCourse(classId,courseId);
    }
}
