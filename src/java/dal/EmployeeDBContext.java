/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Account;
import entity.Employee;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class EmployeeDBContext extends DBContext<Employee> {

    public ArrayList<Employee> getEmployees(String username) {
        ArrayList<Employee> employees = new ArrayList<>();
        try {
            String sql = "select empid, empname,empgender,empdob\n"
                    + "  from Employee where createdby = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Employee e = new Employee();
                Account a = new Account();
                a.setUsername(username);
                e.setId(rs.getInt("empid"));
                e.setName(rs.getString("empname"));
                e.setGender(rs.getBoolean("empgender"));
                e.setDob(rs.getDate("empdob"));
                employees.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employees;
    }
    
    public void addEmployee(int id, String name, boolean gender, Date dob, String createdby){
        try {
            String sql = "insert into Employee(empid,empname,empgender,empdob,createdby) values (?,?,?,?,?)";
            PreparedStatement stm =connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.setString(2, name);
            stm.setBoolean(3, gender);
            stm.setDate(4, dob);
            stm.setString(5, createdby);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
