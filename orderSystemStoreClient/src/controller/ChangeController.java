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
import javafx.scene.control.Label;
import javafx.stage.Stage;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import excelOutput.OutputNewData;
import clientServer.*;


public class ChangeController implements Initializable{

    @FXML
    private Label change;
    
    private Stage stage;
   	private Scene scene;
   	private Parent root;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		change.setText("ÅU«È¥I¡G" + ClientServer.total + "\n" + "À³§ä¡G" + ClientServer.change);
	}

    @FXML
    public void endPressed(ActionEvent event) throws IOException, RowsExceededException, BiffException, WriteException 
    {
    	MainClientServer mcs = new MainClientServer("payed");
    	mcs.run();
    	
    	OutputNewData ond = new OutputNewData("update");
    	
    	Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CheckoutForm.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.show();
    }
}
