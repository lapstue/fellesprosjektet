package data;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

public class Authentication implements Serializeable {
	private String user;
	private String password;
	private String action;
	
	public Authentication(String user, String password, String action) {
		this.user = user;
		this.password = password;
		this.action = action;
	}
	public Authentication(){
		
	}
}
