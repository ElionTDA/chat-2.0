package es.ubu.lsi.server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class ChatServerStarter extends UnicastRemoteObject {
	
	private static final long serialVersionUID = 6608910429471937930L;

	protected ChatServerStarter() throws RemoteException, MalformedURLException {
		super();
	}
	
	
	public static void main(String[] args) {
		
		try {
			
			LocateRegistry.createRegistry(2020);
			
			ChatServer server = new ChatServerImpl();
			Naming.rebind("//localhost:2020/Servidor", server);
			System.out.println("Registro RMI completo");
			
			System.out.println("Servidor funcionando...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		

}
