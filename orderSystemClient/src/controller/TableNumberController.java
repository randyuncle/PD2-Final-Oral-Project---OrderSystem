package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import properties.ListInfo;
import clientServer.MainClientServer;

public class TableNumberController implements Initializable{

    @FXML
    private ChoiceBox<String> table;
    
    private String[] number = {"1","2","3","4","5","6","7"};

    @FXML
    private Button next;

    @FXML
    private Button back;
    
    private Stage stage;
   	private Scene scene;
   	private Parent root;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) 
    {
		// TODO Auto-generated method stub
    	table.getItems().addAll(number);
    	table.setOnAction(this::tableNumber);
	}
    
    public void tableNumber(ActionEvent e)
    {
    	ListInfo.tableNum = Integer.parseInt(table.getValue());
    }

    @FXML
    void backPressed(ActionEvent e) throws IOException 
    {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainScene.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void nextPressed(ActionEvent e) throws IOException 
    {
    	
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MenuForm.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
    }

}

