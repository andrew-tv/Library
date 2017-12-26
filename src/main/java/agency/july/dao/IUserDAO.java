package agency.july.dao;

import java.util.List;

import agency.july.entities.User;

public interface IUserDAO {
    List<User> getAllUsers();
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(int id);
    boolean userExists(String fname, String lname);
	User getUserById(int id);
}
