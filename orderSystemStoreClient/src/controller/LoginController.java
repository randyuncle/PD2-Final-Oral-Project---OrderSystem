package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jxl.write.WriteException;
import properties.*;
import excelOutput.InitializeNewExcel;

public class LoginController {

    @FXML
    private TextField password;
    
    
    private Stage stage;
   	private Scene scene;
   	private Parent root;

    @FXML
    public void loginPressed(ActionEvent e) throws IOException, WriteException 
    {
    	if(Integer.parseInt(password.getText()) == StoreAccountSets.password) 
    	{
    		InitializeNewExcel inz = new InitializeNewExcel();
    		
    		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CheckoutForm.fxml"));
        	stage = (Stage)((Node)e.getSource()).getScene().getWindow();
    		scene = new Scene(root);
    		
    		stage.setScene(scene);
    		stage.show();
    	}
    }

}