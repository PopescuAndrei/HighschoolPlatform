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
import ro.fils.highschoolplatform.dto.AbsenceDTO;
import ro.fils.highschoolplatform.util.DBManager;

/**
 *
 * @author andre
 */
public class AbsenceDAO {
    
    public List<AbsenceDTO> getAllAbsencesOfStudent(int studentId) {
        AbsenceDTO grade = null;
        ArrayList<AbsenceDTO> grades = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "select ABSENCES.ID, STUDENTS.FIRST_NAME, STUDENTS.LAST_NAME, COURSES.NAME, ABSENCES.DATE from ABSENCES inner join STUDENTS on ABSENCES.STUDENT_ID = STUDENTS.ID"
                    + "	inner join COURSES on ABSENCES.COURSE_ID = COURSES.ID WHERE STUDENTS.ID = " + studentId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                grade = new AbsenceDTO();
                grade.setId(rs.getInt("ID"));
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

    public boolean addAbsenceToStudent(int studentId, int courseId) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = new java.util.Date();
        String currentTime = format.format(d);
        System.out.println(currentTime);
        boolean result = false;
        try {
            Connection con = DBManager.getConnection();
            String sql = "INSERT INTO ABSENCES(DATE, STUDENT_ID, COURSE_ID)" + " VALUES('" + currentTime + "'," + studentId + "," + courseId + ")";
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
}