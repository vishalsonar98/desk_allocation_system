package com.deskAllocationSystem.desk.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.deskAllocationSystem.desk.entity.DeskEntity;
import com.deskAllocationSystem.desk.vo.DeskVo;

@Component
public class DeskUtil {

	private DateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
	private ModelMapper mapper = new ModelMapper();

	public DeskEntity convertDeskVoToDeskEntity(DeskVo deskVo) {
		
		
		return mapper.map(deskVo, DeskEntity.class);
	}

	public String getCurrentDate() {
		Date date = new Date();
		return dateFormatter.format(date);
	}
	
	
	public List<DeskVo> convertListOfDeskEntityToDeskVo(List<DeskEntity> desks) {
		List<DeskVo> Deskvo = new ArrayList<>();
		desks.forEach(e->{
			Deskvo.add(mapper.map(e, DeskVo.class));
		});
		return Deskvo;
	}

	public DeskVo convertDeskEntityToDeskVo(DeskEntity result) {
		
		return mapper.map(result, DeskVo.class);
	}
}
