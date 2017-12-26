package agency.july.dao;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import agency.july.entities.Book;
import agency.july.entities.Hands;
import agency.july.entities.Order;
import agency.july.entities.User;

@Repository
public class OrderDAO implements IOrderDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	// Method to LEND a book to an user (Tables: orders (add record), on_hands (add record))
	public Order lend(int userId, int bookId) {
			
		Order order = new Order(new Date(), null);
		User user =  entityManager.find(User.class, userId);
		Book book =  entityManager.find(Book.class, bookId);
		order.setUser(user);
		order.setBook(book);
		entityManager.persist(order);
		
		Hands hands = new Hands();
		hands.setOrder(order);
		hands.setBook(book);
		hands.setUser(user);
		entityManager.persist(hands);
			
		return order;
	}
	
	// Method to LEND a book to an user (Tables: orders (add record), on_hands (add record))
	// Return a new order
	public Order lend(Hands hands) {
			
		Order order = new Order(new Date(), null);
		User user =  (User) entityManager.find(User.class, hands.getUser().getId());
		Book book =  (Book) entityManager.find(Book.class, hands.getBook().getId());
		order.setUser(user);
		order.setBook(book);
		entityManager.persist(order);
		
		hands.setOrder(order);
		entityManager.persist(hands);
			
		return order; // New order
	}

	// Method to return a book to the Library (Tables: orders (update a record), on_hands (delete a record))
	// Returns a closed order
	public Order inplace(Hands hands) {

		Hands deletedHands =  (Hands) entityManager.find(Hands.class, hands.getOrder().getId());

		Order order = deletedHands.getOrder(); // Closed order
			
		order.setDateIn(new Date());
		entityManager.flush();

		entityManager.remove( deletedHands );
		
		return order; // Closed order
	}

	// Method to return a book to the Library (Tables: orders (update a record), on_hands (delete a record))
	public Order inplace(int orderId) {

		Hands hands =  (Hands) entityManager.find(Hands.class, orderId);

		Order order =  hands.getOrder();
		
		order.setDateIn(new Date());
		entityManager.flush();

		entityManager.remove(hands);
			
		return order; // Closed order
	}
}
