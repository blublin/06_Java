package com.ben.bookClub.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ben.bookClub.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

//	Overwrite findAll
	List<User> findAll();

//	Add any extra custom queries
//	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
//	https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methodss
	Optional<User> findByEmail(String email);

}