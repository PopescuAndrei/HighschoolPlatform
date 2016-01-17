/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ro.fils.highschoolplatform.domain.Course;
import ro.fils.highschoolplatform.domain.Professor;
import ro.fils.highschoolplatform.repository.CourseDAO;
import ro.fils.highschoolplatform.repository.ProfessorDAO;
import ro.fils.highschoolplatform.service.CourseService;
import ro.fils.highschoolplatform.util.DBManager;

/**
 *
 * @author andre
 */
public class CourseServiceImpl implements CourseService{

    @Override
    public Course getCourseByClassCourseId(int classCourseId) {
        return new CourseDAO().getCourseByClassCourseId(classCourseId);
    }
    
    @Override
    public Course getCourseById(int courseId){
        return new CourseDAO().getCourseById(courseId);
    }
    
    @Override
    public Boolean addCourse(Course newCourse){
        boolean inserted = false;
        try {
            Connection conn = DBManager.getConnection();
            String sql = "insert into COURSE(NAME)" + " values (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, newCourse.getName());
            statement.execute();
            inserted = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inserted;
    }
}
