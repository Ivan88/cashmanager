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
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Constants;

/**
 * FXML Controller class
 *
 * @author VIN31135
 */
public class LoginController {

	@FXML protected void handleSubmitButtonAction(ActionEvent event) {
		Node node = (Node)event.getSource();
		
		Text;
		
		Stage stage = (Stage)node.getScene().getWindow();
		stage.setTitle(Constants.TITLE + " " + Constants.VERSION);
		try {
			stage.setScene((Scene)FXMLLoader.load(getClass().getResource(Constants.MAIN_FXML_PATH_STRING)));
		} catch (IOException ex) {
			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
		}
		stage.centerOnScreen();
		stage.show();
	}
}