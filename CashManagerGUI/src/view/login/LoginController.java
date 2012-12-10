/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.login;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author VIN31135
 */
public class LoginController {

	@FXML private Text actionTarget;
	
	@FXML protected void handleSubmitButtonAction(ActionEvent event) {
//		actionTarget.setText("Sign in button pressed");
		Node node = (Node)event.getSource();
		Stage stage = (Stage)node.getScene().getWindow();
		try {
			stage.setScene((Scene)FXMLLoader.load(getClass().getResource("/view/main.fxml")));
		} catch (IOException ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
		}
		stage.centerOnScreen();
		stage.show();
	}
}
