/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.domain;

/**
 *
 * @author cata
 */
public class Pair {
    String first;
    String second;

    public Pair(String first, String second) {
        this.first = first;
        this.second = second;
    }
    
    public Pair() {
    }
    
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getSecond() {
        return second;
    }

    public void setSecond(String second) {
        this.second = second;
    }
    
    
}
