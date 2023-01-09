package com.deskAllocationSystem.deskAllocation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import brave.sampler.Sampler;

@Component
public class DeskAllocationConfig {

	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
