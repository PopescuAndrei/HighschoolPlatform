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
public class Clazz {
    private int Id;
    private String name;

    public Clazz(int Id, String name) {
        this.Id = Id;
        this.name = name;
    }

    public Clazz() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
