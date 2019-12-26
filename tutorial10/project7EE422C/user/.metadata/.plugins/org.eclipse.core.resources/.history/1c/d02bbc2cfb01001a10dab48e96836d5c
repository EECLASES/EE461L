package assignment7;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;


public class UserMain extends Application {
	
	
	Stage window;
	
	
	
	
	@Override
	public void start(Stage primaryStage) {
		
		window = primaryStage;
		try {
			//Initializes controller
			FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("login.fxml"));
			LoginController loginController= new LoginController(window);
			loginLoader.setController(loginController);
			
			
			AnchorPane loginRoot = (AnchorPane)loginLoader.load();
			Scene login = new Scene(loginRoot);
			login.getStylesheets().add(getClass().getResource("dark-login.css").toExternalForm());
			

			
			primaryStage.initStyle(StageStyle.UNDECORATED);
			//Sets initial screen as the login screen
			primaryStage.setScene(login);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
			
			
			
			
			
			
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		try {
			UserMain myNewMain = new UserMain();
			myNewMain.run(args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void run(String[] args) throws Exception {
		
		launch(args);
		
		
	}
	
	
	

}
