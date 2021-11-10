package com.wainhouse.tmra.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.wainhouse.tmra.enumeration.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.PrivateKey;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Task { // Creating all the attributes for a task class.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto generate an ID
	private Long id;
	@Column(unique = true) // The same task cannot be added twice
	@NotEmpty(message = "This field cannot be left blank.") // It also cannot be left blank
	private String taskName;
	private String date;
	private String type;
	private String imageUrl;
	private Status status;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
