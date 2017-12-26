package agency.july.service;

import agency.july.entities.Hands;
import agency.july.entities.Order;

public interface IOrderService {
	Order lend(Hands hands);
	Order inplace(Hands hands);
	Order inplace(int id);
}
