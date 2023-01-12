package com.deskAllocationSystem.deskAllocation.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {

	private Long Id;
	private String username;
	private String email;
	private String password;
	private Long roleId;
	private long deskId;
}
