package assignment7;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


import de.jensd.fx.glyphs.GlyphIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class DashChatsController implements Initializable{


	    
		
    @FXML
    private TextField searchBar;

    @FXML
    private HBox panelDash1;

    @FXML
    private HBox panelNotifications1;

    @FXML
    private HBox panelFriends1;

    @FXML
    private HBox panelBroadcast1;

    @FXML
    private HBox panelChats1;

    @FXML
    private HBox panelSettings1;

    @FXML
    private Label friend11;

    @FXML
    private Label friend21;

    @FXML
    private Label friend31;

    @FXML
    private Button addFriend;

    

    @FXML
    private TextField userInput;

    @FXML
    private Button sendChatButton;

    

    

    @FXML
    private FontAwesomeIconView minimizeIcon;

    @FXML
    private FontAwesomeIconView exitIcon;
	    
	    //stage variables
	    private Stage stage;
		private Scene dashScene; 
		private Scene chatScene;
		private Scene notificationScene;
		private Scene friendScene;
		private Scene settingScene;
		private Scene broadcastScene;
		private double initialX= 0;
		private double initialY= 0;
		
		private static ClientThread myThread = Dash.getMyThread();
		
		
		
		
		//DASHChatController specific variables
	    @FXML
	    private  VBox ChatList;

	    @FXML
	    private  VBox ChatList1;
	   
	    @FXML
	    private Button createChat;
	    @FXML
	    private HBox comboBoxHBox;
	    @FXML
	    private Button emojiButton;

	    
	    private ComboBox<FontAwesomeIconView> emojiPull= new ComboBox<FontAwesomeIconView>();

       
	    @FXML
	    void addEmoji(ActionEvent event) {
	    	HBox newMessage = new HBox();
	    	Text text = new Text("You Reacted: ");
	    	ReactIcon newName = new ReactIcon(emojiPull.getSelectionModel().getSelectedItem().getGlyphName());
	    	
	    	newMessage.getChildren().addAll(text , newName.getPictureIcon());
			newMessage.setMargin(text, new Insets(0.0,0.0,0.0,20.0));
	    	ChatList1.getChildren().add(newMessage);
	    	
	    }
	    
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
	    	dashChats();
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
	    	DC.dashFriends();
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
		
	    
	    //Dash Chats Controller specific
	    @FXML
	    void createNewChat(ActionEvent event) {
	    	myThread.setState("newGroupChat");
    		myThread.sendWriter(userInput.getText().trim());
    		dashChats();
	    }
	    @FXML
	    void sendChatMessage(ActionEvent event) {
			
			myThread.setState("groupMessage");
			myThread.sendWriter(userInput.getText().trim());
			
			
			dashChats();
		}
		
	    
	    
	    
		 void dashChats() {
			
			myThread.getChatInfo();
			
			while(!myThread.isDashControllerReady() || !myThread.isControllerReady()) {
				System.out.println("waiting on Chats");
			}

			if(myThread.getListOfChats().size() > 0) {
				
				ChatList.getChildren().clear();
				ChatList.setSpacing(10.0);

			 for(String chat: myThread.getListOfChats()) {
				 
				HBox newChat = new HBox();
				Text newLabelChat = new Text(chat);
				newChat.getChildren().add(newLabelChat);
				newChat.setMargin(newLabelChat, new Insets(10.0,5.0,5.0,20.0));
				
				ChatList.getChildren().add(newChat);
				 
			 }
			 
			}
			
			if(myThread.getListOfMessages().size() > 0) {
				ChatList1.getChildren().clear();
				ChatList1.setSpacing(10.0);
				for(String message: myThread.getListOfMessages()) {
					
					HBox newMessage = new HBox();
					Text newLabel = new Text(message);
					newMessage.getChildren().add(newLabel);
					newMessage.setMargin(newLabel, new Insets(10.0,5.0,5.0,20.0));
					ChatList1.getChildren().add(newMessage);
				 }
			}
			if(myThread.getListOfNotifications().size() > 0) {
//				dashNotIcon.setText(Integer.toString(myThread.getListOfNotifications().size()));
			}
			
		}
		
	    public void dashInit(Stage primaryStage, ClientThread myThread, Scene dashScene, Scene chatScene, Scene broadcastScene, Scene notification, Scene friend, Scene setting) {
			
			this.stage = primaryStage;
			this.dashScene = dashScene;
			this.chatScene = chatScene;
			this.broadcastScene = broadcastScene;
			this.notificationScene = notification;
			this.friendScene = friend;
			this.settingScene = setting;
			
			
		}
	    
	    
	    
		 @Override
			public void initialize(URL arg0, ResourceBundle arg1) {
			 ReactIcon heart = new ReactIcon("HEART");
			 ReactIcon laugh = new ReactIcon("LAUGH");
			 ReactIcon dislike = new ReactIcon("DISLIKE");
			 ReactIcon like = new ReactIcon("LIKE");
			 ReactIcon sad = new ReactIcon("SAD");

			
		     

			 emojiPull.getItems().addAll(
					 heart.getPictureIcon(),
					 laugh.getPictureIcon(),
					 dislike.getPictureIcon(),
					 like.getPictureIcon(),
					 sad.getPictureIcon()
					 );
			 comboBoxHBox.getChildren().add(emojiPull);
				
			}
		 
		 private HashMap<String, Object> controllers;
		 public void controllers(HashMap<String, Object> controllers2) {
			 this.controllers = controllers2;
		 }
		 

		 

	}
