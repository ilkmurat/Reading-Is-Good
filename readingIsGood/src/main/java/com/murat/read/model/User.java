package com.murat.read.model;


import java.util.Date;
import java.util.HashSet;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

public class User {

	@Id
	private String userId;

	private String role;

	@Field("uname")
	private String username;

	@Field("pass")
	private String password;

	private String email;

	private Date cdate;

	private Date udate;

	private String cuser;

	private String uuser;

	 public User() {
	  }

	  public User(String username, String email, String password) {
	    this.username = username;
	    this.email = email;
	    this.password = password;
	  }

	public Set<String> getRoles() {
		HashSet<String> roles = new HashSet<String>();
		roles.add(RoleEnum.ROLE_ADMIN.toString());
		roles.add(RoleEnum.ROLE_MODERATOR.toString());
		roles.add(RoleEnum.ROLE_USER.toString());
		return roles;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

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

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public Date getUdate() {
		return udate;
	}

	public void setUdate(Date udate) {
		this.udate = udate;
	}

	public String getCuser() {
		return cuser;
	}

	public void setCuser(String cuser) {
		this.cuser = cuser;
	}

	public String getUuser() {
		return uuser;
	}

	public void setUuser(String uuser) {
		this.uuser = uuser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
