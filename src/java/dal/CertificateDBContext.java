/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Certificate;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class CertificateDBContext extends DBContext<CertificateDBContext> {

    public ArrayList<Certificate> getCertificates() {
        ArrayList<Certificate> certificates = new ArrayList<>();
        try {
            String sql = "SELECT TOP (1000) [certid]\n"
                    + "      ,[certname]\n"
                    + "  FROM [Lab2].[dbo].[Certificate]";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Certificate c = new Certificate();
                c.setId(rs.getInt("certid"));
                c.setName(rs.getString("certname"));
                certificates.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return certificates;
    }
    
    public void addEmployeeCertificate(int empid,int certid, Date date){
        try {
            String sql = "  insert into Employee_Certificate(empid,certid,issueddate) values (?,?,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, empid);
            stm.setInt(2, certid);
            stm.setDate(3, date);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CertificateDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
