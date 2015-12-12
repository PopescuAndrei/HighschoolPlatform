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
import ro.fils.highschoolplatform.domain.Student;
import ro.fils.highschoolplatform.service.StudentService;
import ro.fils.highschoolplatform.service.impl.StudentServiceImpl;

/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/studentsClass")
public class StudentsInClassController {
    
    StudentService stdService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/{classId}")
    public @ResponseBody
    ArrayList<Student> getStudentClazz(@PathVariable("classId") int classId) {
        stdService = new StudentServiceImpl();
        return (ArrayList) stdService.getAllStudentsInClass(classId);
    }
}
