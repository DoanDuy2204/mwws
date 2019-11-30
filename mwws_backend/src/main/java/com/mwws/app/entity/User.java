package com.mwws.app.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="users")
@JsonIgnoreProperties("inforUser")
public class User {
	
	@GeneratedValue
	@Id
	@Column(name="USER_ID")
	private int USER_ID;
	
	@Column(name="USERNAME")
	private String USERNAME;
	
	@Column(name="USER_EMAIL")
	private String USER_EMAIL;
	
	@Column(name="PASSWORD")
	private String PASSWORD;
	
	@Transient
	private String token;
	
	@OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name="INFOR_ID")
	private Infor_User inforUser;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="ROLE_ID")
	private Role role;

	public User() {}

	public User(int uSER_ID, String uSERNAME, String uSER_EMAIL, String pASSWORD, Infor_User inforUser, Role role) {
		super();
		USER_ID = uSER_ID;
		USERNAME = uSERNAME;
		USER_EMAIL = uSER_EMAIL;
		PASSWORD = pASSWORD;
		this.inforUser = inforUser;
		this.role = role;
	}

	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getUSER_EMAIL() {
		return USER_EMAIL;
	}

	public void setUSER_EMAIL(String uSER_EMAIL) {
		USER_EMAIL = uSER_EMAIL;
	}

	public String getPASSWORD() {
		return PASSWORD;
	}

	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}

	public Infor_User getInforUser() {
		return inforUser;
	}

	public void setInforUser(Infor_User inforUser) {
		this.inforUser = inforUser;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
