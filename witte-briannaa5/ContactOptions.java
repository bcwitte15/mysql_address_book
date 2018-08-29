/*
Brianna Witte
4-25-18
CSCE 314-500 HW5
ContactOptions.java
Methods for User interaction with the database
 */
package homework5;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ContactOptions {
    Controller cont = new Controller();
    //-------------------------------------------------------------
    //-------------------------------------------------------------
    //add new Contact to database
    public void addContact(String first, String last, String cell, String work){
        String sql = "INSERT INTO `address_book`(`Count`, `First`, `Last`, `Cell`, `Work`) "
                +"VALUES (NULL, '"+first+"', '"+last+"', '"+cell+"', '"+work+"');";
        //if cell box is empty, insert cell as NULL
        if(cell.length() < 1){
            sql = "INSERT INTO `address_book`(`Count`, `First`, `Last`, `Cell`, `Work`) "
                +"VALUES (NULL, '"+first+"', '"+last+"', NULL, '"+work+"');";
        }
        //if work box is empty, insert work as NULL
        else if(work.length() < 1){
            sql = "INSERT INTO `address_book`(`Count`, `First`, `Last`, `Cell`, `Work`) "
                +"VALUES (NULL, '"+first+"', '"+last+"', '"+cell+"', NULL);";
        }
       try{
           //add to database with correct sql statement
           cont.updateDB(sql);
       }
       catch(Exception e){
           System.out.print("add problem");
        e.printStackTrace();
       }
    }
    //-------------------------------------------------------------
    //-------------------------------------------------------------
    //find and delete a Contact by First and Last name 
    public void deleteWithName(String first, String last){
        String sql = "DELETE FROM `address_book` WHERE `First` = '"
                +first+"' AND `Last` = '"+last+"';";
       try{
           //delete Contact from database
           cont.updateDB(sql);
       }
       catch(Exception e){
           System.out.print("delete problem");
        e.printStackTrace();
       }
    }
    //-------------------------------------------------------------
    //-------------------------------------------------------------
    //change a Cell or Work number of a Contact in the database given First and Last name
    public void updateNumber(String first, String last, String num, String type){
       String sql = null;
        //if want to change cell number, make sql set Cell
       if(type == "cell"){
           sql = "UPDATE `address_book` SET `Cell` = "+num
                   + " WHERE `First` = '"
                +first+"' AND `Last` = '"+last+"';";
       }
       //if want to change cell number, make sql set Cell
       else if(type == "work"){
           sql = "UPDATE `address_book` SET `Work` = "+num
                   + " WHERE `First` = '"
                +first+"' AND `Last` = '"+last+"';";
       }
       try{
           //update Contact in database
           cont.updateDB(sql);
       }
       catch(Exception e){
           System.out.print("update problem");
        e.printStackTrace();
       }
    }
    //-------------------------------------------------------------
    //-------------------------------------------------------------
    //get list of all Contacts in the database
    public ObservableList<ContactInfo> getContactList(){
        String sql = "SELECT * FROM address_book WHERE 1";
        ObservableList<ContactInfo> clist = FXCollections.observableArrayList();
        
        try{
            //search database for all contact
            clist = cont.queryDB(sql);
            return clist; 
        }
        catch(Exception e){
            System.out.print("list problem");
            e.printStackTrace();
        }
        return clist;
    }   
}
