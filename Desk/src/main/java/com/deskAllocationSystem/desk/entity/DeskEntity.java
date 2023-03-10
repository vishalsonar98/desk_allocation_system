package com.deskAllocationSystem.desk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="desk")
public class DeskEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotBlank
	@Column(name = "system_configuration")
	private String sytemConfig;
	
	@NotBlank
	@Column(name = "extra_accessories")
	private String extraAccessories;
	
	@Column(name="creation_date")
	private String creationDate;
	
	@Column(name = "zone")
	private String zone;
	
	@NotNull
	@ManyToOne
	private FloorEntity floor;
}
