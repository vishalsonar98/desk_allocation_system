package com.deskAllocationSystem.desk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "floor")
public class FloorEntity {

	@Id
	private long id;
	
	@NotBlank
	@Column(name = "floor_name")
	private String floorName;
	
	@Column(name = "creation_date")
	private String creationDate;
}
