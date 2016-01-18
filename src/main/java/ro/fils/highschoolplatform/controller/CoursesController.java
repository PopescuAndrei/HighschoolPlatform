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
import ro.fils.highschoolplatform.domain.Course;
import ro.fils.highschoolplatform.domain.Professor;
import ro.fils.highschoolplatform.repository.CoursesDAO;


/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/courses")
public class CoursesController {

    CoursesDAO coursesDAO = new CoursesDAO();

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Professor> getAllCourses() {
       
        System.out.println("Courses controller "+coursesDAO.getAll().size());
        return (ArrayList) coursesDAO.getAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{courseId}")
    public @ResponseBody
    Course getOneCourse(@PathVariable("courseId") int courseId) {
        
        return coursesDAO.getCourseById(courseId);
    }
}
