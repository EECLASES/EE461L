package assignment7;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DashFriendsController implements Initializable{

	   @FXML
	    private TextField userInput;

	    @FXML
	    private Button createChat;
		
		@FXML
	    private FontAwesomeIconView minimizeIcon;

	    @FXML
	    private FontAwesomeIconView exitIcon;
	    
		@FXML
	    private TextField searchBar;

	    @FXML
	    private HBox panelDash;

	    @FXML
	    private HBox panelNotifications;

	    @FXML
	    private HBox panelFriends;

	    @FXML
	    private HBox panelBroadcast;

	    @FXML
	    private HBox panelChats;

	    @FXML
	    private HBox panelSettings;

	    @FXML
	    private Label friend1;

	    @FXML
	    private Label friend2;

	    @FXML
	    private Label friend3;

	    @FXML
	    private Button addFriend;

	    @FXML
	    private Label dashNotIcon;

	    @FXML
	    private FontAwesomeIconView dashNotificationBell;

	    @FXML
	    private FontAwesomeIconView dashSettingsIcon;

	    @FXML
	    private Label timeActive;

	    @FXML
	    private Label timeActive1;

	    @FXML
	    private Label timeActive2;

	    @FXML
	    private ProgressIndicator MostPopularChat;

	    @FXML
	    private ProgressBar privateChats;

	    @FXML
	    private ProgressIndicator totalFriends;
	    
	    

	    @FXML
	    void buttonAddFriend(ActionEvent event) {

	    }

	    @FXML
	    void putIntoSearchbar(ActionEvent event) {

	    }
	    @FXML
	    void switchToBroadcasts(MouseEvent event) {
	    	DashBroadcastController DC = (DashBroadcastController) controllers.get("broadcast");

	    	stage.setScene(broadcastScene);
	    }

	    @FXML
	    void switchToChats(MouseEvent event) throws IOException {
	    	
	    	DashChatsController DC = (DashChatsController) controllers.get("chat");
	    	DC.dashChats();
	    	stage.setScene(chatScene);
	    }

	    @FXML
	    void switchToDash(MouseEvent event) throws IOException {
	    	DashController DC = (DashController) controllers.get("dash");

	    	stage.setScene(dashScene);
	    }

	    @FXML
	    void switchToFriends(MouseEvent event) throws IOException {
	    	DashFriendsController DC = (DashFriendsController) controllers.get("friend");
	    	dashFriends();
	    	stage.setScene(friendScene);
	    }

	    @FXML
	    void switchToNotifications(MouseEvent event) throws IOException {
	    	DashNotificationsController DC = (DashNotificationsController) controllers.get("notification");
	    	DC.dashNotifications();
	    	stage.setScene(notificationScene);
	    }

	    @FXML
	    void switchToSettings(MouseEvent event) throws IOException {
	    	DashSettingsController DC = (DashSettingsController) controllers.get("setting");
	    	DC.dashFriends();
	    	stage.setScene(settingScene);
	    }
	    @FXML
	    void exitProgram(MouseEvent event) {
	    	myThread.setState("quit");
	    	myThread.sendWriter("");
	    	System.exit(2);
	    	stage.close();
	    }

	    @FXML
	    void lowerScreen(MouseEvent event) {
	    	stage.toBack();
	    }
	    private double initialX= 0;
		private double initialY= 0;
	    @FXML
	    void getInitialStage(MouseEvent event) {
		  
		  	initialX = event.getSceneX();
          	initialY = event.getSceneY();
	    }
	  
	    @FXML
	    void stageDrag(MouseEvent event) {
		  stage.setX(event.getScreenX() - initialX);
          stage.setY(event.getScreenY() - initialY);
          
	    }
		
	    
		
		private Stage stage;
		private Stage switchStaged = new Stage();
		
		
		
		
		
		private ClientThread myThread;
		
		
		
		

	    @FXML
	    private VBox ChatList;

	    @FXML
	    private VBox ChatList1;

		
		
		

		 @Override
			public void initialize(URL arg0, ResourceBundle arg1) {
				
				
				
				
			}
		 private HashMap<String, Object> controllers;
		 public void controllers(HashMap<String, Object> controllers2) {
			 this.controllers = controllers2;
		 }
		 
		 public void dash() throws IOException {
			 
			 timeActive.setText(myThread.getTime());
				timeActive1.setText(Integer.toString(myThread.getListOfMessages().size()));
				timeActive2.setText(Integer.toString(myThread.getFriends().size()));
				this.dashNotIcon.setText(Integer.toString(myThread.getListOfNotifications().size()));
				if(myThread.getFriends().size()>2) {
					friend1.setText(myThread.getFriends().get(1));
					friend2.setText(myThread.getFriends().get(2));
					friend3.setText(myThread.getFriends().get(3));
				}
			 
			 
			 switchStaged.setScene(dashScene);
			 switchStaged.show();
			 
			 stage.close();
			 
		 }
		 public void dashChats() throws IOException {
			 
			 
			 
			

			
			 switchStaged.setScene(chatScene);
			 switchStaged.show();
			 
			 stage.close();
			 
		 }
		 
		 
		 
		 
		@FXML
		private VBox notificationsList;
		 
		private FXMLLoader dashLoader;
		private Scene dashScene; 
		private Scene chatScene;
		private Scene notificationScene;
		private Scene friendScene;
		private Scene settingScene;
		private Scene broadcastScene;
		 


		public void dashInit(Stage primaryStage, ClientThread myThread, Scene dashScene, Scene chatScene, Scene broadcastScene, Scene notification, Scene friend, Scene setting) {
			
			this.stage = primaryStage;
			this.myThread = myThread;
			this.dashScene = dashScene;
			this.chatScene = chatScene;
			this.broadcastScene = broadcastScene;
			this.notificationScene = notification;
			this.friendScene = friend;
			this.settingScene = setting;
			
			
		}

		public void dashFriends() {
			// TODO Auto-generated method stub
			
		}
		 

	}
