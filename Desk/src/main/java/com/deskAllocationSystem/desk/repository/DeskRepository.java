package com.deskAllocationSystem.desk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.deskAllocationSystem.desk.entity.DeskEntity;

@Repository
public interface DeskRepository extends JpaRepository<DeskEntity, Long>{

}
