package tn.esprit.spring.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



import tn.esprit.spring.Configuration.UserPrincipal;
import tn.esprit.spring.Repository.RoleRepository;
import tn.esprit.spring.Repository.UserRepository;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;


@Service
@Qualifier("UserDetailsService")
public class UserServiceImpl implements IUserService{

	@Autowired
	UserRepository userRepository;
	@Autowired
	RoleRepository RoleRepository;
	@Autowired
	PasswordEncoder passwordEncoder;
    
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

	//@Override
	//public User authenticate(String login, String password) {
		 //userRepository.getUserByEmailAndPassword(login, password);
	//}
	
    

   
    @Override
    public User saveUser(String username, String password, String confirmedPassword) {
        User  user=userRepository.findByUsername(username);
        if(user!=null) throw new RuntimeException("User already exists");
        if(!password.equals(confirmedPassword)) throw new RuntimeException("Please confirm your password");
        User User=new User();
        User.setUsername(username);
        User.setActived(true);
        User.setPassword(passwordEncoder.encode(password));
        userRepository.save(User);
        addRoleToUser(username,"USER");
        return User;
    }

    @Override
    public Role save(Role role) {
        return RoleRepository.save(role);
    }

    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        tn.esprit.spring.entities.User user=userRepository.findByUsername(username);
        if(user==null) throw new UsernameNotFoundException("invalid user");
        Collection<GrantedAuthority> authorities=new ArrayList<>();
        user.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
        return new UserPrincipal(user);
    }

    @Override
    public void addRoleToUser(String username, String rolename) {
        User User=userRepository.findByUsername(username);
        Role Role=RoleRepository.findByRoleName(rolename);
        User.getRoles().add(Role);
    }

    @Override
	public User findUserByUserName(String userName) {
		
		return userRepository.findByUsername(userName);
		
	}
}
