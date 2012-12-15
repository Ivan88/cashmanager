/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Constants;

/**
 *
 * @author Ivan
 */
public class CashManagerGUI extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle(Constants.TITLE + " " + Constants.VERSION + " " + Constants.SIGN_IN_STRING);
		primaryStage.setScene(new Scene((Parent)FXMLLoader.load(getClass().getResource(Constants.LOGIN_FXML_PATH_STRING)), 300, 300));
		primaryStage.show();
	}

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
