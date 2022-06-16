package com.ben.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ben.dojosAndNinjas.models.Dojo;
import com.ben.dojosAndNinjas.repos.DojoRepo;

@Service
public class DojoServ {

	@Autowired
	private DojoRepo dRep;
	
//	|--- Get All ---|
	public List<Dojo> getAll() {
		return dRep.findAll();
	}
	
//	|--- Get One ---|
	public Dojo readOne(Long id) {
		Optional<Dojo> dojoOpt = dRep.findById(id);
		return dojoOpt.isPresent() ? dojoOpt.get() : null;
	}
//	|--- Create ---|
	public Dojo create(Dojo d) {
		return dRep.save(d);
	}
	
	public Dojo updateOne(Dojo d) {
		return dRep.save(d);
	}
	
	public void deleteOne(Long id) {
		dRep.deleteById(id);
	}
}
