package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.spring.entities.User;



public interface IUserService {
	List<User> retrieveAllUsers();
	User addUser(User u);
	void deleteUser(int id);
	User updateUser(User u);
	User retrieveUser(int id);
	public User authenticate(String login, String password) ;
	
}
