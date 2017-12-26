package agency.july.entities;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "date_out")
	@Temporal(TemporalType.DATE)
	private Date dateOut;   

	@Column(name = "date_in")
	@Temporal(TemporalType.DATE)
	private Date dateIn;   

	@OneToOne
    @JoinColumn(name="book_id")
	private Book book;
	
	@OneToOne
    @JoinColumn(name="user_id")
	private User user;
	
	public Order() {}
	public Order(Date dateOut, Date dateIn) {
	    this.dateOut = dateOut;
	    this.dateIn = dateIn;
	}
	   
	public int getId() {
      return id;
	}
	public void setId( int id ) {
      this.id = id;
	}
   
	public Date getDateOut() {
      return dateOut;
	}
	public void setDateOut( Date dateOut ) {
      this.dateOut = dateOut;
	}
   
	public Date getDateIn() {
		return dateIn;
	}
	public void setDateIn( Date dateIn ) {
      this.dateIn = dateIn;
	}
	   
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
}
