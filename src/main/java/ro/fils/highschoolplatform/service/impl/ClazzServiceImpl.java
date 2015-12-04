/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service.impl;

import java.util.ArrayList;
import java.util.List;
import ro.fils.highschoolplatform.domain.Clazz;
import ro.fils.highschoolplatform.repository.ClazzDAO;
import ro.fils.highschoolplatform.service.ClazzService;

/**
 *
 * @author andre
 */
public class ClazzServiceImpl implements ClazzService {

    ClazzDAO dao;

    @Override
    public List<Clazz> findAllClazzez() {
        dao = new ClazzDAO();
        return (ArrayList) dao.getAllClazzez();
    }

    @Override
    public Clazz getClazz(int id) {
        dao = new ClazzDAO();
        return dao.getClazz(id);

    }

    @Override
    public Clazz insertClazz(Clazz clazz) {
        dao = new ClazzDAO();
        dao.insertClazz(clazz);
        return clazz;
    }

    @Override
    public Clazz getStudentClazz(int studentId) {
        System.out.println("in service java" + studentId);
        dao = new ClazzDAO();
        return dao.getStudentClazz(studentId);
    }

}
