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
import ro.fils.highschoolplatform.domain.Clazz;
import ro.fils.highschoolplatform.domain.Professor;
import ro.fils.highschoolplatform.util.DBManager;

/**
 *
 * @author andre
 */
public class ClazzDAO {

    public Boolean insertClazz(Clazz clazz) {
        boolean inserted = false;
        try {
            Connection conn = DBManager.getConnection();
            String sql = "insert into classes(NAME)" + " values (?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, clazz.getName());
            statement.execute();
            inserted = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inserted;
    }

    public List<Clazz> getAllClazzez() {
        Clazz clazz = null;
        ArrayList<Clazz> clazzes = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from classes";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                clazz = new Clazz();
                clazz.setId(rs.getInt("ID"));
                clazz.setName(rs.getString("NAME"));
                clazzes.add(clazz);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clazzes;
    }

    public Clazz getClazz(int id) {
        Clazz clazz = null;
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from classes WHERE ID = " + id;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                clazz = new Clazz();
                clazz.setId(rs.getInt("ID"));
                clazz.setName(rs.getString("NAME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clazz;
    }
    
    public Clazz getStudentClazz(int studentId) {
        Clazz clazz = null;
        try {
            Connection con = DBManager.getConnection();
            String sql = "select classes.ID, classes.NAME from classes inner join STUDENTS on classes.ID = STUDENTS.CLASS_ID where STUDENTS.ID = " + studentId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                clazz = new Clazz();
                clazz.setId(rs.getInt("ID"));
                clazz.setName(rs.getString("NAME"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clazz;
    }
    
    public ArrayList<Clazz> getClazzesOfProfessor(int professorId) {
        ArrayList<Clazz> clazzes = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "SELECT * FROM classes INNER JOIN COURSES_classes on classes.ID = COURSES_classes.CLASS_ID WHERE COURSES_classes.COURSE_ID = " + professorId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Clazz clazz = new Clazz();
                clazz.setId(rs.getInt("ID"));
                clazz.setName(rs.getString("NAME"));
                clazzes.add(clazz);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clazzes;
    }
    
    
    public int getClazzCoursesTable(int clazzId, int courseId){
       ArrayList<Clazz> clazzes = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "SELECT * FROM COURSES_CLASSES WHERE CLASS_ID = " + clazzId + " AND COURSE_ID = " + courseId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt("ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
}
