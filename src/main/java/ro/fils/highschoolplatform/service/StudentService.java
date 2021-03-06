/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service;

import java.util.List;
import ro.fils.highschoolplatform.domain.Student;
import ro.fils.highschoolplatform.dto.StudentWithAbsenceDTO;
import ro.fils.highschoolplatform.dto.StudentWithGradeDTO;

/**
 *
 * @author andre
 */
public interface StudentService {
    public List<Student> findAllStudents();
    public Student getStudent(int id);
    public Student insertStudent(Student student);
    public List<Student> getAllStudentsInClass(int classId);
    public List<StudentWithGradeDTO> getAllStudentsGradesInClassInCourse(int classId,int courseId);
    public List<StudentWithAbsenceDTO> getAllStudentsAbsencesInClassInCourse(int classId, int courseId);
}