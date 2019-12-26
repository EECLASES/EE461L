package assignment7;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Chat extends Observable {
	
	private String chatName;
	private ArrayList<ClientObserver> Observers;
	
	
	public Chat(String name) {
		this.chatName = name;
		this.Observers = new ArrayList<ClientObserver>();
	}
	public ArrayList<ClientObserver> getObservers() {
		return Observers;
	}
	public void addObserver(ClientObserver groupMember) {
		Observers.add(groupMember);
		
		
	}
	
	public void send(String args) {
		this.setChanged();
		for(ClientObserver groupMember: Observers) {
			if(groupMember != null && groupMember.getGroupChat().equals(chatName)) {
				groupMember.getNotifications().add(args);
				groupMember.getMessages().add(args);
				groupMember.setState(groupMember.getGroupChat());
				groupMember.println(groupMember.getName() + " " + groupMember.getGroupChat() + " " + args);
				groupMember.flush();
			}
		}
		
	}
	public String getName() {
		return this.chatName;
	}
	public void updateObserver(ClientObserver a, String chatname) {
		int index = Observers.indexOf(a);
		ClientObserver updateObserver;
		updateObserver= Observers.remove(index);
		updateObserver.setGroupChat(this);
		Observers.add(updateObserver);
		Observers.get(index).setGroupChat(this);
		a.setGroupChat(this);
	}
	public boolean contains(ClientObserver passedObserver) {
		for(ClientObserver groupMember : Observers) {
			if(groupMember.getName().equals(passedObserver.getName())) {
				return true;
			}
		}
		return false;
	}
	

}
