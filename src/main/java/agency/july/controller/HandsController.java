package agency.july.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import agency.july.entities.Order;
import agency.july.service.IHandsService;

@Controller
@RequestMapping("users")
public class HandsController {
	
	@Autowired
	private IHandsService handsService;
	
	@GetMapping("debtors")
	public ResponseEntity<List<Order>> getDebtors() {
		List<Order> list = handsService.getDebtors();
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
	}
}
