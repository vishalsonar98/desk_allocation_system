package com.deskAllocationSystem.deskAllocation.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deskAllocationSystem.deskAllocation.entity.DeskAllocationEntity;

@Repository
public interface DeskAllocationRepository extends JpaRepository<DeskAllocationEntity, Long>{

}
