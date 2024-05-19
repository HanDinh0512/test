/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.Account;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class AccountDBContext extends DBContext<Account> {

    public Account getByUsernamePassword(String username, String password) {
        try {
            String sql = "SELECT username,password FROM Account\n"
                    + "WHERE username = ? AND password = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, username);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Account account = new Account();
                account.setUsername(username);
                account.setPassword(password);

                return account;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Account> getAccount() {
        ArrayList<Account> accounts = new ArrayList<>();
        try {
            String sql = """
                           SELECT TOP (1000) [username]
                          ,[password]
                          ,[displayname]
                       FROM [Lab2].[dbo].[Account]""";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
                Account a = new Account();
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setDisplayname(rs.getString("displayname"));
                accounts.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccountDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return accounts;
    }
}
