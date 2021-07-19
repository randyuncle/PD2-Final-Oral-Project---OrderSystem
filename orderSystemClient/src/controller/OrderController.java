package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrderController {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void systemStartPressed(ActionEvent e) {
		
		try {
			
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("TableNumberForm.fxml"));
			stage = (Stage)((Node)e.getSource()).getScene().getWindow();
			scene = new Scene(root);
			
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
