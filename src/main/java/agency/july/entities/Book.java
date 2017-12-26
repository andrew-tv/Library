package agency.july.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BOOK")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;

	@Column(name = "title")
	private String title; 
	
	@Column(name = "author")
	private String author;   

	public Book() {}
	public Book(String title, String author) {
		this.title = title;
	    this.author = author;
	}
	   
	public int getId() {
      return id;
	}
	public void setId( int id ) {
      this.id = id;
	}
   
	public String getTitle() {
      return title;
	}
	public void setTitle( String title ) {
      this.title = title;
	}
   
	public String getAuthor() {
      return author;
	}
	public void setAuthor( String author ) {
      this.author = author;
	}
}
