package com.DeskAllocationSystem.floor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.DeskAllocationSystem.floor.entity.FloorEntity;

@Repository
public interface FloorRepository extends JpaRepository<FloorEntity, Long> {

}
