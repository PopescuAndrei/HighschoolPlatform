/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ro.fils.highschoolplatform.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ro.fils.highschoolplatform.domain.Professor;
import ro.fils.highschoolplatform.util.DBManager;
import ro.fils.highschoolplatform.util.Encryption;

/**
 *
 * @author andre
 */
public class ProfessorDAO {

    public Boolean insertProfessor(Professor professor) {
        boolean inserted = false;
        try {
            Connection conn = DBManager.getConnection();
            String sql = "insert into PROFESSORS(PASSWORD, FIRST_NAME, LAST_NAME, EMAIL)" + " values (?,?,?,?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(2, professor.getPassword());
            statement.setString(3, professor.getFirstName());
            statement.setString(4, professor.getLastName());
            statement.setString(5, professor.getEmail());
            statement.execute();
            inserted = true;
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inserted;
    }

    public boolean professorExists(String email) {
        boolean found = false;
        try {
            Connection con = DBManager.getConnection();
            String sql = "select EMAIL from PROFESSORS";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (email.equals(rs.getString("EMAIL")) == true) {
                    found = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return found;
    }

    public boolean loginProfessor(String email, String password) {
        boolean found = false;
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from PROFESSORS where EMAIl = '" + email + "' and PASSWORD ='" + Encryption.getHash(password) + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                if (email.equals(rs.getString("EMAIL")) == true && Encryption.getHash(password).equals(rs.getString("PASSWORD")) == true) {
                    found = true;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return found;
    }

    public Professor getProfessorByEmail(String email) {
        Professor professor = null;
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from PROFESSORS where EMAIL = " + "?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, email);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                professor = new Professor();
                professor.setEmail(rs.getString("EMAIL"));
                professor.setFirstName(rs.getString("FIRST_NAME"));
                professor.setLastName(rs.getString("LAST_NAME"));
                professor.setPassword(rs.getString("PASSWORD"));
                professor.setId(rs.getInt("ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professor;
    }
    
    public Professor getProfessorById(int id) {
        Professor professor = null;
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from PROFESSORS where ID = " + "?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                professor = new Professor();
                professor.setEmail(rs.getString("EMAIL"));
                professor.setFirstName(rs.getString("FIRST_NAME"));
                professor.setLastName(rs.getString("LAST_NAME"));
                professor.setPassword(rs.getString("PASSWORD"));
                professor.setId(rs.getInt("ID"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professor;
    }
    
    public List<Professor> getAll() {
        Professor professor = null;
        ArrayList<Professor> professors = new ArrayList<>();
        try {
            Connection con = DBManager.getConnection();
            String sql = "select * from PROFESSORS";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                professor = new Professor();
                professor.setEmail(rs.getString("EMAIL"));
                professor.setFirstName(rs.getString("FIRST_NAME"));
                professor.setLastName(rs.getString("LAST_NAME"));
                professor.setPassword(rs.getString("PASSWORD"));
                professor.setId(rs.getInt("ID"));
                professors.add(professor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfessorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return professors;
    }
}
