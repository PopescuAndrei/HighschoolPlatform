/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.dto;

import java.sql.Date;

/**
 *
 * @author andre
 */
public class GradeDTO {
   
    private int id;
    private int value;
    private Date date;
    private String studentName;
    private String courseName;

    public GradeDTO() {
    }

    public GradeDTO(int id, int value, Date date, String studentName, String courseName) {
        this.value = value;
        this.date = date;
        this.studentName = studentName;
        this.courseName = courseName;
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

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}