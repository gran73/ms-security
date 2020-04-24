package com.security.repository;

import org.springframework.data.repository.CrudRepository;
import com.security.domain.ApplicationUser;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {

	//ApplicationUser findbyUsername(String username);	
	
}
