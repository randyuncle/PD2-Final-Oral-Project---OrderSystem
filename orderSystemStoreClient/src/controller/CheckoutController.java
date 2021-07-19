package controller;

import java.io.IOException;

import clientServer.ClientServer;
import clientServer.MainClientServer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import excelOutput.OutputNewData;

public class CheckoutController {

    @FXML
    private TextField tableNumber;
    
    private Stage stage;
   	private Scene scene;
   	private Parent root;

    @FXML
    void endPressed(ActionEvent event) throws IOException, RowsExceededException, BiffException, WriteException 
    {
    	OutputNewData ond = new OutputNewData("end");
    	
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("LoginForm.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void nextPressed(ActionEvent event) throws IOException 
    {
    	ClientServer.tableNumber = tableNumber.getText();
    	
    	MainClientServer mcs = new MainClientServer("get bill");
    	mcs.run();
    	
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("PaymentForm.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
    }

}