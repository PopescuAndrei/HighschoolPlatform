/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.service;

import java.util.List;
import ro.fils.highschoolplatform.domain.Clazz;

/**
 *
 * @author andre
 */
public interface ClazzService {

    public List<Clazz> findAllClazzez();

    public Clazz getClazz(int id);

    public Clazz insertClazz(Clazz clazz);
    
    public Clazz getStudentClazz(int studentId);
}
