package es.ubu.lsi.server;

import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatServerStarter extends UnicastRemoteObject implements Runnable {
	
	private static final long serialVersionUID = 6608910429471937930L;

	protected ChatServerStarter() throws RemoteException {
		super();
	}

	public void run() {
		//TODO: Run 
	}	

	public static void main(String[] args) throws RemoteException, IOException {
		
		ChatServer server = new ChatServerImpl();
		
		Naming.rebind("rmi://localhost/ChatServerStarter", server);
		System.out.println("Registro RMI completo");
		
		//Thread t = new Thread(server).start();
		
		System.out.println("Servidor funcionando...");
	}

}
