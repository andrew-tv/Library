package agency.july.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import agency.july.entities.Hands;
import agency.july.entities.Order;
import agency.july.service.IOrderService;

@Controller
@RequestMapping("orders")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	@PostMapping
	public ResponseEntity<Order> lendBookToUser(@RequestBody Hands hands) {
		return new ResponseEntity<Order> (orderService.lend(hands), HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Order> getBookFromUser(@PathVariable("id") int id) {
		return new ResponseEntity<Order> (orderService.inplace(id), HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<Order> getBookFromUser(@RequestBody Hands hands) {
		return new ResponseEntity<Order> (orderService.inplace(hands), HttpStatus.OK);
	}
}
