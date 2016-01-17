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
import ro.fils.highschoolplatform.domain.Student;
import ro.fils.highschoolplatform.service.StudentService;
import ro.fils.highschoolplatform.service.impl.StudentServiceImpl;
import ro.fils.highschoolplatform.util.Encryption;

/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/loginStudent")
public class StudentLoginController {

    StudentService studentsService = new StudentServiceImpl();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Student loginUser(@RequestParam("mail") String mail, @RequestParam("password") String password) {
        ArrayList<Student> students = (ArrayList<Student>) studentsService.findAllStudents();
        Student student = null;
        for (Student s : students) {
            if (s.getEmail().equals(mail) && s.getPassword().equals(Encryption.getHash(password))) {
                student = s;
                System.out.println("il gaseste");
                break;
            }
        }
        return student;
    }
    
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Student insertStudent(@RequestBody Student student) {
        studentsService.insertStudent(student);
        return student;
    }
}