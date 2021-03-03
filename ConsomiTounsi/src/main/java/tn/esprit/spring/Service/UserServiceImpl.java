package tn.esprit.spring.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entities.User;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository userRepository;
	@Override
	public List<User> retrieveAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User addUser(User u) {
		return userRepository.save(u);
	}

	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}

	@Override
	public User updateUser(User u) {
		 userRepository.save(u);
		 return u;
	}

	@Override
	public User retrieveUser(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User authenticate(String login, String password) {
		 return userRepository.getUserByEmailAndPassword(login, password);
	}

}
