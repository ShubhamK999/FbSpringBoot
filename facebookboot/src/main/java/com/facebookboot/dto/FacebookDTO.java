package com.facebookboot.dto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.facebookboot.dao.FacebookDAOInterface;
import com.facebookboot.entity.FacebookUser;

@Service
public class FacebookDTO implements FacebookDTOInterface {
	@Autowired
	private FacebookDAOInterface fd;

	@Transactional
	public FacebookUser createProfileDTO(FacebookUser fu) {
		return fd.save(fu);
	}

	@Override
	public int deleteProfileDTO(long uid) {
		 fd.deleteById(uid);
		 return 1;
	}

	@Override
	public Optional<FacebookUser> viewProfileDTO(long id) {
		return fd.findById(id);
	}

	@Override
	public List<FacebookUser> viewAllProfileDTO() {
		return fd.findAll();
	}

	@Override
	public List<FacebookUser> searchProfileDTO(String name) {
		return fd.findAll();
	}

	@Override
	public int editProfileDTO(FacebookUser fu, long id) {
		int i=0;
		fu.setUid(id);
		fd.save(fu);
		i=1;
		return i;
	}


}
