package com.DeskAllocationSystem.floor.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DeskAllocationSystem.floor.entity.FloorEntity;
import com.DeskAllocationSystem.floor.repository.FloorRepository;
import com.DeskAllocationSystem.floor.service.FloorService;
import com.DeskAllocationSystem.floor.utils.FloorUtils;
import com.DeskAllocationSystem.floor.vo.FloorVo;

@Service
public class FloorServiceImpl implements FloorService {

	@Autowired
	private FloorUtils floorUtils;
	@Autowired
	private FloorRepository floorRepository;

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Override
	public List<FloorVo> getAllFloors() {
		log.info("FLOOR SERVICE : Service Impl class : getAllFloors() method call");
		List<FloorEntity> floors = floorRepository.findAll();
		log.info("FLOOR SERVICE : Service Impl class : getAllFloors() method returning response");
		return floorUtils.convertListOfFloorEntityToFloorVo(floors);
	}

	@Override
	public FloorVo getFloorById(long id) {
		log.info("FLOOR SERVICE : Service Impl class : getFloorById() method call");
		FloorEntity floorEntity = floorRepository.findById(id).get();
		log.info("FLOOR SERVICE : Service Impl class : getFloorById() method returning response");
		return floorUtils.convertFloorEntityToFloorVo(floorEntity);

	}

	@Override
	public FloorVo saveFloor1(FloorVo floorVo) {
		log.info("FLOOR SERVICE : Service Impl class : saveFloor1() method call");
		floorVo.setCreationDate(floorUtils.getCurrentDate());
		FloorEntity floor = floorUtils.convertFloorVoToFloorEntity(floorVo);
		FloorEntity result = floorRepository.save(floor);
		log.info("FLOOR SERVICE : Service Impl class : saveFloor1() method returning response");
		return floorUtils.convertFloorEntityToFloorVo(result);
	}

	@Override
	public void deleteFloorById(long id) {
		log.info("FLOOR SERVICE : Service Impl class : deleteFloorById() method call");
		floorRepository.deleteById(id);
		log.info("FLOOR SERVICE : Service Impl class : deleteFloorById() method returning response");
	}

	@Override
	public FloorVo updateFloorById(long id, FloorVo floorVo) {
		log.info("FLOOR SERVICE : Service Impl class : updateFloorById() method call");
		FloorEntity existingFloor = floorUtils.convertFloorVoToFloorEntity(this.getFloorById(id));
		existingFloor.setFloorName(floorVo.getFloorName());
		FloorEntity updatedFloor = floorRepository.save(existingFloor);
		log.info("FLOOR SERVICE : Service Impl class : updateFloorById() method returning response");
		return floorUtils.convertFloorEntityToFloorVo(updatedFloor);
	}

}
