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
import ro.fils.highschoolplatform.domain.Student;
import ro.fils.highschoolplatform.repository.ProfessorDAO;
import ro.fils.highschoolplatform.repository.StudentDAO;
import ro.fils.highschoolplatform.service.StudentService;
import ro.fils.highschoolplatform.service.impl.StudentServiceImpl;
import ro.fils.highschoolplatform.util.Encryption;

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
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    void insertStudent(@RequestParam(value = "name", required = false) String name
            , @RequestParam(value = "email", required = false) String email
            , @RequestParam(value = "clazz", required = false) String clazz
            , @RequestParam(value = "password", required = false) String pass)
    {
        StudentDAO sDao = new StudentDAO();
        Student s = new Student();
        String split[] = name.split(" ");
        s.setFirstName(split[0]);
        s.setEmail(email);
        s.setClassId(Integer.parseInt(clazz));
        s.setPassword(Encryption.getHash(pass));
       
        if(split.length > 1)
            s.setLastName(name.split(" ")[1]);
        sDao.insertStudent(s);
    }
}
