/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service.impl;

import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.fils.highschoolplatform.dto.GradeDTO;
import ro.fils.highschoolplatform.repository.GradeDAO;
import ro.fils.highschoolplatform.service.GradeService;

/**
 *
 * @author andre
 */
@Service
@Transactional
public class GradeServiceImpl implements GradeService{

    GradeDAO dao;
    
    @Override
    public ArrayList<GradeDTO> getAllGradesForStudent(int studentId) {
        dao = new GradeDAO();
        return (ArrayList) dao.getAllGradesOfStudent(studentId);
    }
    
    @Override
    public boolean addGradeToStudent(int studentId,int courseId, int gradeValue){
        dao = new GradeDAO();
        return dao.addGradeToStudent(studentId,courseId,gradeValue);
    }
}
