package agency.july.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import agency.july.entities.Book;

@Repository
public class BookDAO implements IBookDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public Book getBookById(int id) {
		return entityManager.find(Book.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Book> getAllBooks() {
		String hql = "FROM Book as b ORDER BY b.id";
		return (List<Book>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public void addBook(Book book) {
		entityManager.persist(book);
	}
	
	@Override
	public void updateBook(Book book) {
		Book b = getBookById(book.getId());
		b.setTitle(book.getTitle());
		b.setAuthor(book.getAuthor());
		entityManager.flush();
	}
	
	@Override
	public void deleteBook(int id) {
		entityManager.remove(getBookById(id));
	}
	
	@Override
	public boolean bookExists(String title, String author) {
		String hql = "FROM Book as b WHERE b.title = ? and b.author = ?";
		int count = entityManager.createQuery(hql).setParameter(1, title)
		              .setParameter(2, author).getResultList().size();
		return count > 0 ? true : false;
	}
}
