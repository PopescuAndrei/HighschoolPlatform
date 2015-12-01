/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service;

import java.util.List;
import ro.fils.highschoolplatform.domain.Professor;

/**
 *
 * @author andre
 */
public interface ProfessorService {
    public List<Professor> findAllProfessors();
    public Professor getProfessor(int id);
    public Professor insertProfessor(Professor professor);
}
