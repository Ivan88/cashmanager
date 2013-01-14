/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.tabs;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author VIN31135
 */
public class PlansTabController implements Initializable {

	private int columnIndex=0;
	private int rowIndex=2;
	ComboBox<String> cb;
	TextField tf1;
	TextField tf2;
	GridPane gp;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
	}

	@FXML
	public void addPlanItem(Event e) {
		Node node = (Node)e.getSource();
		VBox hb = (VBox)node.getParent();
		HBox vb = (HBox)hb.getParent();
		gp = (GridPane)vb.lookup("#plansGrid");

		cb = new ComboBox<String>();
		cb.setPrefWidth(200.0);
		tf1 = new TextField();
		tf1.setPrefWidth(200.0);
		tf2 = new TextField();
		tf2.setPrefWidth(400.0);
		gp.add(cb, columnIndex++, rowIndex);
		gp.add(tf1, columnIndex++, rowIndex);
		gp.add(tf2, columnIndex++, rowIndex);
		columnIndex = 0;
		rowIndex++;
	}

	@FXML
	public void savePlans() {

	}
}