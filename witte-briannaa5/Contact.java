/*
Brianna Witte
4-25-18
CSCE 314-500 HW5
Contact.java
Interface class for ContactInfo
 */
package homework5;

import javafx.beans.property.SimpleStringProperty;

interface Contact {
    
    public abstract void setFirstName(String fn);
    public abstract String getFirstName();
    public abstract SimpleStringProperty firstProperty();
    public abstract void setLastName(String ln);
    public abstract String getLastName();
    public abstract SimpleStringProperty lastProperty();
    public abstract void setCellNumber(String cn);
    public abstract String getCellNumber();
    public abstract SimpleStringProperty cellProperty();
    public abstract void setWorkNumber(String wn);
    public abstract String getWorkNumber();
    public abstract SimpleStringProperty workProperty();
}
