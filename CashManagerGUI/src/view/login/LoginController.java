/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.login;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author VIN31135
 */
public class LoginController {

	@FXML private Text actionTarget;
	
	@FXML protected void handleSubmitButtonAction(ActionEvent event) {
		actionTarget.setText("Sign in button pressed");
	}
}
