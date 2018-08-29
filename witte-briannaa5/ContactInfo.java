/*
Brianna Witte
4-25-18
CSCE 314-500 HW5
ContactInfo.java
Constructors and accessor methods for Contacts
 */
package homework5;

import javafx.beans.property.SimpleStringProperty;

public class ContactInfo implements Contact {
    private final SimpleStringProperty f_name;
    private final SimpleStringProperty l_name;
    private final SimpleStringProperty c_num;
    private final SimpleStringProperty w_num;
    
    public ContactInfo(){
        this.f_name = null;
        this.l_name = null;
        this.c_num = null;
        this.w_num = null;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    public ContactInfo(String fn, String ln, String cn, String wn){
        this.f_name = new SimpleStringProperty(fn);
        this.l_name = new SimpleStringProperty(ln);
        this.c_num = new SimpleStringProperty(cn);
        this.w_num = new SimpleStringProperty(wn);
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    public void setFirstName(String fn){
        f_name.set(fn);
    }
    public String getFirstName(){
        return f_name.get();
    }
    public SimpleStringProperty firstProperty(){
        return f_name;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    public void setLastName(String ln){
        l_name.set(ln);
    }
    public String getLastName(){
        return l_name.get();
    }
    public SimpleStringProperty lastProperty(){
        return l_name;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    public void setCellNumber(String cn){
        c_num.set(cn);
    }
    public String getCellNumber(){
        return c_num.get();
    }
    public SimpleStringProperty cellProperty(){
        return c_num;
    }
    //-----------------------------------------------------
    //-----------------------------------------------------
    public void setWorkNumber(String wn){
        w_num.set(wn);
    }
    public String getWorkNumber(){
        return w_num.get();
    }
    public SimpleStringProperty workProperty(){
        return w_num;
    }
}
