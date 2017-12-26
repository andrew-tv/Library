package agency.july.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "on_hands")
public class Hands implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@OneToOne
    @JoinColumn(name="book_id")
	private Book book;
	
	@OneToOne
    @JoinColumn(name="user_id")
	private User user;
	
	@Id
	@OneToOne
    @JoinColumn(name="order_id")
	private Order order;

	public Hands() {}
	public Book getBook() {
      return book;
	}
	
	public void setBook( Book book ) {
      this.book = book;
	}

	public User getUser() {
		return user;
	}
	public void setUser( User user ) {
		this.user = user;
	}

	public Order getOrder() {
		return order;
	}
	public void setOrder( Order order ) {
		this.order = order;
	}
}
