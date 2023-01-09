package com.deskAllocationSystem.deskAllocation.consumer;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("USER-SERVICE")
public interface UserConsumer {

}
