package es.ubu.lsi.server;

import java.rmi.RemoteException;

import es.ubu.lsi.client.ChatClient;
import es.ubu.lsi.common.ChatMessage;

public class ChatServerImpl implements ChatServer {

	public ChatServerImpl(){
		
	}
	
	public int checkIn(ChatClient client) throws RemoteException {
		// TODO devuelve un id al clinete.
		return 0;
	}

	public void logout(ChatClient client) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public void privatemsg(String tonickname, ChatMessage msg) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public void publish(ChatMessage msg) throws RemoteException {
		// TODO Auto-generated method stub

	}

	public void shutdown(ChatClient client) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
