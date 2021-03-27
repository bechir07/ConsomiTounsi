package tn.esprit.spring.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import lombok.Data;
import tn.esprit.spring.Configuration.JWTTokenUtil;
import tn.esprit.spring.Configuration.UserPrincipal;
import tn.esprit.spring.Service.IUserService;
import tn.esprit.spring.Service.UserServiceImpl;
import tn.esprit.spring.entities.User;

@RestController
public class UserRestController {

	@Autowired
	IUserService userService;

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTTokenUtil jwtTokenUtil;
	
	 @PostMapping("/register")
	    public User register(@RequestBody  UserForm userForm){
	        return  userService.saveUser(
	                userForm.getUsername(),userForm.getPassword(),userForm.getConfirmedPassword());
	    }
	 @PostMapping(path="/login" , consumes = {MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_JSON_VALUE})
		public ResponseEntity<User> login(@RequestBody UserLogin userr) {
			
			this.authenticate(userr.getUsername(), userr.getPassword());
			
			User user = userService.findUserByUserName(userr.getUsername());
			
			user.setPassword(null);
			System.out.println("hani");
			String jwtToken = this.jwtTokenUtil.generateToken(new UserPrincipal(user));
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("Authorization", "Bearer "+jwtToken);
			
			return ResponseEntity.ok().headers(headers).body(user);
			
		}
		private void authenticate(String userName, String password) {

			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
			
		}
		@RequestMapping(value="/getLoggedUser")
		public User getLoggedUser (HttpServletRequest httpServletRequest){
			
			//HttpSession httpSession=httpServletRequest.getSession();
			//SecurityContext securityContext=(SecurityContext) httpSession.getAttribute("SPRING_SECURITY_CONTEXT");
			//String username=securityContext.getAuthentication().getName();
			//System.out.println(username);
			//return userService.findUserByUserName(username);
			//Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			//if (principal instanceof UserDetails) {
			  //String username = ((UserDetails)principal).getUsername();
			  //System.out.println(username);
			//} else {
			  //String username = principal.toString();
			  
			//}
		//}
			String requestToken = httpServletRequest.getHeader("Authorization");
			
			String userName = null;
			String jwtToken = null;
			
			jwtToken = requestToken.substring(7);
			userName = this.jwtTokenUtil.getUserNameFromToken(jwtToken);
			return userService.findUserByUserName(userName);
		}
		
		@PutMapping(value = "/affecterUserADonation/{id}") 
		public void affecterUserADonation(HttpServletRequest httpServletRequest, @PathVariable("id")int jackpotId) {
			
            String requestToken = httpServletRequest.getHeader("Authorization");
			String userName = null;
			String jwtToken = null;
			jwtToken = requestToken.substring(7);
			userName = this.jwtTokenUtil.getUserNameFromToken(jwtToken);
			userService.findUserByUserName(userName);
			
			userService.affecterUserADonation(userName, jackpotId);
		}
		
		@PutMapping(value = "/desaffecterUserDuDonation/{id}") 
		public void desaffecterUserDuDonation(HttpServletRequest httpServletRequest, @PathVariable("id")int jackpotId) {
			
			String requestToken = httpServletRequest.getHeader("Authorization");
			String userName = null;
			String jwtToken = null;
			jwtToken = requestToken.substring(7);
			userName = this.jwtTokenUtil.getUserNameFromToken(jwtToken);
			userService.findUserByUserName(userName);
			
			userService.desaffecterUserDuDonation(userName, jackpotId);
		}

		
	}
	
	class UserForm{
	    private String username;
	    private String password;
	    private String confirmedPassword;
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirmedPassword() {
			return confirmedPassword;
		}
		public void setConfirmedPassword(String confirmedPassword) {
			this.confirmedPassword = confirmedPassword;
		}
		
	    
	    
	}
	class UserLogin{
	    private String username;
	    private String password;
	   
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
	
		
}

