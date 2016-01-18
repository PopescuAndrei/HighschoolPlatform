/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import ro.fils.highschoolplatform.domain.Course;
import ro.fils.highschoolplatform.util.DBManager;

/**
 *
 * @author andre
 */
public class CourseDAO {

    public Course getCourseByClassCourseId(int clazzCourseId) {
        try {
            Connection con = DBManager.getConnection();
            String sql = "SELECT * FROM COURSES_CLASSES INNER JOIN COURSES ON COURSES_CLASSES.COURSE_ID = COURSES.ID WHERE COURSES_CLASSES.ID = " + clazzCourseId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("ID"));
                c.setName(rs.getString("NAME"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public Course getCourseById(int courseId){
        try {
            Connection con = DBManager.getConnection();
            String sql = "SELECT * FROM COURSES INNER JOIN COURSES_CLASSES ON COURSES.ID = " + courseId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Course c = new Course();
                c.setId(rs.getInt("ID"));
                c.setName(rs.getString("NAME"));
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public boolean insertCourse(Course course){
        
        return false;
    }
}
