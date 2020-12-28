package com.facebookboot.controller;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.dao.DataAccessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.facebookboot.entity.FacebookUser;

import com.facebookboot.service.FacebookServiceInterface;
@RestController
public class FacebookController {
	
	@Autowired
	private FacebookServiceInterface fs;
	
	//@Autowired
	//private FacebookDAOInterface fd;
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Profile with this id not present")
    @ExceptionHandler({Exception.class})
    public void handleException() {
      
    }
    @ExceptionHandler({SQLException.class, DataAccessException.class})
      public String databaseError() {
        return "Profile with this id not present in your database";
      }
	
	@PostMapping("createprofilefacebook")
	public String createProfile(@RequestBody FacebookUser fu) {
		String str="Registration Failed";
		FacebookUser f1 =fs.createProfile(fu);
		if(f1!=null) {
			str="Registration Success";
		}
		return str;
	}
	
	@DeleteMapping("deleteprofilefacebook")
	public String deleteProfile(@PathParam("uid") long uid) {
		String str= "Hii";
		int i = fs.deleteProfile(uid);
		if(i>0) {
			str = "Profile Deleted";
		}
		else {
			str = "Could not delete profile";
		}
		return str;
	}
	
	@GetMapping("viewprofilefacebook")
	public Optional<FacebookUser> viewProfile(@PathParam("id") long id) {
		Optional<FacebookUser> fb = fs.viewProfile(id);
		return fb;
	}
	
	@GetMapping("viewAllprofilefacebook")
	public List<FacebookUser> viewallProfile() {
		List<FacebookUser> ll= fs.viewAllProfile();
		return ll;
	}
	
	@GetMapping("searchprofilefacebook")
	public List<FacebookUser> searchProfile(@PathParam("name") String name) {
		List<FacebookUser> ll= fs.searchProfile(name);
		List<FacebookUser> l1= new ArrayList<FacebookUser>();
		for(FacebookUser f1 : ll) {
			if(f1.getUsername().equals(name)) {
				l1.add(f1);
			}
		}
		return l1;
	}
	
	@PutMapping("editprofilefacebook")
	public String editProfile(@RequestBody FacebookUser fu, @PathParam("id") long id) {
		String str = "";
		int i = fs.editProfile(fu, id);
		if(i>0) {
			str = "Profile Updated";
		}
		else {
			str = "Could not update profile";
		}
		return str;
	}

}
