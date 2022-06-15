package com.ben.fullCRUD.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ben.fullCRUD.models.Expense;
import com.ben.fullCRUD.repos.ExpenseRepo;

@Service
public class ExpenseService {

	@Autowired
	private ExpenseRepo expRepo;
	
//	|--- Get All ---|
	public List<Expense> readAll() {
		return expRepo.findAll();
	}
	
//	|--- Get One ---|
	public Expense readOne(Long id) {
		Optional<Expense> expOpt = expRepo.findById(id);
		return expOpt.isPresent() ? expOpt.get() : null;
	}
//	|--- Create ---|
	public Expense create(Expense e) {
		return expRepo.save(e);
	}
	
	public Expense updateOne(Expense e) {
		return expRepo.save(e);
	}
}
