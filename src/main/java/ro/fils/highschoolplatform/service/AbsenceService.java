/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service;

import java.util.ArrayList;
import ro.fils.highschoolplatform.dto.AbsenceDTO;

/**
 *
 * @author andre
 */
public interface AbsenceService {

    ArrayList<AbsenceDTO> getAllAbsencesForStudent(int studentId);

    boolean addAbsenceToStudent(int studentId, int courseId);
}
