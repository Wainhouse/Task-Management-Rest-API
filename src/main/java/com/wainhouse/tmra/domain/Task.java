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
	private Status status;
}
