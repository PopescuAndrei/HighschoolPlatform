/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.fils.highschoolplatform.domain.Student;
import ro.fils.highschoolplatform.dto.StudentWithAbsenceDTO;
import ro.fils.highschoolplatform.dto.StudentWithGradeDTO;
import ro.fils.highschoolplatform.repository.StudentDAO;
import ro.fils.highschoolplatform.service.StudentService;

/**
 *
 * @author andre
 */
@Service
@Transactional
public class StudentServiceImpl implements StudentService{

    StudentDAO dao;
    
    @Override
    public List<Student> findAllStudents() {
        dao = new StudentDAO();
        return dao.getAll();
    }

    @Override
    public Student getStudent(int id) {
        dao = new StudentDAO();
        return dao.getStudentById(id);
    }


    @Override
    public Student insertStudent(Student student) {
        dao = new StudentDAO();
        if(dao.insertStudent(student)==true){
            student = dao.getStudentByEmail(student.getEmail());//ii luam si id-ul
        }
        return student;
    }

    @Override
    public List<Student> getAllStudentsInClass(int classId) {
        dao = new StudentDAO();
        return dao.getAllStudentsInClass(classId);
    }
    
//    @Override
//    public List<StudentDTO> getAllStudentsAtCourseWithGrades(int courseId,)

    @Override
    public List<StudentWithGradeDTO> getAllStudentsGradesInClassInCourse(int classId, int courseId) {
        dao = new StudentDAO();
        return dao.getAllStudentsInClassAtCourse(classId, courseId);
    }

    @Override
    public List<StudentWithAbsenceDTO> getAllStudentsAbsencesInClassInCourse(int classId, int courseId) {
        dao = new StudentDAO();
        return dao.getAllStudentsAndAbsencesInClassAtCourse(classId, courseId);
    }
    
}
