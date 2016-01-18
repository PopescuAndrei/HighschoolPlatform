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
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ro.fils.highschoolplatform.domain.Absence;
import ro.fils.highschoolplatform.domain.Grade;
import ro.fils.highschoolplatform.domain.Student;
import ro.fils.highschoolplatform.dto.StudentWithAbsenceDTO;
import ro.fils.highschoolplatform.dto.StudentWithGradeDTO;
import ro.fils.highschoolplatform.util.DBManager;
import ro.fils.highschoolplatform.util.Encryption;

/**
 *
 * @author andre
 */
public class StudentDAO {

    public Boolean insertStudent(Student student) {
        boolean inserted = false;
        try {
            Connection conn = DBManager.getConnection();
            String sql = "insert into students(PASSWORD, FIRST_NAME, LAST_NAME, EMAIL,CLASS_ID)" + " values (?,?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, student.getPassword());
            statement.setString(2, student.getFirstName());
            statement.setString(3, student.getLastName());
            statement.setString(4, student.getEmail());
            statement.setString(5, Integer.toString(student.getClassId()));
            statement.execute();
            inserted = true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inserted;
    }

    public boolean studentExists(String email) {
        boolean found = false;
        try {
            Connection con = DBManager.getConnection();
            String sql = "select EMAIL from students";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (email.equals(rs.getString("EMAIL")) == true) {
                    found = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return found;
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
    
    public List<StudentWithGradeDTO> getAllStudentsInClassAtCourse(int classId, int courseId) {
        StudentWithGradeDTO student = null;
        ArrayList<StudentWithGradeDTO> students = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from STUDENTS where CLASS_ID = " + classId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                double mean = 0;
                int no = 0;
                student = new StudentWithGradeDTO();
                student.setEmail(rs.getString("EMAIL"));
                student.setFirstName(rs.getString("FIRST_NAME"));
                student.setLastName(rs.getString("LAST_NAME"));
                student.setPassword(rs.getString("PASSWORD"));
                student.setId(rs.getInt("ID"));
                ArrayList<Grade> arrayList = new GradeDAO().getGradesOfStudentInCourse(student.getId(),courseId);
                student.setGradesList(arrayList);
                for(Grade g : arrayList){
                    mean = mean+ g.getValue();
                    no++;
                }
                student.setMean(mean/no);
                students.add(student);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
    
    
    public List<StudentWithAbsenceDTO> getAllStudentsAndAbsencesInClassAtCourse(int classId, int courseId) {
        StudentWithAbsenceDTO student = null;
        ArrayList<StudentWithAbsenceDTO> students = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from STUDENTS where CLASS_ID = " + classId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                student = new StudentWithAbsenceDTO();
                student.setEmail(rs.getString("EMAIL"));
                student.setFirstName(rs.getString("FIRST_NAME"));
                student.setLastName(rs.getString("LAST_NAME"));
                student.setPassword(rs.getString("PASSWORD"));
                student.setId(rs.getInt("ID"));
                ArrayList<Absence> arrayList = new GradeDAO().getAbsencesOfStudentInCourse(student.getId(),courseId);
                student.setAbsencesList(arrayList);
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }
}
