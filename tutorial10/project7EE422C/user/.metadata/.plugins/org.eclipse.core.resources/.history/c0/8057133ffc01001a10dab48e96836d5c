/* CHAT ROOM <MyClass.java> *
 * * EE422C Project 7 submission by 
 *  Miguel Garza Robledo
 *  Mag8238
 *  76050
 *  Slip days used: <0> 
 *  Summer 2019 
 * 
 *    Describe here known bugs or issues in this file.
 *     If your issue spans multiple files, or you are 
 *     not sure about details, add comments to the README.txt file.
 *     
 *     */

package assignment7;


import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Scanner;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;



public class ClientMain extends Application {

	
	/*Javafx variables
	 * 
	 */
	private double xOffset = 0;
	private double yOffset = 0;
	private String currentMessage;
	
	
	
	/*
	 * default border colors
	 */
	private static final Border black = new Border(new BorderStroke(Color.BLACK,
        BorderStrokeStyle.SOLID, new CornerRadii(8), new BorderWidths(2)));
    private static final Border red = new Border(new BorderStroke(Color.RED,
        BorderStrokeStyle.SOLID, new CornerRadii(8), new BorderWidths(2)));
    private static final Border blue = new Border(new BorderStroke(Color.BLUE,
        BorderStrokeStyle.SOLID, new CornerRadii(8), new BorderWidths(2)));
    private static final Color yellow = Color.YELLOW.deriveColor(0, .9, 1, 1);
	
	
    ArrayList<String> messages = new ArrayList<String>();
	
	/*
	 * IO connections and information
	 */

	private BufferedReader reader;
	private PrintWriter writer;
	private Socket sock;
	private String clientName;
	private String state = "noState";
	private String chatName = new String();
	private boolean newUser = true;
	
	
	
	/*
	 * 
	 * Any JavaFx declarations
	 */

    TextArea ta = new TextArea("");

    
	public void run(String[] args) throws Exception {

		launch(args);
		
		
	}

	
	
	@Override 
	public void start(Stage primaryStage) throws Exception{
		//This is the main grid using gridpane
		primaryStage.setTitle("Chat Server");
		primaryStage.initStyle(StageStyle.UNDECORATED);

        GridPane root = new GridPane();
        root.setPadding(new Insets(16));
        root.setVgap(16);
        root.setBorder(black);
        root.setBackground(new Background(new BackgroundFill(
            Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
        root.setOnMousePressed(new EventHandler<MouseEvent>(){
			
			@Override
			public void handle(MouseEvent event) {
				xOffset = event.getSceneX();
				yOffset = event.getSceneY();
			}
		});
		
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				primaryStage.setX(event.getScreenX() - xOffset);
				primaryStage.setY(event.getScreenY() - yOffset);
			}
			
			
		});
		

        
        
        BorderPane top = new BorderPane();
        top.setPadding(new Insets(16));
        top.setBorder(red);
        Button buttonCreateChat = new Button("create chat");
        top.setLeft(buttonCreateChat);
        buttonCreateChat.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		ta.appendText(clientName + " trying to create a chat");
        		state = "newGroupChat";
        		writer.println(clientName + " " + state + " " +"nothing");
        		writer.flush();
        	}
        });
        BorderPane.setMargin(ta, new Insets(16));
        top.setCenter(ta);
        top.setRight(createLabel("Label 3", yellow, 16));
        root.add(top, 0, 0);
        
        

        BorderPane bot = new BorderPane();
        bot.setPadding(new Insets(16));
        bot.setBorder(blue);
        TextField writtenText = new TextField();
        BorderPane.setMargin(writtenText, new Insets(16));
        bot.setCenter(writtenText);
        writtenText.setOnAction(e -> { 
			// gets the text
			currentMessage = writtenText.getText().trim(); 
			writtenText.setText("");
			
			 
			writer.println(clientName  + " " + state  + " "  + currentMessage); 
			writer.flush(); 
			
			

			
		}); 
        Button butt = new Button("Send");
        butt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
            	currentMessage = writtenText.getText().trim();
            	writtenText.setText("");
            	
            	writer.println(clientName + " " + state +  " " +  currentMessage); 
    			writer.flush();
            }
        });
        bot.setRight(butt);
        root.add(bot, 0, 1);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
		
        try { 

//			@SuppressWarnings("resource")
			sock = new Socket("127.0.0.1", 4242);
			InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
			reader = new BufferedReader(streamReader);
			writer = new PrintWriter(sock.getOutputStream());

			
			Thread readerThread = new Thread() {
				private BufferedReader userReader = reader; 
				private String codes[] = new String[3];
				
				
				public void run() {
					String message;
					
					
					
					try {
						while ((message = userReader.readLine()) != null) {
							codes = message.split(" ", 3);
							clientName = codes[0];
							state = codes[1];
							
							
							
								ta.appendText(codes[2] + "\n");
						}
					} catch (IOException ex) {
						ex.printStackTrace();
					}
				}
			};
			readerThread.start();
			
			
			
		} 
		catch (IOException ex) { 
			ta.appendText(ex.toString() + '\n');
		}
		
       
		
		

		
		
	}
	private void nLine() {
		ta.appendText("\n");
	}
	private Label createLabel(String text, Color color, int size) {
        Rectangle r = new Rectangle(3 * size, 2 * size);
        r.setFill(Color.TRANSPARENT);
        r.setStroke(color);
        r.setStrokeWidth(3);
        Label l = new Label(text, r);
        l.setContentDisplay(ContentDisplay.TOP);
        l.setTextFill(color);
        l.setFont(new Font(16));
        return l;
    }
	
	

	



	public static void main(String[] args) {
		try {
			new ClientMain().run(args);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



	
}