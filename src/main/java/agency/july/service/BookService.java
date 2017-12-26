package agency.july.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agency.july.dao.IBookDAO;
import agency.july.entities.Book;

@Service
public class BookService implements IBookService {
	
	@Autowired
	private IBookDAO bookDAO;
	
	@Override
	public Book getBookById(int id) {
		Book obj = bookDAO.getBookById(id);
		return obj;
	}
	
	@Override
	public List<Book> getAllBooks(){
		return bookDAO.getAllBooks();
	}
	
	@Transactional
	@Override
	public synchronized boolean addBook(Book book){
       if (bookDAO.bookExists(book.getTitle(), book.getAuthor())) {
    	   return false;
       } else {
    	   bookDAO.addBook(book);
    	   return true;
       }
	}
	
	@Transactional
	@Override
	public void updateBook(Book book) {
		bookDAO.updateBook(book);
	}
	
	@Transactional
	@Override
	public void deleteBook(int id) {
		bookDAO.deleteBook(id);
	}
}
