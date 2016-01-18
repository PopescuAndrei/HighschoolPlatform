/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ro.fils.highschoolplatform.domain.Course;
import ro.fils.highschoolplatform.util.DBManager;


/**
 *
 * @author andre
 */
public class CoursesDAO {

    public Boolean insertProfessor(Course course) {
        boolean inserted = false;
        try {
            Connection conn = DBManager.getConnection();
            String sql = "insert into courses(NAME, CLASS_ID)" + " values (?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, course.getName());
            statement.setString(2, Integer.toString(course.getClassId()));
            statement.execute();
            inserted = true;
        } catch (SQLException ex) {
            Logger.getLogger(CoursesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inserted;
    }

    
    public Course getCourseById(int id) {
        Course course = null;
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from courses where ID = " + "?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                course = new Course();
                course.setId(rs.getInt("ID"));
                course.setName(rs.getString("NAME"));
                course.setClassId(rs.getInt("ClASS_ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return course;
    }
    
    public List<Course> getAll() {
        Course course = null;
        ArrayList<Course> courses = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from courses";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                course = new Course();
                course = new Course();
                course.setId(rs.getInt("ID"));
                course.setName(rs.getString("NAME"));
                course.setClassId(rs.getInt("ClASS_ID"));
                courses.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return courses;
    }
}
