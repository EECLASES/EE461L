package assignment7;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

public  class ClientObserver extends PrintWriter implements Observer {
	
	private static String currentState = new String();
	private static boolean passwordSet;
	private static boolean groupChatChange;
	private static TimeWatch watch;
	private static String clientNumber = new String();
	private static String clientName = new String();
	private static String password = new String();
	private static String whichGroupchat = new String();
	private static ArrayList<String> notifications;
	private static ArrayList<Chat> listOfChats;
	private static ArrayList<String> messages;
	private static ArrayList<String> myFriends = new ArrayList<String>();
	
	public ArrayList<String> getNotifications() {
		return notifications;
	}
	
	
	public ArrayList<Chat> getListOfChats() {
		return listOfChats;
	}
	
	
	public ArrayList<String> getFriends() {
		return myFriends;
	}
	
	public ClientObserver(OutputStream out, String clientNum, String groupChatName ) {
		super(out);
		clientNumber = clientNum;
		whichGroupchat = groupChatName;
		passwordSet = true;
		listOfChats = new ArrayList<Chat>();
		
		currentState = "normal";
		clientName = clientNumber;
		notifications = new ArrayList<String>();
		messages = new ArrayList<String>();
		
		
	}
	public ArrayList<String> getMessages() {
		return messages;
	}
	
	public long getTime() {
		return watch.time(TimeUnit.SECONDS);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		
		this.println(arg); //writer.println(arg);
		this.flush(); //writer.flush();
	}
	public String getName() {
		return clientName;
	}
	public String getGroupChat() {
		return whichGroupchat;
	}
	public void setGroupChat(Chat chat) {
		this.addGroupchat(chat);
		whichGroupchat = chat.getName();
	}
	public void setName(String name) {
		clientName = name;
	}

	public void addGroupchat(Chat chat) {
		listOfChats.add(chat);
	}
	public boolean checkGroupChat(Chat checkingChat) {
			if(listOfChats.contains(checkingChat)){
				return true;
			}
			return false;
	}
	public static String getPassword() {
		return password;
	}


	public static void setPassword(String password) {
		ClientObserver.password = password;
	}


	public String getClientNumber() {
		return clientNumber;
	}
	public void addFriend(String newFriend) {
		myFriends.add(newFriend);
	}
	public void setState(String state ) {
		currentState =   state;
	}
	public String getPersonInfo() {
		return clientName + " " + currentState + " ";
	}
	public void setPass(String pass) {
		password = pass;
		watch = TimeWatch.start();

	}
	
}
