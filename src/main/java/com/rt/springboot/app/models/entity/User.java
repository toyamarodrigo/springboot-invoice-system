package com.rt.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "users")
public class User implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 30)
	private String username;

	@Column(length = 60)
	private String password;
	
	@Transient
	private String confirmPassword;

	private Boolean enabled;

	private static final long serialVersionUID = -4639312987403040257L;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private java.util.List<Role> authorities;

	/*----- Getters & Setters -----*/
	public Long getId() { return id; }
	
	public void setId(Long id) { this.id = id; }
	
	public String getUsername() {  return username; }
	
	public void setUsername(String username) { this.username = username; }
	
	public String getPassword() { return password; }
	
	public void setPassword(String password) { this.password = password; }
	
	public String getConfirmPassword() { return confirmPassword; }

	public void setConfirmPassword(String confirmPassword) { this.confirmPassword = confirmPassword; }

	public Boolean getEnabled() { return enabled; }
	
	public void setEnabled(Boolean enabled) { this.enabled = enabled; }
	
	public java.util.List<Role> getAuthorities() { return authorities; }
	
	public void setAuthorities(java.util.List<Role> authorities) { this.authorities = authorities; }
}
