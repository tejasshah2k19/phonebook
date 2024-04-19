package com.cse5382.assignment.Service;

import com.cse5382.assignment.Repository.PhoneBookRepo;
import com.cse5382.assignment.Repository.PhoneBookRepository;
import com.cse5382.assignment.Model.PhoneBookEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PhoneBookServiceImpl implements PhoneBookService {
	@Autowired
	PhoneBookRepo phoneBookRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(PhoneBookServiceImpl.class);

	@Override
	public List<PhoneBookEntry> list() {
		return phoneBookRepository.findAll();
	}

	@Override
	public void add(PhoneBookEntry phoneBookEntry) {
		phoneBookRepository.save(phoneBookEntry);
	}

	@Override
	public void deleteByName(String name) {
		phoneBookRepository.deleteByName(name);
	}

	@Override
	public void deleteByNumber(String phoneNumber) {
		phoneBookRepository.deleteByPhoneNumber(phoneNumber);
	}
}
