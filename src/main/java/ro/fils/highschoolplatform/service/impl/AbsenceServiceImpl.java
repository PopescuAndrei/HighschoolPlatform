/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service.impl;

import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import ro.fils.highschoolplatform.dto.AbsenceDTO;
import ro.fils.highschoolplatform.repository.AbsenceDAO;
import ro.fils.highschoolplatform.service.AbsenceService;

/**
 *
 * @author andre
 */
@Service
@Transactional
public class AbsenceServiceImpl implements AbsenceService {

    AbsenceDAO dao;
    
    @Override
    public ArrayList<AbsenceDTO> getAllAbsencesForStudent(int studentId) {
        dao = new AbsenceDAO();
        return (ArrayList) dao.getAllAbsencesOfStudent(studentId);
    }

    @Override
    public boolean addAbsenceToStudent(int studentId, int courseId) {
        dao = new AbsenceDAO();
        return dao.addAbsenceToStudent(studentId, courseId);
    }
}
