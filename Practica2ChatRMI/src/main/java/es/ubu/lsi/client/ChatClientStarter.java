package es.ubu.lsi.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.text.SimpleDateFormat;
import java.util.Date;

import es.ubu.lsi.common.ChatMessage;
import es.ubu.lsi.server.ChatServerImpl;

public class ChatClientStarter {
	private final static String DEFAULT_HOST = "rmi://localhost/ChatServerImpl";
	
	private String nickname;
	private String host;
	
	private ChatClientImpl cliente;
	private ChatServerImpl server;
	
	SimpleDateFormat sdt = new SimpleDateFormat("hh:mm");
	
	public ChatClientStarter(){
		
	}
	
	public ChatClientStarter(String[] args){
		
		if (args.length == 2){
			nickname = args[0];
			host = args[1];
		} else if (args.length == 1) {
			nickname = args[0];
			host = DEFAULT_HOST;
		}else {
			System.err.println("Debes introducir al menos el nickname.");
		}
		
		try{
			
			// Registro del cliente en el servidor
			server = (ChatServerImpl) Naming.lookup(host);
			cliente = new ChatClientImpl();
			cliente.setNickame(nickname);
			cliente.setId(server.checkIn(cliente));
			
			// Guardamos la hora del registro del cliente
			cliente.setLoginTime( sdt.format(new Date()));
			
			cliente.receive(new ChatMessage(0, "Hola " + cliente.getNickName() + " escribe un mesaje: "));
			
			while(true){
				
				try {
					BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
					String msg = in.readLine();
					
					if (msg != null){
						if (msg.equals("logout")){
							server.logout(cliente);
						} else if ( msg.equals("who")){
							System.out.println("Lista de clientes conectados: ");
							for( ChatClient cliente : server.getClientes()){
								System.out.println("-" + cliente + "(" + cliente.getLoginTime() + ")");
							}
						} else {
							ChatMessage mensaje = new ChatMessage(cliente.getId(), msg);
							server.publish(mensaje);
						}
					}
					
				} catch (IOException e) {
					System.err.println("Error al introducir texto: " + e.getMessage());
				}
				
			}
			
		} catch (Exception e){
			System.err.println("Excepción en el cliente: " + e.getMessage());
		}
	}
	
}
