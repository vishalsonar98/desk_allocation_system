package com.deskAllocationSystem.deskAllocation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.deskAllocationSystem.deskAllocation.consumer.DeskConsumer;
import com.deskAllocationSystem.deskAllocation.service.DeskAllocationService;
import com.deskAllocationSystem.deskAllocation.vo.DeskVo;

@RestController
public class Controller {

	@Autowired
	private DeskAllocationService deskAllocationService;
	@Autowired
	private DeskConsumer deskConsumer;
	
	@GetMapping("/desk/{id}")
	public DeskVo getDeskById(@PathVariable("id") long id)
	{
		return deskConsumer.getDeskByIdFeing(id);
	}
}
