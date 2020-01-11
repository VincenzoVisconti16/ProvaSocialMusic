package logic.boundary;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import logic.utils.WindowManagerGUI;

public class RecoverDataGUI {

	public static VBox getRecoverDataPageScene() {
			
		VBox root = new VBox();		
		Button recoverDataBTN = new Button("Recupera Dati");
		Button backBTN = new Button("Back");
		
		WindowManagerGUI win = new WindowManagerGUI();
	
		recoverDataBTN.setOnAction(new EventHandler<ActionEvent>(){
		
			public void handle(ActionEvent event) {
					
					
				}
			});
		
		backBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
				
				win.loadLoginPage(); 
			}
			
		});
			
		root.getChildren().addAll(recoverDataBTN,backBTN);
		root.setAlignment(Pos.CENTER);

		return root;
	}

}
