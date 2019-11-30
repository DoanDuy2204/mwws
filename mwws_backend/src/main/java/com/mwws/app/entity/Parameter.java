package com.mwws.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="parameter")
public class Parameter {

	@Id
	@GeneratedValue
	@Column(name="PARAM_ID")
	private int id;
	@Column(name="PARAM_NAME")
	private String name;
	@Column(name="PARAM_VALUE")
	private String value;
	@Column(name="PARAM_STATUS")
	private int status;
	public Parameter(int id, String name, String value, int status) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.status = status;
	}
	public Parameter() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
