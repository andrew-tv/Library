package agency.july.dao;

import agency.july.entities.Hands;
import agency.july.entities.Order;

public interface IOrderDAO {

	public Order lend(int userId, int bookId);
	public Order lend(Hands hands);
	public Order inplace(Hands hands);
	public Order inplace(int orderId);

}
