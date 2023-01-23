package com.deskAllocationSystem.deskAllocation.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deskAllocationSystem.deskAllocation.consumer.DeskConsumer;
import com.deskAllocationSystem.deskAllocation.consumer.UserConsumer;
import com.deskAllocationSystem.deskAllocation.exception.DeskAlreadyTakenException;
import com.deskAllocationSystem.deskAllocation.service.DeskAllocationService;
import com.deskAllocationSystem.deskAllocation.vo.DeskAllocationVo;
import com.deskAllocationSystem.deskAllocation.vo.UserVo;

@Service
public class DeskAllocationServiceImpl implements DeskAllocationService {

	@Autowired
	private DeskConsumer deskConsumer;
	@Autowired
	private UserConsumer userConsumer;
	
	@Override
	public DeskAllocationVo allocateDesk(long userId, long deskId) throws DeskAlreadyTakenException {
		
		userConsumer.getUser(userId).getBody();
		deskConsumer.getDeskByIdFeing(deskId);
		Optional<UserVo> uservo= userConsumer.allocateDeskToUser(userId, deskId);
		if (uservo.equals(Optional.empty())) {
			throw new DeskAlreadyTakenException("Desk with given id is already taken by the another user");
		}
		DeskAllocationVo allocationVo = new DeskAllocationVo();
		allocationVo.setDeskId(deskId);
		allocationVo.setUserId(userId);
		return allocationVo;
	}

}
