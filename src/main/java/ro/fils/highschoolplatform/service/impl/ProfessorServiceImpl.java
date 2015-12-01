/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service.impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.fils.highschoolplatform.domain.Professor;
import ro.fils.highschoolplatform.repository.ProfessorDAO;
import ro.fils.highschoolplatform.service.ProfessorService;

/**
 *
 * @author andre
 */
@Service
@Transactional
public class ProfessorServiceImpl implements ProfessorService{

    ProfessorDAO dao;
    
    @Override
    public List<Professor> findAllProfessors() {
        dao = new ProfessorDAO();
        return dao.getAll();
    }

    @Override
    public Professor getProfessor(int id) {
        dao = new ProfessorDAO();
        return dao.getProfessorById(id);
    }


    @Override
    public Professor insertProfessor(Professor professor) {
        dao = new ProfessorDAO();
        if(dao.insertProfessor(professor)==true){
            professor = dao.getProfessorByEmail(professor.getEmail());//ii luam si id-ul
        }
        return professor;
    }
    
}
