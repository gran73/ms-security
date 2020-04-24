package com.security.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.security.domain.ApplicationUser;
import com.security.repository.ApplicationUserRepository;

@RestController
@RequestMapping("/appusers")
public class ApplicationUserController {

	@Autowired
	private ApplicationUserRepository repo;

//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private ArrayList<ApplicationUser> list = new ArrayList<ApplicationUser>();
	
//	public ApplicationUserController (ApplicationUserRepository repo, BCryptPasswordEncoder bCryptPasswordEncoder) {
//		this.repo = repo;
//		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
//	}
	
	//default constructor
	public ApplicationUserController() {
		ApplicationUser c1 = new ApplicationUser(1, "Gurinder", "pass", "gurinder@abc.com");
		ApplicationUser c2 = new ApplicationUser(1, "Jyothi", "pass", "jyothi@abc.com");
		ApplicationUser c3 = new ApplicationUser(1, "Dan", "pass", "dan@abc.com");
		list.add(c1);
		list.add(c2);
		list.add(c3);
	}

//	@PostMapping("/sign-up")
//	public void signUp(@RequestBody ApplicationUser user) {
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//		repo.save(user);
//	}

	
	@GetMapping
	public String getAll() {
		String response = "[ ";
		for (int i = 0; i < list.size(); i++) {
			response += list.get(i).toJSON();
			if (i + 1 < list.size()) {
				response += ", ";
			}
		}
		response += " ]";
		return response;
	}

	@GetMapping("/{userId}")
	public String getUserById(@PathVariable("userId") long id) {
		String response = "{}";
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getId() == id) {
				response = list.get(i).toJSON();
			}
		}
		return response;
	}
}
