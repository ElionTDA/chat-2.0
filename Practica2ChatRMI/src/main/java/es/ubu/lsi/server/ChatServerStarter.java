package es.ubu.lsi.server;

import java.rmi.Naming;

public class ChatServerStarter {

	public ChatServerStarter() {
		
		try {
			
			ChatServerImpl serverObj = new ChatServerImpl();
			Naming.rebind("/ChatServerImpl", serverObj);
			System.out.println("Servidor funcionando...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
		

}
