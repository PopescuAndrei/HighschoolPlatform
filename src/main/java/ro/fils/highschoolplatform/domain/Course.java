/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.domain;

/**
 *
 * @author andre
 */
public class Course {
    private int id;
    private String name;
    private int classId;

    public Course() {
    }
    
    
    public Course(int id, String name, int classId) {
        this.id = id;
        this.name = name;
        this.classId = classId;
    }
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
    
    
    
}
