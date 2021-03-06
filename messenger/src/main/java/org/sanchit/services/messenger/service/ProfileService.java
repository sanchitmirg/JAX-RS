package org.sanchit.services.messenger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.sanchit.service.messenger.database.DatabaseClass;
import org.sanchit.services.messenger.model.Message;
import org.sanchit.services.messenger.model.Profile;

public class ProfileService {
	
private HashMap<String, Profile> profiles = DatabaseClass.getProfile();
	
	public ProfileService(){
		
		profiles.put("Sanchit", new Profile(1,"Sanchit","Hello world", "Sanchit"));
		
	}
	
	public List<Profile> getAllProfiles(){
		
		return new ArrayList<Profile>(profiles.values());
		
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if (profile.getProfileName().isEmpty()) {
			return null;
		}
		
		profiles.put(profile.getProfileName(),profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
		
	}

}
