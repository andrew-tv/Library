package agency.july.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import agency.july.entities.Order;

@Repository
public class HandsDao implements IHandsDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;
		
	// Method to return all debtors on this date
	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getDebtors() {
		String hql = "SELECT H.order FROM Hands AS H";
		return (List<Order>) entityManager.createQuery(hql).getResultList();
	}
}
