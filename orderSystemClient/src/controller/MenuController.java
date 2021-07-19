package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import calculation.Calculation;
import properties.ListInfo;

public class MenuController implements Initializable{

	@FXML
    private ChoiceBox<String> ChoiceBox1;

    @FXML
    private ChoiceBox<String> ChoiceBox2;

    @FXML
    private ChoiceBox<String> ChoiceBox3;

    @FXML
    private ChoiceBox<String> ChoiceBox4;
    
    private String[] number = {"0","1","2","3","4","5","6","7","8","9","10"};

    @FXML
    private CheckBox CheckBox5;

    @FXML
    private CheckBox CheckBox6;

    @FXML
    private Button Next;

    @FXML
    private Button Back;
    
    private Stage stage;
	private Scene scene;
	private Parent root;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) 
    {
		// TODO Auto-generated method stub
    	ChoiceBox1.getItems().addAll(number);
    	ChoiceBox1.setOnAction(this::one);
    	
    	ChoiceBox2.getItems().addAll(number);
    	ChoiceBox2.setOnAction(this::two);
    	
    	ChoiceBox3.getItems().addAll(number);
    	ChoiceBox3.setOnAction(this::three);
    	
    	ChoiceBox4.getItems().addAll(number);
    	ChoiceBox4.setOnAction(this::four);
	}
    
    public void one(ActionEvent e) 
    {
    	ListInfo.panFriedBun = Integer.parseInt(ChoiceBox1.getValue());
    }
    
    public void two(ActionEvent e) 
    {
    	ListInfo.crab = Integer.parseInt(ChoiceBox2.getValue());
    }
    
    public void three(ActionEvent e) 
    {
    	ListInfo.eightTreasureRice = Integer.parseInt(ChoiceBox3.getValue());
    }
    
    public void four(ActionEvent e) 
    {
    	ListInfo.soup = Integer.parseInt(ChoiceBox4.getValue());
    }

    
    public void nextPressed(ActionEvent e) 
    {
    	if(CheckBox5.isSelected()) 
    	{
    		ListInfo.setOne++;
    	}
    	
    	if(CheckBox6.isSelected()) 
    	{
    		ListInfo.setTwo++;
    	}
    	
    	try {
			
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ListForm.fxml"));
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    }
    
    @FXML
    public void backPressed(ActionEvent e) throws IOException 
    {
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("TableNumberForm.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
    }
    

	
}
