package com.DeskAllocationSystem.floor.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FloorVo {

	private long id;
	private String floorName;
	private String creationDate;
}
