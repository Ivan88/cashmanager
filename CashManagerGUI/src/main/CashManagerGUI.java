/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.Constants;

/**
 *
 * @author Ivan
 */
public class CashManagerGUI extends Application {
	
	private Stage stage;
	
	private static CashManagerGUI instance;
	
	public static CashManagerGUI getInstance() {
		if (instance == null) {
			instance = new CashManagerGUI();
		}
		return instance;
	}
	
	private CashManagerGUI() {}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stage = primaryStage;
		stage.setTitle(Constants.TITLE + " " + Constants.VERSION + " " + Constants.SIGN_IN_STRING);
		gotoLogin();
		primaryStage.show();
	}

	private void gotoLogin() {
		try {
			replaceSceneContent(Constants.LOGIN_FXML_PATH_STRING);
		} catch (Exception ex) {
			Logger.getLogger(CashManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	private void gotoMain() {
		try {
			replaceSceneContent(Constants.MAIN_FXML_PATH_STRING);
		} catch (Exception ex) {
			Logger.getLogger(CashManagerGUI.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public boolean checkCredentials(String login, String password) {
		if (login.equals("ivan") && password.equals("ivan")) {
			gotoMain();
			return true;
		} else {
			return false;
		}
	}
	
	private Parent replaceSceneContent(String fxml) throws IOException {
		Parent page = (Parent)FXMLLoader.load(getClass().getResource(fxml), null, new JavaFXBuilderFactory());
		Scene scene = stage.getScene();
		if (scene == null) {
			scene = new Scene(page, 1000, 700);
			scene.getStylesheets().add(CashManagerGUI.class.getResource(Constants.DEFAULT_SKIN).toExternalForm());
			stage.setScene(scene);
		} else {
			stage.getScene().setRoot(page);
		}
		stage.sizeToScene();
		return page;
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
