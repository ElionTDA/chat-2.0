package es.ubu.lsi.server;

import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import es.ubu.lsi.client.ChatClient;
import es.ubu.lsi.client.ChatClientImpl;
import es.ubu.lsi.common.ChatMessage;

public class ChatServerImpl implements ChatServer {

	private List<ChatClient> clientes;
	
	public ChatServerImpl(){
		super();
		clientes = new ArrayList<ChatClient>();
	}
	
	public int checkIn(ChatClient client) throws RemoteException {
		if ( !clientes.contains(client) ) clientes.add(client);
		return client.getId();
	}

	public void logout(ChatClient client) throws RemoteException {
		clientes.remove(client);
	}

	public void privatemsg(String tonickname, ChatMessage msg) throws RemoteException {
		// TODO Mandar mensage msg al cliente tonickname
	}

	public void publish(ChatMessage msg) throws RemoteException {
		// TODO Publica un mensaje recibido

	}

	public void shutdown(ChatClient client) throws RemoteException {
		// TODO Manda apagar el servidor

	}
	
	public static void main(String[] args) throws RemoteException, IOException {
		
		ChatServer server = new ChatServerImpl();
		
		Naming.rebind("rmi://localhost/ChatServerStarter", server);
		System.out.println("Registro RMI completo");
		
		Thread t = new Thread((ChatClientImpl)server);
		t.start();
		System.out.println("Servidor funcionando...");
	}

}
