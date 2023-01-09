package com.deskAllocationSystem.desk.service;

import java.util.List;

import com.deskAllocationSystem.desk.vo.DeskVo;

public interface DeskService {

	public DeskVo saveDesk(DeskVo desk);
	public DeskVo getDeskById(long id);
	public DeskVo updateDeskById(long id,DeskVo desk);
	public void deleteDeskById(long id);
	public List<DeskVo> getAllDesks();
}
