package com.rt.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rt.springboot.app.auth.handler.LoginSuccessHandler;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private LoginSuccessHandler successHandler;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	// Metodo para autorizaciones http
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/list").permitAll()
		//.antMatchers("/view/**").hasAnyRole("USER")
		//.antMatchers("/uploads/**").hasAnyRole("USER")
		//.antMatchers("/form/**").hasAnyRole("ADMIN")
		//.antMatchers("/delete/**").hasAnyRole("ADMIN")
		//.antMatchers("/invoice/**").hasAnyRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin()
			.successHandler(successHandler)
			.loginPage("/login")
		.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403");
		
	}
	
	// Metodo de registro
	// en memoria x ahora
	@Autowired // para poder inyectar
	public void configuredGlobal(AuthenticationManagerBuilder builder) throws Exception {
		
		PasswordEncoder encoder = this.passwordEncoder;
		
		// UserBuilder users = User.withDefaultPasswordEncoder();
		
		// Manera 1
		// UserBuilder users = User.builder().passwordEncoder(password -> encoder.encode(password));
		
		// Manera 2
		// UserBuilder users = User.builder().passwordEncoder(encoder::encode);
		
		// Manera 3
		UserBuilder users = User.builder().passwordEncoder(password -> {
			return encoder.encode(password);
		});
		
		builder.inMemoryAuthentication()
		.withUser(users.username("admin").password("12345").roles("ADMIN","USER"))
		.withUser(users.username("rodri").password("12345").roles("USER"));
		
		
		
	}


	
}
