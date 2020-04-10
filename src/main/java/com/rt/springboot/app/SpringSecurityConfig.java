package com.rt.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rt.springboot.app.models.service.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private JpaUserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// Method for http authorization
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**", "/list", "/locale", "/api/**", "/signup").permitAll()
				.anyRequest().authenticated()
				.and()
				.formLogin().loginPage("/login").permitAll()
				.defaultSuccessUrl("/")
				.and()
				.logout().invalidateHttpSession(true).clearAuthentication(true).logoutSuccessUrl("/login?logout").permitAll()
				.and()
				.exceptionHandling().accessDeniedPage("/error_403")
				.and()
				.rememberMe();

	}

	@Autowired
	public void configuredGlobal(AuthenticationManagerBuilder builder) throws Exception {

		// JPA
		
		builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

		
//		 // JDBC
//		 // Spring security jdbc auth builder.jdbcAuthentication()
//		 
//		 .dataSource(dataSource) .passwordEncoder(passwordEncoder)
//		 .usersByUsernameQuery("select username, password, enabled from users where username=?"
//		 )
//		 .authoritiesByUsernameQuery("select u.username, a.authority from authorities a inner join users u on (a.user_id=u.id) where u.username=?"
//		 );
//		 
//
//		
//		 PasswordEncoder encoder = this.passwordEncoder;
//		 
//		 // UserBuilder users = User.withDefaultPasswordEncoder();
//		 
//		 // Manera 1 // UserBuilder users = User.builder().passwordEncoder(password ->
//		 encoder.encode(password));
//		 
//		 // Manera 2 // UserBuilder users =
//		 User.builder().passwordEncoder(encoder::encode);
//		 
//		 // Manera 3 UserBuilder users = User.builder().passwordEncoder(password -> {
//		 return encoder.encode(password); });
//		 
//		 builder.inMemoryAuthentication()
//		 .withUser(users.username("admin").password("12345").roles("ADMIN","USER"))
//		 .withUser(users.username("test").password("12345").roles("USER"));
		 

	}

}
