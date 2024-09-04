package com.javaweb.repository;

import com.javaweb.entity.AssignBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentBuildingRepository extends JpaRepository<AssignBuildingEntity, Long> {
    void deleteByBuildingEntity(BuildingEntity buildingEntity);
    void deleteByBuildingEntityIdIn(Long[] ids);
}
