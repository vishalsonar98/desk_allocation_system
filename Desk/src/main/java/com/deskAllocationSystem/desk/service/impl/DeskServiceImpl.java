package com.deskAllocationSystem.desk.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deskAllocationSystem.desk.consumer.FloorConsumer;
import com.deskAllocationSystem.desk.entity.DeskEntity;
import com.deskAllocationSystem.desk.entity.FloorEntity;
import com.deskAllocationSystem.desk.repository.DeskRepository;
import com.deskAllocationSystem.desk.service.DeskService;
import com.deskAllocationSystem.desk.util.DeskUtil;
import com.deskAllocationSystem.desk.util.FloorUtils;
import com.deskAllocationSystem.desk.vo.DeskVo;
import com.deskAllocationSystem.desk.vo.FloorVo;

@Service
public class DeskServiceImpl implements DeskService {

	@Autowired
	private DeskRepository deskRepository;
	@Autowired
	private DeskUtil deskUtil;
	@Autowired
	private FloorConsumer floorConsumer;
	@Autowired
	private FloorUtils floorUtils;
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public DeskVo saveDesk(DeskVo desk) {
		DeskEntity deskEntity;
		DeskEntity result;
		FloorVo floor;
		FloorEntity floorEntity;
		
		log.info("Desk SERVICE : Service Impl class : saveDesk() method call");
		
		floor = floorConsumer.getFloorByIdFeign(desk.getFloor().getId());
		floorEntity = floorUtils.convertFloorVoToFloorEntity(floor);
		
		deskEntity = deskUtil.convertDeskVoToDeskEntity(desk);
		deskEntity.setCreationDate(deskUtil.getCurrentDate());
		deskEntity.setFloor(floorEntity);
		
		result = deskRepository.save(deskEntity);
		log.info("Desk SERVICE : Service Impl class : saveDesk() method returning response");
		return deskUtil.convertDeskEntityToDeskVo(result);
	}

	@Override
	public DeskVo getDeskById(long id) {
		DeskEntity desk;
		
		log.info("Desk SERVICE : Service Impl class : getDeskById() method call");
		desk = deskRepository.findById(id).get();
		log.info("Desk SERVICE : Service Impl class : getDeskById() method returning response");
		return deskUtil.convertDeskEntityToDeskVo(desk);
	}

	@Override
	public DeskVo updateDeskById(long id, DeskVo desk) {
		DeskEntity existingDesk;
		DeskVo result;
		FloorVo floor;
		FloorEntity floorEntity;
		
		log.info("Desk SERVICE : Service Impl class : updateDeskById() method call");
		existingDesk = deskRepository.findById(id).get();
		existingDesk.setExtraAccessories(desk.getExtraAccessories());
		existingDesk.setSytemConfig(desk.getSytemConfig());
		existingDesk.setZone(desk.getZone());
		
		floor = floorConsumer.getFloorByIdFeign(desk.getFloor().getId());
		floorEntity = floorUtils.convertFloorVoToFloorEntity(floor);
		
		existingDesk.setFloor(floorEntity);
		
		result = this.saveDesk(deskUtil.convertDeskEntityToDeskVo(existingDesk));
		log.info("Desk SERVICE : Service Impl class : updateDeskById() method returning response");
		return result;
	}

	@Override
	public void deleteDeskById(long id) {
		
		log.info("Desk SERVICE : Service Impl class : deleteDeskById() method call");
		deskRepository.deleteById(id);
		log.info("Desk SERVICE : Service Impl class : deleteDeskById() method executed successfully");
		
	}

	@Override
	public List<DeskVo> getAllDesks() {
		List<DeskEntity> desks;
		log.info("Desk SERVICE : Service Impl class : getAllDesks() method call");
		desks = deskRepository.findAll();
		log.info("Desk SERVICE : Service Impl class : getAllDesks() method returning response");
		return deskUtil.convertListOfDeskEntityToDeskVo(desks);
	}

}
