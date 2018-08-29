/*
* Brianna Witte
  4-25-18
* Main class of CSCE 314-500 Homework5
* Other files needed: Contact.java, ContactInfo.java, ContactOptions.java, Controller.java, 
    DatabaseUtil.java, Layouts.java, & mysql-connector-jave-8.0.11.jar(in lib folder)
* Contact.java is an interface for ContactInfo.java
* Homework5.java extends the abstract class Application
* References: -for information on using tableview(oracle example): https://docs.oracle.com/javafx/2/ui_controls/table-view.htm
              -for how to connect Java to a phpmyadmin database(youtube tutorial): https://www.youtube.com/watch?v=8WJ5p3T9Iss
              -class slides & examples on javafx
 */
package homework5;


import static java.awt.SystemColor.window;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author briannawitte
 */
public class Homework5 extends Application {
    private TableView table = new TableView();
    final HBox hbox = new HBox();
    Layouts lay1 = new Layouts();
    @Override
    public void start(Stage primaryStage) {
        Scene scene1, scene_add, scene_delete, scene_cell_edit, scene_work_edit;
        primaryStage.setTitle("Phone Book");
        
        Button addButton = new Button("Add New Contact");
        Button returnFromAdd = new Button("Add Contact & Return to Book");
        Button deleteButton = new Button("Delete Contact");
        Button returnFromDelete = new Button("Delete Contact & Return to Book");
        Button cellEditButton = new Button("Edit Contact Cell Number");
        Button returnFromCellEdit = new Button("Edit Contact & Return to Book");
        Button workEditButton = new Button("Edit Contact Work Number");
        Button returnFromWorkEdit = new Button("Edit Contact & Return to Book");
        
        scene1 = new Scene(lay1.sceneHome(addButton, deleteButton, cellEditButton, workEditButton));
        scene_add = new Scene(lay1.sceneAddContact(returnFromAdd));
        scene_delete = new Scene(lay1.sceneDeleteContact(returnFromDelete));
        scene_cell_edit = new Scene(lay1.sceneEditCellContact(returnFromCellEdit));
        scene_work_edit = new Scene(lay1.sceneEditWorkContact(returnFromWorkEdit));
        
        addButton.setOnAction(e->primaryStage.setScene(scene_add));
        returnFromAdd.setOnAction(e->lay1.addEvent(primaryStage, addButton, deleteButton, cellEditButton, workEditButton));
        deleteButton.setOnAction(e->primaryStage.setScene(scene_delete));
        returnFromDelete.setOnAction(e->lay1.deleteEvent(primaryStage, addButton, deleteButton, cellEditButton, workEditButton));
        cellEditButton.setOnAction(e->primaryStage.setScene(scene_cell_edit));
        returnFromCellEdit.setOnAction(e->lay1.cellEditEvent(primaryStage, addButton, deleteButton, cellEditButton, workEditButton));
        workEditButton.setOnAction(e->primaryStage.setScene(scene_work_edit));
        returnFromWorkEdit.setOnAction(e->lay1.workEditEvent(primaryStage, addButton, deleteButton, cellEditButton, workEditButton));
        
        primaryStage.setWidth(525);
        primaryStage.setHeight(525);
        
        primaryStage.setScene(scene1);
        primaryStage.show();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
