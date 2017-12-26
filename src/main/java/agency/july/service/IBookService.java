package agency.july.service;

import java.util.List;

import agency.july.entities.Book;

public interface IBookService {
     List<Book> getAllBooks();
     Book getBookById(int id);
     boolean addBook(Book book);
     void updateBook(Book book);
     void deleteBook(int book);
}
