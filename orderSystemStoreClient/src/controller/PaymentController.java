package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import clientServer.ClientServer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import properties.*;

public class PaymentController implements Initializable{

    @FXML
    private Label Info;

    @FXML
    private TextField pay;
    
    private Stage stage;
   	private Scene scene;
   	private Parent root;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) 
    {
		// TODO Auto-generated method stub
    	
		Info.setText(Info.getText() + "�W���ͷΥ]�G" + ClientServer.panFriedBun + "��\n");
		
		Info.setText(Info.getText() + "�K�_���G" + ClientServer.eightTreasureRice + "��\n");
		
		
		Info.setText(Info.getText() + "�M�]�����j�h�ɡG" + ClientServer.crab + "��\n");
		
		
		Info.setText(Info.getText() + "�o���G�������G" + ClientServer.soup + "��\n");
		
		
		Info.setText(Info.getText() + "�M�\1�G" + ClientServer.setOne + "��\n");
		
		
		Info.setText(Info.getText() + "�M�\2�G" + ClientServer.setTwo + "��\n");
		
		Info.setText(Info.getText() + "�`�����G" + ClientServer.total + "��\n");
	}


    @FXML
    void NextPressed(ActionEvent event) throws IOException 
    {
    	ClientServer.money = Integer.parseInt(pay.getText());
    	ClientServer.change = ClientServer.money - Integer.parseInt(ClientServer.total);
    	
    	DailyIncomeHolder.Income += Integer.parseInt(ClientServer.total);//�[�J�C�骺���J
    	
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ChangeForm.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
    }

	
}

