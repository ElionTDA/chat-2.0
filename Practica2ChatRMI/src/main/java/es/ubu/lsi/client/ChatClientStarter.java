package es.ubu.lsi.client;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

import es.ubu.lsi.common.ChatMessage;
import es.ubu.lsi.server.ChatServerImpl;

public class ChatClientStarter {
	private final static String DEFAULT_HOST = "";
	
	private String nickname;
	private String host;
	
	private ChatClientImpl cliente;
	private ChatServerImpl serverObj;
	//private List<ChatClient> listaServidor;
	
	public ChatClientStarter(String nickname){
		this.nickname = nickname;
		this.host = DEFAULT_HOST;
		
		try{
			ChatServerImpl obj = (ChatServerImpl) Naming.lookup("rmi://localhost/ChatServerStarter");
			cliente = new ChatClientImpl(nickname, host);
			obj.checkIn(cliente);
		} catch (Exception e){
			e.printStackTrace();
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
			cliente = new ChatClientImpl(nickname, host);
			obj.checkIn(cliente);
		} catch (Exception e){
			e.printStackTrace();
		}
		start();
	}
	
	
	public void start(){
		boolean alive = true;
		while(alive){
			alive = false;
		}
	}
	
	public void run() {
		Scanner scanner = new Scanner(System.in);
		this.serverObj = new ChatServerImpl();
		
		while(true){
			//listaServidor = serverObj.getClientes();
			try {
				System.out.println("Hola, " + nickname + "introduce un mensaje: ");
				String msg = scanner.nextLine();
				if (  msg == "logout") serverObj.logout(cliente);
				ChatMessage mensaje = new ChatMessage(msg.hashCode(), msg);
				serverObj.publish(mensaje);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		
		}
		
	}
	
	
}
