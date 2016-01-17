/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service;

import ro.fils.highschoolplatform.domain.Course;

/**
 *
 * @author andre
 */
public interface CourseService {
    Course getCourseByClassCourseId(int classCourseId);
    Course getCourseById(int courseId);
    Boolean addCourse(Course course);
}
