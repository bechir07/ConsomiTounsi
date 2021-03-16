package tn.esprit.spring.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;



import tn.esprit.spring.Service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	@Qualifier("UserDetailsService")
	private UserServiceImpl userDetailsService;
	
	@Autowired
	private JWTTokenAuthorizationFilter jwtTokenAuthorizationFilter;
	
	@Bean
	public PasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	private static final String[] PUBLIC_URLS = {"/login"};
	
	@Autowired
	public void globalConfig(AuthenticationManagerBuilder auth)throws Exception{
		/*auth.inMemoryAuthentication()
		.withUser("bechir")
		.password("{noop}123")
		.roles("ADMIN")
		.and()
		.withUser("nadia")
		.password("{noop}456")
		.roles("PARENT");*/
		auth.userDetailsService(this.userDetailsService).passwordEncoder(this.bCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();
		/*http.httpBasic()
		.and().authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable()
		.formLogin().disable();*/
		
		//http.csrf().disable().cors().and()
		//.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
		//.authorizeRequests().antMatchers("/login/**","/register/**").permitAll()
		//.anyRequest().authenticated();
		//.and().addFilterBefore(this.jwtTokenAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
		http.csrf().disable();
		http.authorizeRequests().antMatchers("/login").authenticated().anyRequest().permitAll();
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}

