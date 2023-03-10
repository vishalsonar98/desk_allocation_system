package com.deskAllocationSystem.desk.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;

import com.deskAllocationSystem.desk.entity.FloorEntity;
import com.deskAllocationSystem.desk.vo.FloorVo;

@Configuration
public class FloorUtils {

	private DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	private ModelMapper mapper = new ModelMapper();

	public FloorEntity convertFloorVoToFloorEntity(FloorVo floorVo) {
		
		
		return mapper.map(floorVo, FloorEntity.class);
	}

	public String getCurrentDate() {
		Date date = new Date();
		return dateFormatter.format(date);
	}
	
	
	public List<FloorVo> convertListOfFloorEntityToFloorVo(List<FloorEntity> floors) {
		List<FloorVo> floorsvo = new ArrayList<>();
		floors.forEach(e->{
			floorsvo.add(mapper.map(e, FloorVo.class));
		});
		return floorsvo;
	}

	public FloorVo convertFloorEntityToFloorVo(FloorEntity result) {
		
		return mapper.map(result, FloorVo.class);
	}
}
