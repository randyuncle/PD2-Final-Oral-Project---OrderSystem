package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import properties.ListInfo;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import properties.ListInfo;
import calculation.Calculation;
import clientServer.MainClientServer;

public class ListController implements Initializable{

    @FXML
    private Button sendOut;

    @FXML
    private Button back;

    @FXML
    public Label Info ;
    
    @FXML
    private Label tableNumber;
    
    private Stage stage;
	private Scene scene;
	private Parent root;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		// TODO Auto-generated method stub
		tableNumber.setText("�ู�G" + ListInfo.tableNum);
		
		if(ListInfo.panFriedBun > 0) 
		{
			Info.setText(Info.getText() + "�W���ͷΥ]�G" + ListInfo.panFriedBun + "��\n");
		}
		if(ListInfo.eightTreasureRice > 0) 
		{
			Info.setText(Info.getText() + "�K�_���G" + ListInfo.eightTreasureRice + "��\n");
		}
		if(ListInfo.crab > 0) 
		{
			Info.setText(Info.getText() + "�M�]�����j�h�ɡG" + ListInfo.crab + "��\n");
		}
		if(ListInfo.soup > 0) 
		{
			Info.setText(Info.getText() + "�o���G�������G" + ListInfo.soup + "��\n");
		}
		if(ListInfo.setOne > 0) 
		{
			Info.setText(Info.getText() + "�M�\1�G" + ListInfo.setOne + "��\n");
		}
		if(ListInfo.setTwo > 0) 
		{
			Info.setText(Info.getText() + "�M�\2�G" + ListInfo.setTwo + "��\n");
		}
		
	}

    @FXML
    public void backPressed(ActionEvent e) throws IOException 
    {
    	ListInfo.panFriedBun = 0;
    	ListInfo.eightTreasureRice = 0;
    	ListInfo.crab = 0;
    	ListInfo.soup = 0;
    	ListInfo.setOne = 0;
    	ListInfo.setTwo = 0;
    	ListInfo.total = 0;
    	
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MenuForm.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    public void comfirmPressed(ActionEvent e) throws IOException 
    {
    	Calculation cal = new Calculation("addTotal");
    	
    	MainClientServer mcs = new MainClientServer("transfer");
    	mcs.run();
    	
    	ListInfo.panFriedBun = 0;
    	ListInfo.eightTreasureRice = 0;
    	ListInfo.crab = 0;
    	ListInfo.soup = 0;
    	ListInfo.setOne = 0;
    	ListInfo.setTwo = 0;
    	ListInfo.total = 0;
    	
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainScene.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
    }

	

}
