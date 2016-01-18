/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.dto;

import java.util.ArrayList;
import java.util.HashMap;
import ro.fils.highschoolplatform.domain.Grade;

/**
 *
 * @author andre
 */
public class StudentWithGradeDTO {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private double mean;

    public double getMean() {
        return mean;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }
    private ArrayList<Grade> gradesList;


    public StudentWithGradeDTO() {
        
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Grade> getGradesList() {
        return gradesList;
    }

    public void setGradesList(ArrayList<Grade> gradesList) {
        this.gradesList = gradesList;
    }
    
    
}
