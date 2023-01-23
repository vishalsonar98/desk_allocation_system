package com.deskAllocationSystem.deskAllocation.consumer;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.deskAllocationSystem.deskAllocation.vo.UserVo;

@FeignClient("USER-SERVICE")
public interface UserConsumer {
	@PostMapping("/users/")
	public ResponseEntity<UserVo> createUser(@Valid @RequestBody UserVo userDto);
	@GetMapping("/users/{userId}")
	public ResponseEntity<UserVo> getUser(@PathVariable Long userId);
	@PutMapping("/users/{userid}/{deskid}")
	public Optional<UserVo> allocateDeskToUser(@PathVariable("userid") long userid,@PathVariable("deskid") long deskid);
}
