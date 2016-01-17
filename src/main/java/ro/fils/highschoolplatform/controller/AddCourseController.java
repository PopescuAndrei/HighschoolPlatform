/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ro.fils.highschoolplatform.domain.Course;
import ro.fils.highschoolplatform.service.impl.CourseServiceImpl;

/**
 *
 * @author andre
 */
@Controller
@RequestMapping("/addCourse")
public class AddCourseController {

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    boolean insertCourse(@RequestBody Course course) {
        return new CourseServiceImpl().addCourse(course);
    }
}
