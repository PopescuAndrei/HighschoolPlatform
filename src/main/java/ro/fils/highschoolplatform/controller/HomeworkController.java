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
import ro.fils.highschoolplatform.domain.Homework;
import ro.fils.highschoolplatform.dto.HomeworkDTO;
import ro.fils.highschoolplatform.service.HomeworkService;
import ro.fils.highschoolplatform.service.impl.HomeworkServiceImpl;

/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/homework")
public class HomeworkController {
    
    private HomeworkService hwService;
    
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    Boolean addHomework(@RequestParam("clazzId") String clazzId, @RequestParam("courseId") int courseId, @RequestParam("description") String description, @RequestParam("dueDate") String dueDate) {
        boolean result = false;
        hwService = new HomeworkServiceImpl();
        return hwService.insertHomework(courseId, courseId, description, dueDate);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<HomeworkDTO> getAllHomeworksForStudent(@RequestParam("studentId") int studentId){
        hwService = new HomeworkServiceImpl();
        return hwService.getAllHomeworksForStudent(studentId);
    }
    
    
    @RequestMapping(method = RequestMethod.GET, value = "/{homeworkId}")
    public @ResponseBody
    HomeworkDTO getOneHomework(@PathVariable("homeworkId") int homeworkId){
        hwService = new HomeworkServiceImpl();
        System.out.println("cauta hw");
        return hwService.getOneHomework(homeworkId);
    }
}