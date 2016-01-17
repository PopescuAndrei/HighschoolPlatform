/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service.impl;

import java.util.ArrayList;
import ro.fils.highschoolplatform.domain.Homework;
import ro.fils.highschoolplatform.dto.HomeworkDTO;
import ro.fils.highschoolplatform.repository.HomeworkDAO;
import ro.fils.highschoolplatform.service.HomeworkService;

/**
 *
 * @author andre
 */
public class HomeworkServiceImpl implements HomeworkService{

    HomeworkDAO dao = new HomeworkDAO();
    @Override
    public Boolean insertHomework(int clazzId, int courseId, String description, String dueDate) {
        return dao.uploadHomework(clazzId, courseId, description, dueDate);
    }

    @Override
    public ArrayList<HomeworkDTO> getAllHomeworksForStudent(int studentId) {
        return dao.getHomeworksForStudent(studentId);
    }
    
    @Override
    public HomeworkDTO getOneHomework(int homeworkId){
        return dao.getOneHomework(homeworkId);
    }
}
