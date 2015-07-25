package fansticlist.user;

import javax.jws.soap.SOAPBinding.Use;

public class User {
	Long uid;
	String userName;
	String email;
	String nickName;
	
	public User(Long uid, String userName, String email, String nickName){
		this.uid = uid;
		this.userName = userName;
		this.email = email;
		this.nickName = nickName;
	}
	public Long getUid() {
		return uid;
	}
	public String getUserName() {
		return userName;
	}
	public String getEmail() {
		return email;
	}
	public String getNickName() {
		return nickName;
	}
}
