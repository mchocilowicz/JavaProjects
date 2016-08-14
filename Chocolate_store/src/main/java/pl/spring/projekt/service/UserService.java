package pl.spring.projekt.service;

import java.util.List;

import pl.spring.projekt.domain.User;
import pl.spring.projekt.domain.UserRole;

public interface UserService {

	public void addUser(User user);
	public void editUser(User user);
	public List<User> listUser();
	public void removeUser (int id);
	public User getUser(int id);
	
	public User findByLogin(String login);
	public String hashPassword(String password);
	
	public void addUserRole(UserRole userRole);
	public List<UserRole> listUserRole();
	public void removeUserRole (int id);
	public UserRole getUserRole(int id);
}
