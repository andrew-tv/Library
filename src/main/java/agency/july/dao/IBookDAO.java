package agency.july.dao;

import java.util.List;

import agency.july.entities.Book;

public interface IBookDAO {
    List<Book> getAllBooks();
    Book getBookById(int articleId);
    void addBook(Book article);
    void updateBook(Book article);
    void deleteBook(int articleId);
    boolean bookExists(String title, String category);
}
