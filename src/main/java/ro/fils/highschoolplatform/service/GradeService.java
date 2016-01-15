/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service;

import java.util.ArrayList;
import ro.fils.highschoolplatform.dto.GradeDTO;

/**
 *
 * @author andre
 */
public interface GradeService {
    ArrayList<GradeDTO> getAllGradesForStudent(int studentId);
    boolean addGradeToStudent(int studentId,int courseId, int gradeValue);
}
