package com.deskAllocationSystem.desk.controller;

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

import com.deskAllocationSystem.desk.service.DeskService;
import com.deskAllocationSystem.desk.vo.DeskVo;
import com.deskAllocationSystem.desk.vo.ResponseVo;

@RestController
public class Controller {

	@Autowired
	private DeskService deskService;
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/desk")
	public ResponseEntity<Object> saveDesk(@RequestBody DeskVo deskVo){
		DeskVo desk;
		
		log.info("Desk-SERVICE: controller : saveDesk() method call ");
		desk = deskService.saveDesk(deskVo);
		log.info(StringUtils.join("Desk-SERVICE : controller : saveDesk() method Response : ", desk));
		return new ResponseEntity<>(new ResponseVo(200,"Desk infomation saved successfully",desk),HttpStatus.OK);
	}
	
	@GetMapping("/desks")
	public ResponseEntity<Object> getAllDesks()
	{
		List<DeskVo> deskVos;
		log.info("Desk-SERVICE: controller : getAllDesks() method call ");
		deskVos = deskService.getAllDesks();
		log.info(StringUtils.join("Desk-SERVICE : controller : getAllDesks() method Response : ", deskVos));
		return new ResponseEntity<>(new ResponseVo(302,"Result found",deskVos),HttpStatus.FOUND);
	}
	
	@GetMapping("/desk/{id}")
	public ResponseEntity<Object> getDeskById(@PathVariable("id") long id)
	{
		DeskVo desk;
		log.info("Desk-SERVICE: controller : getDeskById() method call ");
		desk = deskService.getDeskById(id);
		log.info(StringUtils.join("Desk-SERVICE : controller : getDeskById() method Response : ",desk));
		return new ResponseEntity<>(new ResponseVo(302,"found",desk),HttpStatus.FOUND);
	}
	
	@GetMapping("/deskFeing/{id}")
	public DeskVo getDeskByIdFeing(@PathVariable("id") long id)
	{
		DeskVo desk;
		log.info("Desk-SERVICE: controller : getDeskById() method call ");
		desk = deskService.getDeskById(id);
		log.info(StringUtils.join("Desk-SERVICE : controller : getDeskById() method Response : ",desk));
		return desk;
	}
	
	@DeleteMapping("/desk/{id}")
	public ResponseEntity<Object> deleteDeskById(@PathVariable("id") long id)
	{
		log.info("Desk-SERVICE: controller : deleteDeskById() method call ");
		deskService.deleteDeskById(id);
		log.info(StringUtils.join("Desk-SERVICE : controller : deleteDeskById() method Response : "));
		return new ResponseEntity<>(new ResponseVo(200,"Desk deleted successfully",""),HttpStatus.OK);
		
	}
	
	@PutMapping("/desk/{id}")
	public ResponseEntity<Object> updateDeskById(@PathVariable("id") long id,@RequestBody DeskVo desk)
	{
		DeskVo result;
		log.info("Desk-SERVICE: controller : updateDeskById() method call ");
		result = deskService.updateDeskById(id, desk);
		log.info(StringUtils.join("Desk-SERVICE : controller : updateDeskById() method Response : ",result));
		return new ResponseEntity<>(new ResponseVo(200,"Desk updated successfully",result),HttpStatus.OK);
	}
}
