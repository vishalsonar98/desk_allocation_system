package com.DeskAllocationSystem.floor.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.DeskAllocationSystem.floor.service.FloorService;
import com.DeskAllocationSystem.floor.vo.FloorVo;
import com.DeskAllocationSystem.floor.vo.ResponseVo;

@RestController
public class Controller {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FloorService floorService;

	@PostMapping("/floor")
	public ResponseEntity<Object> saveFloor(@RequestBody FloorVo floorVo) {
		log.info("FLOOR-SERVICE: controller : saveFloor() method call ");
		FloorVo floor = floorService.saveFloor1(floorVo);
		log.info(StringUtils.join("FLOOR SERVICE : controller : saveFloor() method Response : ", floor));
		return new ResponseEntity<>(new ResponseVo(200, "Floor Created Successfully", floor),
				HttpStatus.OK);

	}

	@GetMapping("/floors")
	public ResponseEntity<Object> getAllFloors() {
		log.info("FLOOR-SERVICE: controller : getAllFloors() method call ");
		List<FloorVo> floors = floorService.getAllFloors();
		log.info(StringUtils.join("FLOOR SERVICE : controller : getAllFloors() method Response : ", floors));
		return new ResponseEntity<>(new ResponseVo(200, "Ok", floors), HttpStatus.OK);

	}

	@GetMapping("/floor/{id}")
	public ResponseEntity<Object> getFloorById(@PathVariable("id") Long id) {
		log.info("FLOOR-SERVICE: controller : getFloorById() method call ");
		FloorVo floor = floorService.getFloorById(id);
		log.info(StringUtils.join("FLOOR SERVICE :  controller : getFloorById() method Response : ", floor));
		return new ResponseEntity<>(new ResponseVo(302, "found", floor), HttpStatus.FOUND);
	}
	
	@GetMapping("/floorById/{id}")
	public FloorVo getFloorByIdFeign(@PathVariable("id") long id) {
		log.info("FLOOR-SERVICE: controller : getFloorByIdFeign() method call ");
		FloorVo floor = floorService.getFloorById(id);
		log.info(StringUtils.join("FLOOR SERVICE :  controller : getFloorByIdFeign() method Response : ", floor));
		return floor;
	}

	@DeleteMapping("/floor/{id}")
	public ResponseEntity<Object> deleteFloorById(@PathVariable("id") long id) {
		log.info("FLOOR-SERVICE: controller : deleteFloorById() method call ");
		floorService.deleteFloorById(id);
		log.info(StringUtils.join("FLOOR SERVICE : controller : deleteFloorById() method excuted successfully "));
		return new ResponseEntity<>(new ResponseVo(200, "Floor Deleted Successfully", ""), HttpStatus.OK);
	}

	@PutMapping("/floor/{id}")
	public ResponseEntity<Object> updateFloorById(@PathVariable("id") long id, @RequestBody FloorVo floorVo) {
		log.info("FLOOR-SERVICE: controller : updateFloorById() method call ");
		FloorVo floor = floorService.updateFloorById(id, floorVo);
		log.info(StringUtils.join("FLOOR SERVICE : controller : updateFloorById() method response : ", floor));
		return new ResponseEntity<>(new ResponseVo(200, "Object updated successfully", floor), HttpStatus.OK);
	}

}
