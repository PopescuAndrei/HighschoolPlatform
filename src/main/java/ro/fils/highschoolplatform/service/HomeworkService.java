/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service;

import java.util.ArrayList;
import ro.fils.highschoolplatform.domain.Homework;
import ro.fils.highschoolplatform.dto.GradeDTO;
import ro.fils.highschoolplatform.dto.HomeworkDTO;

/**
 *
 * @author andre
 */
public interface HomeworkService {
    Boolean insertHomework(int clazzId, int courseId, String description, String dutDate);
    ArrayList<HomeworkDTO> getAllHomeworksForStudent(int studentId);
    HomeworkDTO getOneHomework(int homeworkId);
}
