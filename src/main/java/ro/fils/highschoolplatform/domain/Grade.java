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
public class Grade {

    private int id;
    private int value;
    private Date date;
    private int studentId;
    private int courseId;

    public Grade() {
    }

    public Grade(int id, int value, Date date, int studentId, int courseId) {
        this.value = value;
        this.date = date;
        this.studentId = studentId;
        this.courseId = courseId;
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
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
