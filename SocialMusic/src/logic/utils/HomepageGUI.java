package logic.utils;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HomepageGUI {

	public static VBox getHomepageScene() {
		
		VBox root = new VBox();
		Text title = new Text();
		
		title.setText("Homepage");
		
		Button homeBTN = new Button("Social Music");
		Button messagesBTN = new Button("Messages");
		Button profileBTN = new Button("Profile");
		Button logoutBTN = new Button("Logout");
		Button samplePostBTN = new Button("Sample Posts");
		Button searchMemberBandBTN = new Button("Search Member / Search Band");
		Button topicBTN = new Button("Topics");
		Button rankingBTN = new Button("Ranking");
		Button doAReportBTN = new Button("Do a Report");
		Button viewRulesBTN = new Button("View Rules");
		
		WindowManagerGUI win = new WindowManagerGUI();
		
		homeBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
					
				win.loadHomePage();
			}
		});
		
		messagesBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
					
				win.loadMessagesPage();	
			}
		});
		
		profileBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
					
				win.loadProfilePage();
			}
		});
		
		logoutBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
					
				win.loadLoginPage();			
			}
		});
		
		samplePostBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
					
				win.loadSamplePostPage();
			}
		});
		
		searchMemberBandBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
					
				win.loadMemberBandPage();
			}
		});
		
		topicBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
					
				win.loadTopicPage();
			}
		});
		
		rankingBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
					
				win.loadRankingPage();
			}
		});
		
		doAReportBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
					
				win.loadDoAReportPage();
			}
		});
		
		viewRulesBTN.setOnAction(new EventHandler<ActionEvent>(){
			
			public void handle(ActionEvent event) {
					
				win.loadViewRulesPage();
			}
		});
		
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(title,homeBTN,messagesBTN,profileBTN,logoutBTN,samplePostBTN,searchMemberBandBTN,topicBTN,rankingBTN,doAReportBTN,viewRulesBTN);
		
		return root;
	}
}
