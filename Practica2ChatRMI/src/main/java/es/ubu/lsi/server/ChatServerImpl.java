package es.ubu.lsi.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import es.ubu.lsi.client.ChatClient;
import es.ubu.lsi.common.ChatMessage;

public class ChatServerImpl implements ChatServer, Serializable {

	private static final long serialVersionUID = -4226728489186953679L;
	
	private List<ChatClient> clientes;
	
	public ChatServerImpl(){
		super();
		clientes = new ArrayList<ChatClient>();
	}
	
	public List<ChatClient> getClientes(){
		return clientes;
	}
	
	public int checkIn(ChatClient client) throws RemoteException {
		if ( !clientes.contains(client) ) clientes.add(client);
		return client.getId();
	}

	public void logout(ChatClient client) throws RemoteException {
		clientes.remove(client);
		client.receive( new ChatMessage(0, "El cliente " + client.getNickName() + " se ha desconectado.") );
	}

	public void privatemsg(String tonickname, ChatMessage msg) throws RemoteException {
		// TODO Mandar mensage msg al cliente tonickname
	}

	public void publish(ChatMessage msg) throws RemoteException {
		System.out.println(msg.getNickname() + ": " + msg.getMessage());

	}

	public void shutdown(ChatClient client) throws RemoteException {
		// TODO Manda apagar el servidor

	}

}
