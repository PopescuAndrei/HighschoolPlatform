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
@RequestMapping("/students")
public class StudentsController {

    StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Student> getAllStudents() {
        studentService = new StudentServiceImpl();
        return (ArrayList) studentService.findAllStudents();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{studentId}")
    public @ResponseBody
    Student getOneProject(@PathVariable("studentId") int studentId) {
        studentService = new StudentServiceImpl();
        return studentService.getStudent(studentId);
    }
}
