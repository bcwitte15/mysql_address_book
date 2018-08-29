/*
Brianna Witte
4-25-18
CSCE 314-500 HW5
Layouts.java
 Methods for various scenes of the GUI
 */
package homework5;

import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Layouts {
    TextField delete_first = new TextField();
    TextField delete_last = new TextField();
    TextField input_first = new TextField();
    TextField input_last = new TextField();
    TextField input_cell = new TextField();
    TextField input_work = new TextField();
    TextField edit_cell_first = new TextField();
    TextField edit_cell_last = new TextField();
    TextField edit_cell = new TextField();
    TextField edit_work_first = new TextField();
    TextField edit_work_last = new TextField();
    TextField edit_work = new TextField();
    ContactOptions con_operator = new ContactOptions();
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //method for constructing the main scene of the phone book
    public VBox sceneHome(Button addButton, Button deleteButton, Button cellEditButton, Button workEditButton){
        final TableView<ContactInfo> table = new TableView<ContactInfo>();
        final HBox hbox1 = new HBox();
        final HBox hbox2 = new HBox();
        final Label label = new Label("Phone Book");
        
        //make table editable and fix the size
        table.setEditable(true);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        
        //add column info to table
        TableColumn<ContactInfo, String> first = new TableColumn<ContactInfo, String>("First Name");
        first.setCellValueFactory(new PropertyValueFactory<ContactInfo, String>("first"));
        TableColumn<ContactInfo, String> last = new TableColumn<ContactInfo, String>("Last Name");
        last.setCellValueFactory(new PropertyValueFactory<ContactInfo, String>("last"));
        TableColumn<ContactInfo, String> cell = new TableColumn<ContactInfo, String>("Cell Number");
        cell.setCellValueFactory(new PropertyValueFactory<ContactInfo, String>("cell"));
        TableColumn<ContactInfo, String> work = new TableColumn<ContactInfo, String>("Work Number");
        work.setCellValueFactory(new PropertyValueFactory<ContactInfo, String>("work"));
        
        //add Contacts taken from database to table
        ObservableList<ContactInfo> contacts = con_operator.getContactList();
        table.setItems(contacts);
        table.getColumns().addAll(first, last, cell, work);
             
        //line up add, delete, and edit buttons
        hbox1.getChildren().addAll(addButton, deleteButton);
        hbox1.setSpacing(5);
        hbox2.getChildren().addAll(cellEditButton, workEditButton);
        hbox2.setSpacing(5);
        
        //line up title, table, and buttons
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(label, table, hbox1, hbox2);
        
        //return home scene
        return vbox;
    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //method for constructing scene for adding a Contact
    public VBox sceneAddContact(Button returnFromAdd){
        final Label label = new Label("Add Contact");
       
        input_first.setPromptText("First Name");
        input_last.setPromptText("Last Name");
        input_cell.setPromptText("Cell Number");
        input_work.setPromptText("Work Number");
        
        //line up title, text boxes, and given return button 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(label, input_first, input_last, input_cell, input_work, returnFromAdd);
        //return add scene
        return vbox;
    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //method for constructing scene for deleting a Contact
    public VBox sceneDeleteContact(Button returnFromDelete){
        final Label label = new Label("Delete Contact");
        
        delete_first.setPromptText("First Name");
        delete_last.setPromptText("Last Name");
        
        //line up title, text boxes, and given return button 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(label, delete_first, delete_last, returnFromDelete);
        //return delete scene
        return vbox;
    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //method for constructing scene to edit a Cell number of a Contact
    public VBox sceneEditCellContact(Button returnFromCellEdit){
        final Label label = new Label("Edit Contact Cell: Enter first name, last name, & new number");
        
        edit_cell_first.setPromptText("First Name");
        edit_cell_last.setPromptText("Last Name");
        edit_cell.setPromptText("New Cell Number");
       //line up title, text boxes, and given return button
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(label, edit_cell_first, edit_cell_last, edit_cell, returnFromCellEdit);
        
        return vbox;
    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //method for constructing scene to edit a Work number of a Contact
    public VBox sceneEditWorkContact(Button returnFromWorkEdit){
        final Label label = new Label("Edit Contact Work: Enter first name, last name, & new number");
        
        edit_work_first.setPromptText("First Name");
        edit_work_last.setPromptText("Last Name");
        edit_work.setPromptText("New Work Number");
       //line up title, text boxes, and given return button 
        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(label, edit_work_first, edit_work_last, edit_work, returnFromWorkEdit);
        
        return vbox;
    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //method for constructing a scene for when the User inputs invalid information 
    public VBox ErrorScene(Stage primaryStage, Button addCellButton, Button deleteButton, Button cellEditButton, Button workEditButton, Label err_label){
        //make button that will return to main scene
        Button returnToHome = new Button("Return to Book");
        Scene scene = new Scene(sceneHome(addCellButton, deleteButton, cellEditButton, workEditButton));
        returnToHome.setOnAction(e->primaryStage.setScene(scene));
        //line up given error message and return button
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.getChildren().setAll(err_label, returnToHome);
        
        return vbox;
    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //action event for when Add Contact button is pressed
    public void addEvent(Stage primaryStage, Button addCellButton, Button deleteButton, Button cellEditButton, Button workEditButton){
        String first_text = input_first.getText(); 
        String last_text = input_last.getText();
        String cell_text = input_cell.getText(); 
        String work_text = input_work.getText();
       //if First name is not correct length, go to error scene
        if(first_text.length() > 20 || first_text.length() < 1){
           Label err_label = new Label("Error: First Name is not 1-20. Please try again.");
           Scene scene = new Scene(ErrorScene(primaryStage, addCellButton, deleteButton, cellEditButton, workEditButton, err_label));
           primaryStage.setScene(scene);
        } 
        //if Last name is not correct length, go to error scene
        else if(last_text.length() > 20 || last_text.length() < 1){
            Label err_label = new Label("Error: Last Name is not 1-20 characters. Please try again.");
            Scene scene = new Scene(ErrorScene(primaryStage, addCellButton, deleteButton, cellEditButton, workEditButton, err_label));
           primaryStage.setScene(scene);
        }
        //if Cell number is not correct length and Work number is blank, go to error scene
        else if(cell_text.length() != 10 && cell_text.length() < 1 && work_text.length() < 1){
            Label err_label = new Label("Error: Cell Number is not 10 characters. Please try again.");
            Scene scene = new Scene(ErrorScene(primaryStage, addCellButton, deleteButton, cellEditButton, workEditButton, err_label));
           primaryStage.setScene(scene);
        }
        //if Work number is not correct length and Cell number is blank, go to error scene
        else if(work_text.length() != 10 && work_text.length() < 1 && cell_text.length() < 1){
            Label err_label = new Label("Error: Work Number is not 10 characters. Please try again.");
            Scene scene = new Scene(ErrorScene(primaryStage, addCellButton, deleteButton, cellEditButton, workEditButton, err_label));
           primaryStage.setScene(scene);
        }
        //if all input is valid, add Contact to the database and return to main scene
        else{
            con_operator.addContact(first_text, last_text, cell_text, work_text);
             Scene scene = new Scene(sceneHome(addCellButton, deleteButton, cellEditButton, workEditButton));
             primaryStage.setScene(scene);
        }
        //clear text fields
        input_first.clear();
        input_last.clear();
        input_cell.clear();
        input_work.clear();
    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //action event for when Delete Contact button is pressed 
    public void deleteEvent(Stage primaryStage, Button addCellButton, Button deleteButton, Button cellEditButton, Button workEditButton){
        String first_text = delete_first.getText(); 
        String last_text = delete_last.getText();
       //if First name is not correct length, go to error scene
        if(first_text.length() > 20 || first_text.length() < 1){
           Label err_label = new Label("Error: First Name is not 1-20. Please try again.");
           Scene scene = new Scene(ErrorScene(primaryStage, addCellButton, deleteButton, cellEditButton, workEditButton, err_label));
           primaryStage.setScene(scene);
        } 
        //if Last name is not correct length, go to error scene
        else if(last_text.length() > 20 || last_text.length() < 1){
            Label err_label = new Label("Error: Last Name is not 1-20 characters. Please try again.");
            Scene scene = new Scene(ErrorScene(primaryStage, addCellButton, deleteButton, cellEditButton, workEditButton, err_label));
           primaryStage.setScene(scene);
        }
        //if all input is valid, delete Contact from database and return to main scene
        else{
            con_operator.deleteWithName(first_text, last_text);
             Scene scene = new Scene(sceneHome(addCellButton, deleteButton, cellEditButton, workEditButton));
             primaryStage.setScene(scene);
        }
        //clear text fields
        delete_first.clear();
        delete_last.clear();
    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //action event for when Edit Cell Number button is pressed
    public void cellEditEvent(Stage primaryStage, Button addCellButton, Button deleteButton, Button cellEditButton, Button workEditButton){
        String first_text = edit_cell_first.getText();
        String last_text = edit_cell_last.getText();
        String cell_text = edit_cell.getText();
        //if First name is not correct length, go to error scene
        if(first_text.length() > 20 || first_text.length() < 1){
           Label err_label = new Label("Error: First Name is not 1-20. Please try again.");
           Scene scene = new Scene(ErrorScene(primaryStage, addCellButton, deleteButton, cellEditButton, workEditButton, err_label));
           primaryStage.setScene(scene);
        } 
        //if Last name is not correct length, go to error scene
        else if(last_text.length() > 20 || last_text.length() < 1){
            Label err_label = new Label("Error: Last Name is not 1-20 characters. Please try again.");
            Scene scene = new Scene(ErrorScene(primaryStage, addCellButton, deleteButton, cellEditButton, workEditButton, err_label));
           primaryStage.setScene(scene);
        }
        //if Cell number is not correct length, go to error scene
        else if(cell_text.length() != 10){
            Label err_label = new Label("Error: Number is not 10 characters. Please try again.");
            Scene scene = new Scene(ErrorScene(primaryStage, addCellButton, deleteButton, cellEditButton, workEditButton, err_label));
           primaryStage.setScene(scene);
        }
        //if all input is valid, update Contact Cell number in database and return to main scene
        else{
            con_operator.updateNumber(first_text, last_text, cell_text, "cell");
             Scene scene = new Scene(sceneHome(addCellButton, deleteButton, cellEditButton, workEditButton));
             primaryStage.setScene(scene);
        }
        //clear text fields
        edit_cell_first.clear();
        edit_cell_last.clear();
        edit_cell.clear();
    }
    //---------------------------------------------------------------------------------------------
    //---------------------------------------------------------------------------------------------
    //action event for when Edit Work Number button is pressed
    public void workEditEvent(Stage primaryStage, Button addCellButton, Button deleteButton, Button cellEditButton, Button workEditButton){
        String first_text = edit_work_first.getText();
        String last_text = edit_work_last.getText();
        String work_text = edit_work.getText();
        //if First name is not correct length, go to error scene
        if(first_text.length() > 20 || first_text.length() < 1){
           Label err_label = new Label("Error: First Name is not 1-20. Please try again.");
           Scene scene = new Scene(ErrorScene(primaryStage, addCellButton, deleteButton, cellEditButton, workEditButton, err_label));
           primaryStage.setScene(scene);
        } 
        //if Last name is not correct length, go to error scene
        else if(last_text.length() > 20 || last_text.length() < 1){
            Label err_label = new Label("Error: Last Name is not 1-20 characters. Please try again.");
            Scene scene = new Scene(ErrorScene(primaryStage, addCellButton, deleteButton, cellEditButton, workEditButton, err_label));
           primaryStage.setScene(scene);
        }
        //if Cell number is not correct length, go to error scene
        else if(work_text.length() != 10){
            Label err_label = new Label("Error: Number is not 10 characters. Please try again.");
            Scene scene = new Scene(ErrorScene(primaryStage, addCellButton, deleteButton, cellEditButton, workEditButton, err_label));
           primaryStage.setScene(scene);
        }
        //if all input is valid, update Contact Work number in database and return to main scene
        else{
            con_operator.updateNumber(first_text, last_text, work_text, "work");
             Scene scene = new Scene(sceneHome(addCellButton, deleteButton, cellEditButton, workEditButton));
             primaryStage.setScene(scene);
        }
        //clear text fields
        edit_work_first.clear();
        edit_work_last.clear();
        edit_work.clear();
    }
}
