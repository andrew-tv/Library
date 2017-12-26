package agency.july.service;

import java.util.List;

import agency.july.entities.User;

public interface IUserService {
     List<User> getAllUsers();
     User getUserById(int id);
     boolean addUser(User user);
     void updateUser(User user);
     void deleteUser(int user);
}
