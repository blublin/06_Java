package com.ben.bookClub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ben.bookClub.models.Book;
import com.ben.bookClub.repos.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bRep;

//	|--- Get All ---|
	public List<Book> getAll() {
		return bRep.findAll();
	}

//	|--- Get One By ID ---|
	public Book readOne(Long id) {
		Optional<Book> bookOpt = bRep.findById(id);
		return bookOpt.isPresent() ? bookOpt.get() : null;
	}

//	|--- Create One ---|
	public Book create(Book b, BindingResult result) {
		Optional<Book> bookOpt = bRep.findByTitle(b.getTitle());
		if (bookOpt.isPresent()) {
			result.rejectValue("title", "bookError", "Title already exists");
		}
		if (result.hasErrors()) {
			return null;
		}
		
		return bRep.save(b);
	}

//	|--- Update One ---|
	public Book updateOne(Book b, BindingResult result) {
		if (result.hasErrors()) {
			return null;
		}
		return bRep.save(b);
	}

//	|--- Delete One ---|
	public void deleteOne(Long id) {
		bRep.deleteById(id);
	}
}