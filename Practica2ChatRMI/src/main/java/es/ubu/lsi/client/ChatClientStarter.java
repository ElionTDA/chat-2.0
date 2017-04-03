package es.ubu.lsi.client;

public class ChatClientStarter {
	private final static String DEFAULT_HOST = "";
	
	private String nickname;
	private String host;
	
	public ChatClientStarter(String nickname, String host){
		this.nickname = nickname;
		
		if(host != null && host != ""){
			this.host = host;
		} else {
			this.host = DEFAULT_HOST;
		}
	}
}
