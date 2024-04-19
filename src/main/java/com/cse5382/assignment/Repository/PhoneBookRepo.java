package com.cse5382.assignment.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cse5382.assignment.Model.PhoneBookEntry;

public interface PhoneBookRepo extends JpaRepository<PhoneBookEntry, String>{

	void deleteByName(String name);

	void deleteByPhoneNumber(String phoneNumber);
	
	

}
