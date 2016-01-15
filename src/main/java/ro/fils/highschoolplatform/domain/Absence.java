/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.domain;

import java.sql.Date;

/**
 *
 * @author andre
 */
public class Absence {
    
    private int id;
    private Date date;
    private int studentId;
    private int courseId;

    public Absence() {
    }

    public Absence(int id, Date date, int studentId, int courseId) {
        this.date = date;
        this.studentId = studentId;
        this.courseId = courseId;
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
