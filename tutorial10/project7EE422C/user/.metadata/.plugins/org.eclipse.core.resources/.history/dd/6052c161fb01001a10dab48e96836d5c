package assignment7;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ClientThread {
	private static Thread readerThread;
	/*
	 * IO connections and information
	 */
	private boolean controllerReady = false;
	private boolean dashControllerReady = false;
	
	

	private BufferedReader reader;
	private PrintWriter writer;
	private Socket sock;
	private String clientName = new String();
	private String state = new String();
	private String stateInfo = new String();
	private boolean openDashBool = false;
	public String pendingMessage = new String();
	private String time = new String();
	private int timeSeconds = 0;
	private String serverMessage = new String();
	
	public String getServerMessage() {
		return serverMessage;
	}

	public int getTimeSeconds() {
		return timeSeconds;
	}

	public void setTimeSeconds(int timeSeconds) {
		this.timeSeconds = timeSeconds;
	}

	
	private ArrayList<String> listOfNotifications = new ArrayList<String>();
	private ArrayList<String> listOfChats = new ArrayList<String>();
	private ArrayList<String> listOfMessages = new ArrayList<String>();

	

	
	public ArrayList<String> getListOfMessages() {
		return listOfMessages;
	}

	private HashMap<String, Object> controllers;
	 public void controllers(HashMap<String, Object> controllers2) {
		 this.controllers = controllers2;
	 }
	
	
	public ClientThread() throws UnknownHostException, IOException {
		sock = new Socket("127.0.0.1", 4242);
		InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
		reader = new BufferedReader(streamReader);
		writer = new PrintWriter(sock.getOutputStream());
		
		readerThread = new Thread() {
			
			private String codes[] = new String[3];
			
			
			public void run() {
				String message;
				
				
				
				
				try {
					while ((message = reader.readLine()) != null) {
						
							
							System.out.println("processing " + message + " ");
							codes = message.split(" ", 2);
							clientName = codes[0];
							stateInfo = codes[1];
							if(stateInfo.equals("quit")) {
								System.exit(1);
								break;
								
							}
							else {
								parseLoginInfo(stateInfo);
							}
						
						
						

					}
					System.out.println("The thread has ended");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		};
		readerThread.start();
	} 
	
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public void parseLoginInfo(String data) throws IOException {
		String serverCodes[] = new String[2];
		serverCodes = data.split(" ", 2);
		
		state = serverCodes[0];
		
		//Start of switch statements...
		
		switch(state)
		
		{
			case "dash":
				openDashBool = true;
				
			break;
				
			case "login":
				serverMessage = serverCodes[1];
			break;
				
			case "Friends":
				int number = Integer.parseInt(serverCodes[1].trim());
				if(number > 0) {
					String[] friendsString = new String[number];
					friendsString = serverCodes[2].split("++", number);
					friends.clear();
					for(String friend: friendsString) {
						friends.add(friend);
					}
				}
			break;
				
			case "TimeActive":
				this.setTimeSeconds(Integer.parseInt(serverCodes[1]));
				this.setTime(serverCodes[1]);
			
			break;
				
			case "Chats":
				String parseItems[] = new String[2];
				
				this.listOfChats.clear();

				//This is to parse the Item amount
				parseItems = serverCodes[1].split(" ", 2);
				int itemLength = Integer.parseInt(parseItems[0]);
				for(String groupName: parseItems[1].split(" ")) {
					this.listOfChats.add(groupName);
				}
				
				
			break;
			
			case "Notifications":
				String parseItems1[] = new String[2];

				//This is to parse the Item amount
				parseItems1 = serverCodes[1].split(" ", 2);
				
				int notificationNum = Integer.parseInt(parseItems1[0]);
				
				
				String[] allNotifications = new String[notificationNum];
				allNotifications = parseItems1[1].split(" \\ ");

				listOfNotifications.clear();
				for (String notification: allNotifications) {
					this.listOfNotifications.add(notification);
				}
				
			break;
			
			case "Messages":
				String parseItems11[] = new String[2];

				//This is to parse the Item amount
				parseItems11 = serverCodes[1].split(" ", 2);
				
				int MessagesNum = Integer.parseInt(parseItems11[0]);
				
				
				String[] messages = new String[MessagesNum];
				messages = parseItems11[1].split(" \\ ");

				this.listOfMessages.clear();
				for (String message: messages) {
					this.listOfMessages.add(message);
				}
				
			break;
			
			default:
				System.out.println("No match for " + state);
				break;
		
		
		
		}
		controllerReady = true;
		System.out.println("processed");
	

		
	}
	 public boolean isControllerReady() {
		return controllerReady;
	}


	public String getState() {
		return state;
	}

	public boolean isOpenDashBool() {
		return openDashBool;
	}

	public void setOpenDashBool(boolean openDashBool) {
		this.openDashBool = openDashBool;
	}


	public void sendWriter(String str) {
    	    controllerReady = false;
			writer.println(clientName + " " + state + " " + str);
			writer.flush();
		
	}
	public void setState(String myState) {
			state = myState;
	}

	public void getDashInfo() {
		dashControllerReady = false;
		this.state = "getTimeActive";
		sendWriter("");
		this.state = "getFriends";
		sendWriter("");
		this.state = "getMessages";
		sendWriter("");
		this.state = "getNotifications";
		sendWriter("");
		this.state = "getChats";
		sendWriter("");

		dashControllerReady = true;
		
	}
	public void getChatInfo() {
		dashControllerReady = false;
		this.state = "getChats";
		sendWriter("");
		this.state = "getMessages";
		sendWriter("");
		this.state = "getNotifications";
		sendWriter("");
		
		dashControllerReady = true;
	}
	
	public void getFriendsInfo() {
		dashControllerReady = false;
		this.state = "getFriends";
		sendWriter("");
		dashControllerReady = true;
		
	}
	public boolean isDashControllerReady() {
		return dashControllerReady;
	}

	public void getNotificationsInfo() {
		this.state = "getNotifications";
		sendWriter("");
		
	}
	public void getSettingsInfo() {
		
	}
	public void getBroadcastInfo() {
		
	}
	
	
	public ArrayList<String> getListOfNotifications() {
		return listOfNotifications;
	}

	public void setListOfNotifications(ArrayList<String> listOfNotifications) {
		this.listOfNotifications = listOfNotifications;
	}

	

	
	public ArrayList<String> getListOfChats() {
		return listOfChats;
	}

	public void setListOfChats(ArrayList<String> listOfChats) {
		this.listOfChats = listOfChats;
	}

	private ArrayList<String> friends = new ArrayList<String>();
	
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public ArrayList<String> getFriends() {
		return friends;
	}

	public void setFriends(ArrayList<String> friends) {
		this.friends = friends;
	}
	
	}


