package com.ben.dojosAndNinjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ben.dojosAndNinjas.models.Ninja;

@Repository
public interface NinjaRepo extends CrudRepository<Ninja, Long> {

	List<Ninja> findAll();
}
