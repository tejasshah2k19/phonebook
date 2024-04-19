package com.cse5382.assignment.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cse5382.assignment.Model.PhoneBookEntry;
import com.cse5382.assignment.Service.PersonLogService;
import com.cse5382.assignment.Service.PhoneBookService;

@RestController
public class Controller {
	@Autowired
	PhoneBookService phoneBookService;

	@Autowired
	PersonLogService personLogService;

	@GetMapping(path = "phoneBook/list")
	public List<PhoneBookEntry> list() {
		personLogService.addLog("LIST", "-");
		return phoneBookService.list();
	}

	@PostMapping(path = "phoneBook/add")
	public ResponseEntity<?> add(@RequestBody PhoneBookEntry phoneBookEntry) {
		try {
			phoneBookService.add(phoneBookEntry);
			personLogService.addLog("ADD", phoneBookEntry.getName());
		} catch (Exception e) {
			return new ResponseEntity<Error>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(path = "phoneBook/deleteByName")
	public ResponseEntity<?> deleteByName(@RequestParam String name) {
		try {
			phoneBookService.deleteByName(name);
			personLogService.addLog("REMOVE", name);

		} catch (Exception e) {
			return new ResponseEntity<Error>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(path = "phoneBook/deleteByNumber")
	public ResponseEntity<?> deleteByNumber(@RequestParam String number) {
		try {
			phoneBookService.deleteByNumber(number);

			personLogService.addLog("REMOVE", number);

		} catch (Exception e) {
			return new ResponseEntity<Error>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
