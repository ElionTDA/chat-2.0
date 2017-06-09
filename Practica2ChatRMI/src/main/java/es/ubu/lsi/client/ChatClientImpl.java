package es.ubu.lsi.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import es.ubu.lsi.common.ChatMessage;

public class ChatClientImpl extends UnicastRemoteObject implements ChatClient {

	private static final long serialVersionUID = 2414385719069389674L;
	private int id;
	private String nickname;
	private String loginTime;
	
	public ChatClientImpl() throws RemoteException {
		super();
	}
	
	public int getId() throws RemoteException {
		return id;
	}

	public void setId(int id) throws RemoteException {
		this.id = id;
	}

	public void receive(ChatMessage msg) throws RemoteException {
		if (msg.getId() != 0){
			System.out.println(msg.getNickname() + ": " + msg.getMessage());
		} else{
			System.out.println("> " + msg.getMessage());
		}
	}

	public String getNickName() throws RemoteException {
		return nickname;
	}
	
	public void setNickame(String nickname){
		this.nickname = nickname;
	}
	
	public void setLoginTime(String string){
		this.loginTime = string;
	}
	
	public String getLoginTime(){
		return loginTime; 
	}

}
