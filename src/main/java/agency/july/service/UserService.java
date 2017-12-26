package agency.july.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import agency.july.dao.IUserDAO;
import agency.july.entities.User;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserDAO userDAO;
	
	@Override
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}
	
	@Override
	public List<User> getAllUsers(){
		return userDAO.getAllUsers();
	}
	
	@Transactional
	@Override
	public synchronized boolean addUser(User User){
       if (userDAO.userExists(User.getFirstName(), User.getLastName())) {
    	   return false;
       } else {
    	   userDAO.addUser(User);
    	   return true;
       }
	}
	
	@Transactional
	@Override
	public void updateUser(User User) {
		userDAO.updateUser(User);
	}
	
	@Transactional
	@Override
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}
}
