package com.deskAllocationSystem.deskAllocation.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeskAllocationVo {

	private long id;
	private long userId;
	private long deskId;
}
