package agency.july.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import agency.july.entities.User;

@Repository
public class UserDAO implements IUserDAO {
	
	@PersistenceContext	
	private EntityManager entityManager;
	
	@Override
	public User getUserById(int id) {
		return entityManager.find(User.class, id);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUsers() {
		String hql = "FROM User as u ORDER BY u.lastName";
		return (List<User>) entityManager.createQuery(hql).getResultList();
	}
	
	@Override
	public void addUser(User user) {
		entityManager.persist(user);
	}
	
	@Override
	public void updateUser(User user) {
		User u = getUserById(user.getId());
		u.setFirstName(user.getFirstName());
		u.setLastName(user.getLastName());
		entityManager.flush();
	}
	
	@Override
	public void deleteUser(int id) {
		entityManager.remove(getUserById(id));
	}
	
	@Override
	public boolean userExists(String fname, String lname) {
		String hql = "FROM User as u WHERE u.firstName = ? and u.lastName = ?";
		int count = entityManager.createQuery(hql).setParameter(1, fname)
		              .setParameter(2, lname).getResultList().size();
		return count > 0 ? true : false;
	}
}
