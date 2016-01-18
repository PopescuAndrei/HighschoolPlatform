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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ro.fils.highschoolplatform.domain.Absence;
import ro.fils.highschoolplatform.domain.Grade;
import ro.fils.highschoolplatform.dto.GradeDTO;
import ro.fils.highschoolplatform.util.DBManager;

/**
 *
 * @author andre
 */
public class GradeDAO {

    public List<GradeDTO> getAllGradesOfStudent(int studentId) {
        GradeDTO grade = null;
        ArrayList<GradeDTO> grades = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "select grades.ID,grades.VALUE,STUDENTS.FIRST_NAME,STUDENTS.LAST_NAME,COURSES.NAME,grades.DATE from grades inner join STUDENTS on grades.STUDENT_ID = STUDENTS.ID"
                    + "	inner join COURSES on grades.COURSE_ID = COURSES.ID WHERE STUDENTS.ID = " + studentId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                grade = new GradeDTO();
                grade.setId(rs.getInt("ID"));
                grade.setValue(rs.getInt("VALUE"));
                grade.setStudentName(rs.getString("STUDENTS.FIRST_NAME") + rs.getString("STUDENTS.LAST_NAME"));
                grade.setCourseName(rs.getString("COURSES.NAME"));
                grade.setDate(rs.getDate("DATE"));
                grades.add(grade);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grades;
    }
     public List<Integer> getAllGradesNumbers() {
        ArrayList<Integer> gradesNrs = new ArrayList();
        try {
            Connection con = DBManager.getConnection();
            for (int i = 2; i <= 10; i++) {
                String sql = "select count(student_id) from grades where grades.value = " + i;
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql);
                rs.next();
                gradesNrs.add(rs.getInt(1));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gradesNrs;
    }
    public boolean addGradeToStudent(int studentId, int courseId, int gradeValue) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = new java.util.Date();
        String currentTime = format.format(d);
        System.out.println(currentTime);
        boolean result = false;
        try {
            Connection con = DBManager.getConnection();
            String sql = "INSERT INTO grades(DATE,VALUE, STUDENT_ID, COURSE_ID)" + " VALUES('" + currentTime + "'," + gradeValue + "," + studentId + "," + courseId + ")";
            System.out.println(sql);
            Statement ps = con.createStatement();
            System.out.println(ps.toString());
            int rs = ps.executeUpdate(sql);
            if (rs > 0) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public ArrayList<Grade> getGradesOfStudentInCourse(int studentId, int courseId) {
        ArrayList<Grade> grades = new ArrayList<Grade>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "SELECT * FROM GRADES WHERE STUDENT_ID = " + studentId + " AND COURSE_ID = " + courseId;
            Statement ps = con.createStatement();
            ResultSet executeQuery = ps.executeQuery(sql);
            while(executeQuery.next()){
                Grade g = new Grade();
                g.setValue(executeQuery.getInt("value"));
                g.setDate(executeQuery.getDate("date"));
                g.setId(executeQuery.getInt("id"));
                g.setCourseId(courseId);
                g.setStudentId(studentId);
                grades.add(g);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grades;
    }
    
    
     public ArrayList<Absence> getAbsencesOfStudentInCourse(int studentId, int courseId) {
        ArrayList<Absence> absences = new ArrayList<Absence>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "SELECT * FROM ABSENCES WHERE STUDENT_ID = " + studentId + " AND COURSE_ID = " + courseId;
            Statement ps = con.createStatement();
            ResultSet executeQuery = ps.executeQuery(sql);
            while(executeQuery.next()){
                Absence a = new Absence();
                a.setDate(executeQuery.getDate("date"));
                a.setId(executeQuery.getInt("id"));
                a.setCourseId(courseId);
                a.setStudentId(studentId);
                absences.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return absences;
    }
}
