package com.facebookboot.service;

import java.util.List;
import java.util.Optional;

import com.facebookboot.entity.FacebookUser;


public interface FacebookServiceInterface {
	public FacebookUser createProfile(FacebookUser fu);

	public int deleteProfile(long uid);

	public Optional<FacebookUser> viewProfile(long id);

	public List<FacebookUser> viewAllProfile();

	public List<FacebookUser> searchProfile(String name);

	public int editProfile(FacebookUser fu, long id); 
}
