package es.ubu.lsi.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import es.ubu.lsi.client.ChatClient;
import es.ubu.lsi.common.ChatMessage;

public class ChatServerImpl implements ChatServer, Serializable {

	private static final long serialVersionUID = -4226728489186953679L;
	
	/**
	 * Lsta de los clientes conctados
	 */
	private List<ChatClient> clientes;
	
	/**
	 * Constructor de la clase ChatServerImpl
	 * @throws RemoteException
	 */
	public ChatServerImpl() throws RemoteException {
		super();
		clientes = new ArrayList<ChatClient>();
	}
	
	/**
	 * Devuelve los clientes conectados actualmente
	 * @return clientes
	 */
	public List<ChatClient> getClientes(){
		return clientes;
	}
	
	/**
	 * Registers a new client.
	 * 
	 * @param client client
	 * @return client id
	 * @throws RemoteException remote error
	 */
	public int checkIn(ChatClient client) throws RemoteException {
		if ( !clientes.contains(client) ) clientes.add(client);
		return client.getId();
	}

	/**
	 * Unregisters a new client.
	 * 
	 * @param client current client
	 * @throws RemoteException remote error
	 */
	public void logout(ChatClient client) throws RemoteException {
		clientes.remove(client);
		client.receive( new ChatMessage(0, "El cliente " + client.getNickName() + " se ha desconectado.") );
	}

	/**
	 * Sends a private message to a user.
	 * 
	 * @param tonickname string
	 * @param msg message
	 * @throws RemoteException remote error
	 */
	public void privatemsg(String tonickname, ChatMessage msg) throws RemoteException {
		// TODO Mandar mensage msg al cliente tonickname
	}

	/**
	 * Publishs a received message.
	 * 
	 * @param msg message
	 * @throws RemoteException remote error
	 */
	public void publish(ChatMessage msg) throws RemoteException {
		System.out.println(msg.getNickname() + ": " + msg.getMessage());

	}

	/**
	 * Orders of shutdown server.
	 * 
	 * @param client current client sending the message
	 * @throws RemoteException remote error
	 */
	public void shutdown(ChatClient client) throws RemoteException {
		// TODO Manda apagar el servidor

	}

}
