package com.mwws.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role {

	@GeneratedValue
	@Id
	@Column(name = "ROLE_ID", nullable = true, length = 1600)
	private int ROLE_ID;

	@Column(name = "ROLE_NAME", nullable = true, length = 1600)
	private String ROLE_NAME;

	@Column(name = "ROLE_DESCRIPTION",nullable = false )
	private String ROLE_DESCRIPTION;

	public Role(int rOLE_ID, String rOLE_NAME, String rOLE_DESCRIPTION) {
		super();
		ROLE_ID = rOLE_ID;
		ROLE_NAME = rOLE_NAME;
		ROLE_DESCRIPTION = rOLE_DESCRIPTION;
	}

	public Role() {}

	public int getROLE_ID() {
		return ROLE_ID;
	}

	public void setROLE_ID(int rOLE_ID) {
		ROLE_ID = rOLE_ID;
	}

	public String getROLE_NAME() {
		return ROLE_NAME;
	}

	public void setROLE_NAME(String rOLE_NAME) {
		ROLE_NAME = rOLE_NAME;
	}

	public String getROLE_DESCRIPTION() {
		return ROLE_DESCRIPTION;
	}

	public void setROLE_DESCRIPTION(String rOLE_DESCRIPTION) {
		ROLE_DESCRIPTION = rOLE_DESCRIPTION;
	}
}
