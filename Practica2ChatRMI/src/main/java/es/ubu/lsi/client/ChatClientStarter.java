package es.ubu.lsi.client;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import es.ubu.lsi.common.ChatMessage;
import es.ubu.lsi.server.ChatServer;
import es.ubu.lsi.server.ChatServerImpl;

public class ChatClientStarter implements Runnable {
	private final static String DEFAULT_HOST = "1099";
	
	private String nickname;
	private String host;
	
	private ChatClientImpl cliente;
	private ChatServerImpl serverObj;
	//private List<ChatClient> listaServidor;
	
	public ChatClientStarter(){
		
	}
	
	public ChatClientStarter(String nickname){
		this.nickname = nickname;
		this.host = DEFAULT_HOST;
		
		try{
			String serverURL = "rmi://localhost/Servidor";
			ChatServerImpl obj = (ChatServerImpl) Naming.lookup(serverURL);
			cliente = new ChatClientImpl(nickname, host);
			obj.checkIn(cliente);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	
	/*
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
	}
	*/
	
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
	
	public static void main(String[] args) {
		String serverURL = "rmi://localhost/Servidor";
		ChatClientImpl cliente;
		ChatServer server;
		
		try {
			//Registry registry = LocateRegistry.getRegistry("localhost", 1099);
			//ChatServerImpl serverObj = (ChatServerImpl) registry.lookup(serverURL);
			server = (ChatServer)Naming.lookup(serverURL); //Probar con ChatServerImpl
			cliente = new ChatClientImpl(args[0], DEFAULT_HOST);
			server.checkIn(cliente);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		new Thread( new ChatClientStarter(args[0]) ).start();
		
	}
	
	
}
