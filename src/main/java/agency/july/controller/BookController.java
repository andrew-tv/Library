package agency.july.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import agency.july.entities.Book;
import agency.july.service.IBookService;

@Controller
@RequestMapping("books")
public class BookController {
	
	@Autowired
	private IBookService bookService;
	
	@GetMapping("{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") Integer id) {
		Book book = bookService.getBookById(id);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> list = bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(list, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> addBook(@RequestBody Book book, UriComponentsBuilder builder) {
        if ( bookService.addBook(book) ) { // Success
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(builder.path("/books/{id}").buildAndExpand(book.getId()).toUri());
            return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
        } else { // This book already exists
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
	}
	
	@PutMapping
	public ResponseEntity<Book> updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deleteArticle(@PathVariable("id") Integer id) {
		bookService.deleteBook(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
} 