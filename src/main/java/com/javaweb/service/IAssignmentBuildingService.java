package com.javaweb.service;

import com.javaweb.model.dto.AssignmentBuildingDTO;

public interface IAssignmentBuildingService {
    public void deleteByBuildings(Long[] ids);
    public void addAssignmentBuildingEntity(AssignmentBuildingDTO assignmentBuildingDTO);
}
