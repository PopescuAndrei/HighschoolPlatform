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
import java.util.logging.Level;
import java.util.logging.Logger;
import ro.fils.highschoolplatform.domain.Student;
import ro.fils.highschoolplatform.dto.HomeworkDTO;
import ro.fils.highschoolplatform.service.impl.ClazzServiceImpl;
import ro.fils.highschoolplatform.service.impl.CourseServiceImpl;
import ro.fils.highschoolplatform.service.impl.StudentServiceImpl;
import ro.fils.highschoolplatform.util.DBManager;

/**
 *
 * @author andre
 */
public class HomeworkDAO {

    public Boolean uploadHomework(int classId, int courseId, String description, String dueDate) {
        boolean inserted = false;
        try {
            int clazzCourseId = new ClazzServiceImpl().getClazzCoursesTable(classId, courseId);
            Connection conn = DBManager.getConnection();
            String sql = "insert into HOMEWORKS(DESCRIPTION, DUEDATE, CLASS_COURSE_ID)" + "values(?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, description);
            statement.setString(2, dueDate);
            statement.setInt(3, clazzCourseId);
            statement.execute();
            int homeworkId = 0;
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    homeworkId = (int) generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

            ArrayList<Student> students = (ArrayList<Student>) new StudentServiceImpl().getAllStudentsInClass(classId);
            for (Student s : students) {

                System.out.println(homeworkId);
                sql = "insert into HOMEWORKS_STUDENTS(HOMEWORK_ID, STUDENT_ID, SEEN)" + " values (?,?,?)";
                statement = conn.prepareStatement(sql);
                statement.setInt(1, homeworkId);
                statement.setInt(2, s.getId());
                statement.setString(3, "not_seen");
                statement.execute();
            }
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inserted;
    }

    public ArrayList<HomeworkDTO> getHomeworksForStudent(int studentId) {
        ArrayList<HomeworkDTO> homeworks = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "SELECT * FROM HOMEWORKS INNER JOIN HOMEWORKS_STUDENTS ON HOMEWORKS.ID = HOMEWORKS_STUDENTS.HOMEWORK_ID WHERE HOMEWORKS_STUDENTS.STUDENT_ID = " + studentId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                HomeworkDTO hw = new HomeworkDTO();
                hw.setId(rs.getInt("ID"));
                hw.setDescription(rs.getString("DESCRIPTION"));
                hw.setCourseName(new CourseServiceImpl().getCourseByClassCourseId(rs.getInt("CLASS_COURSE_ID")).getName());
                hw.setDueDate(rs.getString("DUEDATE"));
                homeworks.add(hw);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return homeworks;
    }

    public HomeworkDTO getOneHomework(int homeworkId) {
        HomeworkDTO hw = new HomeworkDTO();
        try {
            Connection con = DBManager.getConnection();
            String sql = "SELECT * FROM HOMEWORKS WHERE ID = " + homeworkId;
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                hw.setId(rs.getInt("ID"));
                hw.setDescription(rs.getString("DESCRIPTION"));
                hw.setCourseName(new CourseServiceImpl().getCourseById(rs.getInt("CLASS_COURSE_ID")).getName());
                hw.setDueDate(rs.getString("DUEDATE"));
                return hw;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

}
