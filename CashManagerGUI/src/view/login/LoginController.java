/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import main.CashManagerGUI;
import utils.Constants;

/**
 * FXML Controller class
 *
 * @author VIN31135
 */
public class LoginController {
	
	@FXML private TextField userNameField;
	@FXML private PasswordField passwordField;
	@FXML private Label errorMessageLabel;
	
	@FXML protected void handleSubmitButtonAction(ActionEvent event) {
		if (!CashManagerGUI.getInstance().checkCredentials(userNameField.getText(), passwordField.getText())) {
			errorMessageLabel.setText(Constants.LOGIN_ERROR_MESSAGE);
		}
		
//		Node node = (Node)event.getSource();
//		
//		Stage stage = (Stage)node.getScene().getWindow();
//		stage.setTitle(Constants.TITLE + " " + Constants.VERSION);
//		try {
//			scene = new Scene((Parent)FXMLLoader.load(getClass().getResource(Constants.MAIN_FXML_PATH_STRING)), 1000, 700);
//			stage.setScene(scene);
//		} catch (IOException ex) {
//			Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
//		}
//		stage.centerOnScreen();
//		stage.show();
		
		
	}
}