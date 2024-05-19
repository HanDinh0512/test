/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
import java.sql.*;
/**
 *
 * @author admin
 */
public class EmpCert implements IEntity{
    private int empid ;
    private int certid;
    private Date date ;

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public int getCertid() {
        return certid;
    }

    public void setCertid(int certid) {
        this.certid = certid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
}
