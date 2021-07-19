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
    	
		Info.setText(Info.getText() + "上海生煎包：" + ClientServer.panFriedBun + "個\n");
		
		Info.setText(Info.getText() + "八寶飯：" + ClientServer.eightTreasureRice + "個\n");
		
		
		Info.setText(Info.getText() + "清蒸陽澄湖大閘蟹：" + ClientServer.crab + "個\n");
		
		
		Info.setText(Info.getText() + "油豆腐粉絲湯：" + ClientServer.soup + "個\n");
		
		
		Info.setText(Info.getText() + "套餐1：" + ClientServer.setOne + "個\n");
		
		
		Info.setText(Info.getText() + "套餐2：" + ClientServer.setTwo + "個\n");
		
		Info.setText(Info.getText() + "總價錢：" + ClientServer.total + "元\n");
	}


    @FXML
    void NextPressed(ActionEvent event) throws IOException 
    {
    	ClientServer.money = Integer.parseInt(pay.getText());
    	ClientServer.change = ClientServer.money - Integer.parseInt(ClientServer.total);
    	
    	DailyIncomeHolder.Income += Integer.parseInt(ClientServer.total);//加入每日的收入
    	
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("ChangeForm.fxml"));
    	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
    }

	
}

