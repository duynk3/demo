package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="employee")
public class EmployeeEntity  extends BaseEntity implements java.io.Serializable {
	
	private static final long serialVersionUID = -5219656776670438623L;
	
	@Column(name="name")
	private String name; 
	
	@Column(name="position")
	private String position; 
	
	@Column(name="created_date")
	private String created_date; 
	
	@Column(name="modified_date")
	private String modified_date; 
	
	@Column(name="created_by")
	private String created_by;

	@Column(name="last_modified_by")
	private String last_modified_by;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCreated_date() {
		return created_date;
	}

	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}

	public String getModified_date() {
		return modified_date;
	}

	public void setModified_date(String modified_date) {
		this.modified_date = modified_date;
	}

	public String getCreated_by() {
		return created_by;
	}

	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}

	public String getLast_modified_by() {
		return last_modified_by;
	}

	public void setLast_modified_by(String last_modified_by) {
		this.last_modified_by = last_modified_by;
	}
	
	
	
	
	
}
