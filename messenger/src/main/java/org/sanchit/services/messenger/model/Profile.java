package org.sanchit.services.messenger.model;

import java.util.Date;

public class Profile {
	
	private long id;
	private String profileName;
	private String message;
	private Date created;
	private String author;
	
	public Profile(){
		
	} 
	
	public Profile(long id,String profileName, String message, String author){
		this.id = id;
		this.profileName = profileName;
		this.message = message;
		this.author = author;
		
	}
	
	public String getProfileName() {
		return profileName;
	}

	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
