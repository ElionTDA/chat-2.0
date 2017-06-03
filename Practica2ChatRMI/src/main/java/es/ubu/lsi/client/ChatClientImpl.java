package es.ubu.lsi.client;

import java.rmi.RemoteException;

import es.ubu.lsi.common.ChatMessage;

public class ChatClientImpl implements ChatClient, Runnable {

	private int id;
	private String nickname;
	private String hostname;
	
	public ChatClientImpl(String nickname){
		this.nickname = nickname;
		this.hostname = "";
	}
	
	public ChatClientImpl(String nickname, String hostname){
		this.nickname = nickname;
		this.hostname = hostname;
	}
	
	public int getId() throws RemoteException {
		return id;
	}

	public void setId(int id) throws RemoteException {
		this.id = id;
	}

	public void receive(ChatMessage msg) throws RemoteException {
		// TODO Auto-generated method stub
	}

	public String getNickName() throws RemoteException {
		return nickname;
	}

	public void run() {
		// TODO Auto-generated method stub
		
	}

}
