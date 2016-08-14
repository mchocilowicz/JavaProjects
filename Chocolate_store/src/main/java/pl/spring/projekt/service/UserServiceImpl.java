package pl.spring.projekt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.spring.projekt.dao.UserDAO;
import pl.spring.projekt.domain.User;
import pl.spring.projekt.domain.UserRole;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	UserDAO userDAO;
	
	@Transactional
	public void addUser(User user) {
		//user.getUserRole().add(userDAO.findRoleByName("ROLE_USER"));
		user.setPassword(hashPassword(user.getPassword()));
		userDAO.addUser(user);
	}
	
	@Transactional
	public void editUser(User user) {
		user.setPassword(hashPassword(user.getPassword()));
		userDAO.editUser(user);
	}

	@Transactional
	public List<User> listUser() {
		
		return userDAO.listUser();
	}

	@Transactional
	public void removeUser(int id) {
		userDAO.removeUser(id);
	}
	
	@Transactional
	public User getUser(int id) {
		return userDAO.getUser(id);
	}
	
	@Transactional
	public String hashPassword(String password)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
	}
	
	public void addUserRole(UserRole userRole) {
		userDAO.addRole(userRole);
	}
	
	public List<UserRole> listUserRole() {
		return userDAO.listUserRole();
	}
	
	public void removeUserRole (int id) {
		userDAO.removeUserRole(id);
	}
	
	public UserRole getUserRole(int id) {
		return userDAO.getUserRole(id);
	}

	@Transactional
	public User findByLogin(String login) {
		return userDAO.findByLogin(login);
	}
}
