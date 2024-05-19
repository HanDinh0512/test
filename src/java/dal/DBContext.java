/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import entity.IEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author admin
 */
public abstract class DBContext<T> {
    protected Connection connection;
    public DBContext(){
        DBConfig config = new DBConfig("resource/config.properties");
        try {
            String user = config.getDbUsername();
            String pass = config.getDbPassword();
            String url = config.getDbUrl();
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try {
                connection = DriverManager.getConnection(url, user, pass);
            } catch (SQLException ex) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
