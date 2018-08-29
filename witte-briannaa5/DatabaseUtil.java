/*
Brianna Witte
4-25-18
CSCE 314-500 HW5
DatabaseUtil.java
Utility funcitons for connections with the database
 */
package homework5;

import java.sql.*;
import javafx.collections.ObservableList;

public abstract class DatabaseUtil {
    
    public static Connection conn;
    //return connection to database
    public static Connection getConnection(){
        
        //phpmyadmin database access information
        String dbname = "witte_breezy-314";
        String user = "witte_breezy";
        String password = "howdyyall";
        
        try{
            //connect to database using mysql jdbc connector
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://database.cse.tamu.edu/"+dbname,user,password);
        }
        catch(Exception e){
            System.out.print("connection problem");
            e.printStackTrace();
            
        }
        return conn;
        
    }
    //close database connection
    public static void closeConnection(){
        try{
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public abstract ObservableList<ContactInfo> queryDB(String sql);
    
    public abstract void updateDB(String sql);
    
}
