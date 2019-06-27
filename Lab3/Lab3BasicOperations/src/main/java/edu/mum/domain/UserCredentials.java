package edu.mum.domain;

import javax.persistence.*;


@Entity(name = "Authentication")
public class UserCredentials {

    @Id
	@Column(name = "USER")
    String username;

	@Column(name = "PASSWORD", nullable = false)
    String password;
    
    @Transient
    String verifyPassword;
	Boolean enabled;

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
	public String getVerifyPassword() {
		return verifyPassword;
	}
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
 	
}
