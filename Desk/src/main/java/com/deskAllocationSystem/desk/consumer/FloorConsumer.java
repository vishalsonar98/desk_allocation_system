package com.deskAllocationSystem.desk.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.deskAllocationSystem.desk.vo.FloorVo;



@FeignClient("FLOOR-SERVICE")
public interface FloorConsumer {

	@GetMapping("/floorById/{id}")
	public FloorVo getFloorByIdFeign(@PathVariable("id") long id);
	@GetMapping("/floors")
	public ResponseEntity<Object> getAllFloors();
}
