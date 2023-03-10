package com.DeskAllocationSystem.floor.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	@Column(name = "floor_name")
	private String floorName;
	
	@Column(name = "creation_date")
	private String creationDate;
	
	@OneToMany(mappedBy = "floor")
	private List<DeskEntity> desks;
}
