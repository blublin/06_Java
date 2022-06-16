package com.ben.dojosAndNinjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ben.dojosAndNinjas.models.Ninja;
import com.ben.dojosAndNinjas.repos.NinjaRepo;

@Service
public class NinjaServ {

	@Autowired
	private NinjaRepo nRep;
	
//	|--- Get All ---|
	public List<Ninja> getAll() {
		return nRep.findAll();
	}
	
//	|--- Get One ---|
	public Ninja readOne(Long id) {
		Optional<Ninja> ninjaOpt = nRep.findById(id);
		return ninjaOpt.isPresent() ? ninjaOpt.get() : null;
	}
//	|--- Create ---|
	public Ninja create(Ninja n) {
		return nRep.save(n);
	}
	
	public Ninja updateOne(Ninja n) {
		return nRep.save(n);
	}
	
	public void deleteOne(Long id) {
		nRep.deleteById(id);
	}
}
