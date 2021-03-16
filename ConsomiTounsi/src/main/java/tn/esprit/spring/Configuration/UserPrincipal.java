package tn.esprit.spring.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



import tn.esprit.spring.entities.Role;








public class UserPrincipal implements UserDetails  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private tn.esprit.spring.entities.User user;
	
	public UserPrincipal(tn.esprit.spring.entities.User user) {
		super();
		this.user = user;
	}
	
    @Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

    	Collection<GrantedAuthority> authorities=new ArrayList<>();
        this.user.getRoles().forEach(r->{
            authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
        });
    	

		return authorities;
	}
   
    @Override
	public String getPassword() {
		return this.user.getPassword();
	}

	@Override
	public String getUsername() {
		return this.user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.user.isActived();
	}

	

}
