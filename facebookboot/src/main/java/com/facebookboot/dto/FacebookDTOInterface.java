package com.facebookboot.dto;

import java.util.List;
import java.util.Optional;

import com.facebookboot.entity.FacebookUser;

public interface FacebookDTOInterface {
	
	public FacebookUser createProfileDTO(FacebookUser fu);
	int deleteProfileDTO(long uid);
	Optional<FacebookUser> viewProfileDTO(long id);
	List<FacebookUser> viewAllProfileDTO();
	List<FacebookUser> searchProfileDTO(String name);
	int editProfileDTO(FacebookUser fu, long id);


}
