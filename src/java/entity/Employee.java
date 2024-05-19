/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author admin
 */
public class Employee implements IEntity{
    private int id;
    private String name;
    private boolean gender ;
    private Date dob ;
    private Account acc ;
    private ArrayList<Certificate> certificates;

    public ArrayList<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(ArrayList<Certificate> certificates) {
        this.certificates = certificates;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Account getAcc() {
        return acc;
    }

    public void setAcc(Account acc) {
        this.acc = acc;
    }
    
    
}
