package com.facebookboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.facebookboot.dto.FacebookDTOInterface;
import com.facebookboot.entity.FacebookUser;

@Service
public class FacebookService implements FacebookServiceInterface {
	
	@Autowired
	private FacebookDTOInterface ft;

	@Transactional
	public FacebookUser createProfile(FacebookUser fu) {
		return ft.createProfileDTO(fu);
	}

	@Override
	public int deleteProfile(long uid) {
		 ft.deleteProfileDTO(uid);
		 return 1;
	}

	@Override
	public Optional<FacebookUser> viewProfile(long id) {
		return ft.viewProfileDTO(id);
	}

	@Override
	public List<FacebookUser> viewAllProfile() {
		return ft.viewAllProfileDTO();
	}

	@Override
	public List<FacebookUser> searchProfile(String name) {
		return ft.searchProfileDTO(name);
	}

	@Override
	public int editProfile(FacebookUser fu, long id) {
		int i = ft.editProfileDTO(fu, id);
		return i;
	}

}
