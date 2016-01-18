/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service;

import java.util.List;
import ro.fils.highschoolplatform.domain.Professor;
import ro.fils.highschoolplatform.dto.ProfessorDTO;

/**
 *
 * @author andre
 */
public interface CoursesService {
    public List<Professor> findAllCourses();
    public Professor getCourse(int id);
    public Professor insertCourse(Professor professor);
    public List<ProfessorDTO> getAllProfessorsDTO();
}
