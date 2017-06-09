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
	
	/**
	 * Dirección del servidor por defecto
	 */
	private final static String DEFAULT_HOST = "rmi://localhost/ChatServerImpl";
	
	/**
	 * Nickname del cliente
	 */
	private String nickname;
	
	/**
	 * Dirección del servidor
	 */
	private String host;
	
	/**
	 * Cliente
	 */
	private ChatClientImpl cliente;
	
	/**
	 * Servidor
	 */
	private ChatServerImpl server;
	
	/**
	 * Formato de la fecha
	 */
	SimpleDateFormat sdt = new SimpleDateFormat("hh:mm");
	
	/**
	 * Contructor de la clase ChatClientStarter
	 * @param args argumentos
	 */
	public ChatClientStarter(String[] args){
		
		//Comprobamos los argumentos y asignamos el nickname y el host
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
			
			// Mensaje de bienvenida
			cliente.receive(new ChatMessage(0, "Hola " + cliente.getNickName() + " escribe un mesaje: "));
			
			while(true){
				
				try {
					
					// Iniciamos el lector
					BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
					String msg = in.readLine();
					
					// Comprobamos el tipo de mensaje
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
