/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cashmanagergui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Ivan
 */
public class CashManagerGUI extends Application {
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		primaryStage.setTitle("Cash Manager Sign in");
		primaryStage.setScene((Scene)FXMLLoader.load(getClass().getResource("view.login.login.fxml")));
		primaryStage.show();
//		primaryStage.setTitle("Cash Manager 1.0");
//		primaryStage.setScene((Scene)FXMLLoader.load(getClass().getResource("view.main.fxml")));
//		primaryStage.show();
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
