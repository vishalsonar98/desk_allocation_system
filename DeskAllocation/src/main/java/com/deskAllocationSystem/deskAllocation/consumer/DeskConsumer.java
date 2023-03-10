package com.deskAllocationSystem.deskAllocation.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deskAllocationSystem.deskAllocation.vo.DeskVo;


@FeignClient("DESK-SERVICE")
public interface DeskConsumer {

	@GetMapping("/deskFeing/{id}")
	public DeskVo getDeskByIdFeing(@PathVariable("id") long id);
}
