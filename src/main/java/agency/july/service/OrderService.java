package agency.july.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agency.july.dao.IOrderDAO;
import agency.july.entities.Hands;
import agency.july.entities.Order;

@Transactional
@Service
public class OrderService implements IOrderService {

	@Autowired
	private IOrderDAO orderDAO;
	
	@Override
	public Order lend(Hands hands) {
		return orderDAO.lend(hands);
	}

	@Override
	public Order inplace(int id) {
		return orderDAO.inplace(id);
	}

	@Override
	public Order inplace(Hands hands) {
		return orderDAO.inplace(hands);
	}
}
