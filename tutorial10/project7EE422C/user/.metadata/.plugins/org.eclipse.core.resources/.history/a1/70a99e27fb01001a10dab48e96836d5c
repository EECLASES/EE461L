package assignment7;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.fxml.FXMLLoader;

public class Dash extends Application {

	private static ClientThread myThread;

	
	
	public Dash(ClientThread myThread2,Stage stage) {
		Dash.setMyThread(myThread2);
		stage.close();
		Stage dashStage = new Stage();
		dashStage.initStyle(StageStyle.UNDECORATED);
		start(dashStage);
	}

	public static void setMyThread(ClientThread myThread) {
		Dash.myThread = myThread;
	}

	public static ClientThread getMyThread() {
    	return myThread;
    }

	@Override
	public void start(Stage primaryStage) {
		
		try {

			FXMLLoader dashLoader = new FXMLLoader(getClass().getResource("Dashboard.fxml"));
			DashController dashController = new DashController();
			dashLoader.setController(dashController);
			AnchorPane dashboardRoot = (AnchorPane) dashLoader.load();
			Scene dashboard = new Scene(dashboardRoot);
			dashboard.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// Sets the Chats scene
			FXMLLoader chatLoader = new FXMLLoader(getClass().getResource("Dashboard-Chats.fxml"));
			DashChatsController dashChatController = new DashChatsController();
			chatLoader.setController(dashChatController);
			AnchorPane dashboardChatRoot = (AnchorPane) chatLoader.load();
			Scene chatScene = new Scene(dashboardChatRoot);
			chatScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			//Sets the BroadCast scene
			FXMLLoader broadcastLoader = new FXMLLoader(getClass().getResource("Dashboard-Broadcasts.fxml"));
			DashBroadcastController dashBroadcastController = new DashBroadcastController();
			broadcastLoader.setController(dashBroadcastController);
			AnchorPane broadcastRoot = (AnchorPane) broadcastLoader.load();
			Scene broadcastScene = new Scene(broadcastRoot);
			chatScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			
			// sets the notifications scene
			FXMLLoader notificationsLoader = new FXMLLoader(getClass().getResource("Dashboard-Notifications.fxml"));
			DashNotificationsController dashNotificationsController = new DashNotificationsController();
			notificationsLoader.setController(dashNotificationsController);
			AnchorPane dashboardNotificationsRoot = (AnchorPane) notificationsLoader.load();
			Scene notificationsScene = new Scene(dashboardNotificationsRoot);
			notificationsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// sets the Friends scene
			FXMLLoader friendsLoader = new FXMLLoader(getClass().getResource("Dashboard-Friends.fxml"));
			DashFriendsController dashFriendsController = new DashFriendsController();
			friendsLoader.setController(dashFriendsController);
			AnchorPane dashboardFriendsRoot = (AnchorPane) friendsLoader.load();
			Scene friendScene = new Scene(dashboardFriendsRoot);
			friendScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			// sets the settingLoader
			FXMLLoader settingsLoader = new FXMLLoader(getClass().getResource("Dashboard-Settings.fxml"));
			
			DashSettingsController dashSettingsController = new DashSettingsController();
			settingsLoader.setController(dashSettingsController);
			AnchorPane dashboardSettingsRoot = (AnchorPane) settingsLoader.load();
			Scene settingsScene = new Scene(dashboardSettingsRoot);
			settingsScene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			dashController.dashInit(primaryStage, myThread, dashboard, chatScene, broadcastScene, notificationsScene, friendScene, settingsScene);
			dashChatController.dashInit(primaryStage, myThread, dashboard,chatScene, broadcastScene,  notificationsScene, friendScene, settingsScene);
			dashBroadcastController.dashInit(primaryStage, myThread, dashboard, chatScene, broadcastScene,notificationsScene, friendScene,settingsScene);
			dashNotificationsController.dashInit(primaryStage, myThread, dashboard, chatScene,broadcastScene, notificationsScene, friendScene,settingsScene);
			dashFriendsController.dashInit(primaryStage, myThread, dashboard, chatScene, broadcastScene, notificationsScene, friendScene,settingsScene);
			dashSettingsController.dashInit(primaryStage, myThread, dashboard, chatScene, broadcastScene, notificationsScene, friendScene,settingsScene);
			HashMap<String, Object> controllers = new HashMap<String, Object>();
			
			controllers.put("dash", dashController);
			controllers.put("chat", dashChatController);
			controllers.put("broadcast", dashBroadcastController);
			controllers.put("notification", dashNotificationsController);
			controllers.put("friend", dashFriendsController);
			controllers.put("setting", dashSettingsController);

			
			dashController.controllers(controllers);
			dashChatController.controllers(controllers);
			dashBroadcastController.controllers(controllers);
			dashNotificationsController.controllers(controllers);
			dashFriendsController.controllers(controllers);
			dashSettingsController.controllers(controllers);
			
			myThread.controllers(controllers);
			 
			
			// Sets the screen to the dashboard
			primaryStage.setScene(dashboard);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	
}
