package agency.july.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import agency.july.dao.IHandsDAO;
import agency.july.entities.Order;

@Service
public class HandsService implements IHandsService {
	
	@Autowired
	private IHandsDAO handsDAO;

	@Override
	public List<Order> getDebtors() {
		return handsDAO.getDebtors();
	}
}
