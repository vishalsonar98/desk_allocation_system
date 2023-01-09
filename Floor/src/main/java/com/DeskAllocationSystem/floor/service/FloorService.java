package com.DeskAllocationSystem.floor.service;

import java.util.List;

import com.DeskAllocationSystem.floor.vo.FloorVo;

public interface FloorService {

	public List<FloorVo> getAllFloors();
	public FloorVo getFloorById(long id);
	public FloorVo saveFloor1(FloorVo floorVo);
	public void deleteFloorById(long id);
	public FloorVo updateFloorById(long id,FloorVo floorVo);
}
