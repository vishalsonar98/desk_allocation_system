package com.deskAllocationSystem.desk.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseVo {
	private int code;
	private String message;
	private Object result;
}
