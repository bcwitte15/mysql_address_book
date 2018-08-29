/*
Brianna Witte
4-25-18
CSCE 314-500 HW5
Controller.java
Methods for Contact interaction with the database
 */
package homework5;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Controller  extends DatabaseUtil{
    private int count=6;
    //search database for all matching contacts and put into observable array
    public ObservableList<ContactInfo> queryDB(String sql){
        //connect to db
       
        Connection conn = DatabaseUtil.getConnection();
        ResultSet con_set = null;
        ObservableList<ContactInfo> clist = FXCollections.observableArrayList();

        count++;
        try{
            //search db 
            Statement statement = conn.createStatement();
            statement.executeQuery(sql);
            con_set = statement.getResultSet();
            
            //add new Contact to list
            while(con_set.next()){
              String fn = con_set.getString("First");
              String ln = con_set.getString("Last");
              String cn = con_set.getString("Cell");
              String wn = con_set.getString("Work");                
              clist.add(new ContactInfo(fn, ln, cn, wn));  
            } 
            //return list of matching contacts in the databse
            return clist;
        }
        catch(Exception e){
            System.out.print("controller problem");
            e.printStackTrace();
        }
        finally{
            DatabaseUtil.closeConnection();   
        }
        return clist;
    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //use input sql statement to update a Contact in the database
    public void updateDB(String sql){
       
        Connection conn = DatabaseUtil.getConnection();
        
        count++;
        try{
            //change database
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        }
        catch(Exception e){
            System.out.print("controller problem");
            e.printStackTrace();
        }
        finally{
            DatabaseUtil.closeConnection();
        }
    }
}
