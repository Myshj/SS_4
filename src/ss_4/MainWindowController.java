/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ss_4;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ss_4.locale.ru.Strings;


/**
 *
 * @author Alexey
 */
public class MainWindowController implements Initializable {
    
    private final UniqueArray list = new UniqueArray();
    
    private int currentIndex = 0;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Strings strings = new Strings();
        
        addButton.setText(strings.add);
        sortButton.setText(strings.sort);
        viewButton.setText(strings.viewFirst);
        indexLabel.setText(strings.index);
        valueLabel.setText(strings.value);
        countOfElementsLabel.setText(strings.countOfElements);
    }    
    
    @FXML
    private void addClickedHandler(){
        try{
           list.add(Integer.parseInt(newValueField.getText()));
           
           updateCountOfElements();
        }catch(Exception ex){
            System.out.println("Not a number.");
        }
       // list.add(/*NONE*/);
    }
    
    @FXML
    private void sortClickedHandler(){
        list.sortDesc();
        
        
        try{
            displayCurrentElement();
        }catch(Exception ex){
            System.out.println("Something went wrong.");
        }
    }
    
    private void updateCountOfElements(){
        countOfElementsField.setText(Integer.toString(list.getCountOfElements()));
    }
    
    @FXML
    private void viewClicked(){
        if(list.getCountOfElements() <= 0){
            return;
        }
        currentIndex = 0;
        
        indexField.setText(Integer.toString(0));
        
        valueField.setText(Integer.toString(list.getAt(0)));
    }
    
    @FXML
    private void viewPreviousClicked(){
        if(list.getCountOfElements() <= 0){
            return;
        }
        
        currentIndex = currentIndex == 0 ? list.getCountOfElements() - 1 : 
                (currentIndex - 1) % list.getCountOfElements();
        
        try{
            displayCurrentElement();
        }catch(Exception ex){
            System.out.println("Something went wrong.");
        }
    }
    
    @FXML
    private void viewNextClicked(){
        if(list.getCountOfElements() <= 0){
            return;
        }
        
        currentIndex = (currentIndex + 1) % list.getCountOfElements();
        
        try{
            displayCurrentElement();
        }catch(Exception ex){
            System.out.println("Something went wrong.");
        }
    }

    private void displayCurrentElement() throws IndexOutOfBoundsException {
        indexField.setText(Integer.toString(currentIndex));
        
        valueField.setText(Integer.toString(list.getAt(currentIndex)));
    }
    
    @FXML
    private TextField newValueField;
    
    @FXML
    private TextField countOfElementsField;
    
    @FXML
    private TextField indexField;
    
    @FXML
    private TextField valueField;
    
    @FXML
    private Button addButton;
    
    @FXML
    private Button sortButton;
    
    @FXML
    private Button viewButton;
    
    @FXML
    private Button viewNext;
    
    @FXML
    private Button viewPrevious;
    
    @FXML
    private Label indexLabel;
    
    @FXML
    private Label valueLabel;
    
    @FXML
    private Label countOfElementsLabel;
    
}
