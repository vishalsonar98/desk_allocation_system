package com.deskAllocationSystem.deskAllocation.service;

import com.deskAllocationSystem.deskAllocation.exception.DeskAlreadyTakenException;
import com.deskAllocationSystem.deskAllocation.vo.DeskAllocationVo;

public interface DeskAllocationService {

	public DeskAllocationVo allocateDesk(long userId,long deskId)  throws DeskAlreadyTakenException;
}
