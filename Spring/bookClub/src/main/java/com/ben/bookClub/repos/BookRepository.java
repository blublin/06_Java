package com.ben.bookClub.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ben.bookClub.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {

//	Overwrite findAll
	List<Book> findAll();
}
