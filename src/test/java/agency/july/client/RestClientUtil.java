package agency.july.client;

import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import agency.july.entities.Book;

public class RestClientUtil {
	
    public void getBookByIdDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/books/{id}";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Book> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Book.class, 1);
        Book book = responseEntity.getBody();
        System.out.println("Id: " + book.getId() + ", Title: " + book.getTitle()
                 + ", Author:" + book.getAuthor());      
    }
    
	public void getAllBooksDemo() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/books";
        HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
        ResponseEntity<Book[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, Book[].class);
        Book[] books = responseEntity.getBody();
        for(Book book : books) {
              System.out.println( "Id: "+ book.getId() + ", Title: " + book.getTitle()
                      + ", Author: " + book.getAuthor() );
        }
    }
	
    public void addBookDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/books";
	    Book aBook = new Book();
	    aBook.setTitle("Spring Hibernate");
	    aBook.setAuthor("Spring");
        HttpEntity<Book> requestEntity = new HttpEntity<Book>(aBook, headers);
        URI uri = restTemplate.postForLocation(url, requestEntity);
        System.out.println( uri.getPath() );    	
    }
    
    public void updateBookDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/books";
	    Book aBook = new Book();
	    aBook.setId(1);
	    aBook.setTitle("Java Concurrency");
	    aBook.setAuthor("Java");
        HttpEntity<Book> requestEntity = new HttpEntity<Book>(aBook, headers);
        restTemplate.put(url, requestEntity);
    }
    
    public void deleteBookDemo() {
    	HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	    String url = "http://localhost:8080/books/{id}";
        HttpEntity<Book> requestEntity = new HttpEntity<Book>(headers);
        restTemplate.exchange(url, HttpMethod.DELETE, requestEntity, Void.class, 4);        
    }
    
    public static void main(String args[]) {
    	RestClientUtil util = new RestClientUtil();
        //util.getBookByIdDemo();
    	//util.getAllBooksDemo();
    	util.addBookDemo();
    	//util.updateBookDemo();
    	//util.deleteBookDemo();
    }    
}
