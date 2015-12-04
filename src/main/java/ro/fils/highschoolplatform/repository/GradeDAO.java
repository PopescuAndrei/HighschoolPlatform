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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            String sql = "select GRADES.ID,GRADES.VALUE,STUDENTS.FIRST_NAME,STUDENTS.LAST_NAME,COURSES.NAME,GRADES.DATE from GRADES inner join STUDENTS on GRADES.STUDENT_ID = STUDENTS.ID"
                    + "	inner join COURSES on GRADES.COURSE_ID = COURSES.ID WHERE STUDENTS.ID = " + studentId;
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
}
