package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;



public interface IUserService extends UserDetailsService {
	List<User> retrieveAllUsers();
	User addUser(User u);
	void deleteUser(Long id);
	User updateUser(User u);
	User retrieveUser(Long id);
	//public User authenticate(String login, String password) ;
	public User saveUser(String username,String password,String confirmedPassword);
    public Role save(Role role);
    public UserDetails loadUserByUsername(String username);
    public void addRoleToUser(String username,String rolename);
    public User findUserByUserName(String userName);
    public void affecterUserADonation(String username, int donationId);
    public void desaffecterUserDuDonation(String username, int donationId);
	
}
