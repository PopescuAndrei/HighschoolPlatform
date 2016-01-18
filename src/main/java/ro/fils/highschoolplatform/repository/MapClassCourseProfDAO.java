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
import ro.fils.highschoolplatform.domain.Student;
import ro.fils.highschoolplatform.util.DBManager;
import ro.fils.highschoolplatform.util.Encryption;

/**
 *
 * @author andre
 */
public class MapClassCourseProfDAO {

    public Boolean update(int class_id,int course_id, int professor_id) {
        boolean inserted = false;
        try {
            Connection conn = DBManager.getConnection();
            String update = "UPDATE courses_classes SET PROFESSOR_ID=? WHERE CLASS_ID=? AND COURSE_ID =?;";
            String insert = "insert into courses_classes (CLASS_ID,COURSE_ID,PROFESSOR_ID) VALUES(?,?,?);";
            PreparedStatement statement = conn.prepareStatement(update);
            statement.setInt(1, professor_id);
            statement.setInt(2, class_id);
            statement.setInt(3, course_id);
            if(statement.executeUpdate() == 0 )
            {
                PreparedStatement insertStmt = conn.prepareStatement(insert);
                insertStmt.setInt(1, class_id);
                insertStmt.setInt(2, course_id);
                insertStmt.setInt(3, professor_id);
                insertStmt.execute();
            }
            
            inserted = true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inserted;
    }

    public int findProfessor(int class_id, int course_id) {
        
        int id = 0;
        try {
            Connection con = DBManager.getConnection();
            String sql = " SELECT PROFESSOR_ID from courses_classes WHERE CLASS_ID =? AND COURSE_ID=?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, class_id);
            st.setInt(2, course_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                id = rs.getInt("PROFESSOR_ID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public boolean loginStudent(String email, String password) {
        boolean found = false;
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from students where EMAIl = '" + email + "' and PASSWORD ='" + Encryption.getHash(password) + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (email.equals(rs.getString("EMAIL")) == true && Encryption.getHash(password).equals(rs.getString("PASSWORD")) == true) {
                    found = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return found;
    }

    public Student getStudentByEmail(String email) {
        Student student = null;
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from students where EMAIL = " + "?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setEmail(rs.getString("EMAIL"));
                student.setFirstName(rs.getString("FIRST_NAME"));
                student.setLastName(rs.getString("LAST_NAME"));
                student.setPassword(rs.getString("PASSWORD"));
                student.setId(rs.getInt("ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }

    public Student getStudentById(int id) {
        Student student = null;
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from students where ID = " + "?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                student = new Student();
                student.setEmail(rs.getString("EMAIL"));
                student.setFirstName(rs.getString("FIRST_NAME"));
                student.setLastName(rs.getString("LAST_NAME"));
                student.setPassword(rs.getString("PASSWORD"));
                student.setId(rs.getInt("ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return student;
    }

    public List<Student> getAll() {
        Student student = null;
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                student = new Student();
                student.setEmail(rs.getString("EMAIL"));
                student.setFirstName(rs.getString("FIRST_NAME"));
                student.setLastName(rs.getString("LAST_NAME"));
                student.setPassword(rs.getString("PASSWORD"));
                student.setClassId(rs.getInt("CLASS_ID"));
                student.setId(rs.getInt("ID"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    public List<Student> getAllStudentsInClass(int classId) {
        Student student = null;
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from students where CLASS_ID = " + classId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                student = new Student();
                student.setEmail(rs.getString("EMAIL"));
                student.setFirstName(rs.getString("FIRST_NAME"));
                student.setLastName(rs.getString("LAST_NAME"));
                student.setPassword(rs.getString("PASSWORD"));
                student.setId(rs.getInt("ID"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
}
