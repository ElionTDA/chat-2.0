package es.ubu.lsi.client;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import es.ubu.lsi.common.ChatMessage;

public class ChatClientImpl extends UnicastRemoteObject implements ChatClient {

	private static final long serialVersionUID = 2414385719069389674L;
	
	/**
	 * Id del cliente
	 */
	private int id;
	
	/**
	 * Nickname del cliente
	 */
	private String nickname;
	
	/**
	 * Hora de inicio del cliente
	 */
	private String loginTime;
	
	/**
	 * Constructor de la clase ChatServerImpl
	 * @throws RemoteException
	 */
	public ChatClientImpl() throws RemoteException {
		super();
	}
	
	/**
	 * Gets current id.
	 * 
	 * @return id
	 * @see #setId
	 * @throws RemoteException if remote communication has problems
	 */
	public int getId() throws RemoteException {
		return id;
	}

	/**
	 * Sets current id.
	 * 
	 * @param id id
	 * @see #getId
	 * @throws RemoteException if remote communication has problems
	 */
	public void setId(int id) throws RemoteException {
		this.id = id;
	}

	/**
	 * Receives a new message.
	 * 
	 * @param msg message
	 * @throws RemoteException if remote communication has problems
	 */
	public void receive(ChatMessage msg) throws RemoteException {
		if (msg.getId() != 0){
			System.out.println("> " + msg.getNickname() + ": " + msg.getMessage());
		} else{
			System.out.println("> " + msg.getMessage());
		}
	}

	/**
	 * Gets the current nickname.
	 * 
	 * @return nickname
	 * @throws RemoteException if remote communication has problems
	 */
	public String getNickName() throws RemoteException {
		return nickname;
	}
	
	/**
	 * Sets current nickname.
	 * 
	 * @param nickname nickname
	 * @see #getNickname
	 * @throws RemoteException if remote communication has problems
	 */
	public void setNickame(String nickname) throws RemoteException {
		this.nickname = nickname;
	}
	
	/**
	 * Gets the login time.
	 * 
	 * @return loginTime 
	 * @throws RemoteException if remote communication has problems
	 */
	public String getLoginTime() throws RemoteException {
		return loginTime; 
	}
	
	/**
	 * Sets the login time.
	 * 
	 * @param time loginTime
	 * @see #getLoginTime
	 * @throws RemoteException if remote communication has problems
	 */
	public void setLoginTime(String time) throws RemoteException {
		this.loginTime = time;
	}

}
