package es.ubu.lsi.server;

import java.lang.annotation.Inherited;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.RMIClassLoader;
import java.rmi.server.UnicastRemoteObject;
import java.util.Properties;

public class ChatServerStarter extends UnicastRemoteObject {
	
	private static final long serialVersionUID = 6608910429471937930L;

	protected ChatServerStarter() throws RemoteException {
		super();
	}
   	
   	

	public static void main(String args[]) {

   	}	
}
