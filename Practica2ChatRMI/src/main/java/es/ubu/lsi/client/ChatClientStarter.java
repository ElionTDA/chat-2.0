package es.ubu.lsi.client;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import es.ubu.lsi.server.ChatServer;
import es.ubu.lsi.server.ChatServerImpl;

public class ChatClientStarter {
	private final static String DEFAULT_HOST = "";
	
	private String nickname;
	private String host;
	
	public ChatClientStarter(String nickname){
		this.nickname = nickname;
		this.host = DEFAULT_HOST;
		
		try{
			ChatServerImpl obj = (ChatServerImpl) Naming.lookup("rmi://localhost/ChatServerStarter");
		} catch (Exception e){
			
		}
		
		start();
	}
	public ChatClientStarter(String nickname, String host){
		this.nickname = nickname;
		
		if(host != null && host != ""){
			this.host = host;
		} else {
			this.host = DEFAULT_HOST;
		}
		try{
			ChatServerImpl obj = (ChatServerImpl) Naming.lookup("rmi://localhost/ChatServerStarter");
		} catch (Exception e){
			
		}
		
		start();
	}
	
	
	public void start(){
		boolean alive = true;
		while(alive){
			alive = false;
		}
	}
	
	
}
