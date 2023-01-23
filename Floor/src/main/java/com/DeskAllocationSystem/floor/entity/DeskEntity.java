package com.DeskAllocationSystem.floor.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "desk")
public class DeskEntity {

	@Id
	private long id;

	@NotBlank
	@Column(name = "system_configuration")
	private String sytemConfig;

	@NotBlank
	@Column(name = "extra_accessories")
	private String extraAccessories;

	@Column(name = "creation_date")
	private String creationDesk;

	@Column(name = "zone")
	private String zone;


	@ManyToOne
	private FloorEntity floor;
}
