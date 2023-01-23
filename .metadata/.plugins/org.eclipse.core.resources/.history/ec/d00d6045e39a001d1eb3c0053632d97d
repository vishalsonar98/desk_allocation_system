package com.deskAllocationSystem.deskAllocation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.deskAllocationSystem.deskAllocation.consumer.DeskConsumer;
import com.deskAllocationSystem.deskAllocation.consumer.UserConsumer;
import com.deskAllocationSystem.deskAllocation.service.DeskAllocationService;
import com.deskAllocationSystem.deskAllocation.vo.DeskAllocationVo;
import com.deskAllocationSystem.deskAllocation.vo.DeskVo;
import com.deskAllocationSystem.deskAllocation.vo.ResponseVo;
import com.deskAllocationSystem.deskAllocation.vo.UserVo;

@RestController
public class Controller {

	@Autowired
	private DeskAllocationService deskAllocationService;
	
	

	
	@PutMapping("/deskallocation/{deskId}/{userId}")
	public ResponseEntity<ResponseVo> allocateDesk(@PathVariable("deskId") long deskId,@PathVariable("userId") long userId)
	{
		DeskAllocationVo deskAllocationVo = deskAllocationService.allocateDesk(userId, deskId);
		
		return new ResponseEntity<ResponseVo>(new ResponseVo(200,"Data saved successfully",deskAllocationVo),HttpStatus.OK);
	}
}
