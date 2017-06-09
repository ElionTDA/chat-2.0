package es.ubu.lsi.server;

import java.rmi.Naming;

public class ChatServerStarter {

	/**
	 * Constructor de la clase ChatServerStarter
	 */
	public ChatServerStarter() {
		
		try {
			
			//Registro de la instancia del servidor
			ChatServerImpl serverObj = new ChatServerImpl();
			Naming.rebind("/ChatServerImpl", serverObj);
			System.out.println("Servidor funcionando...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
		

}
