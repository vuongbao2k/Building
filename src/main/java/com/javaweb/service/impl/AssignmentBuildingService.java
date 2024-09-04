package com.javaweb.service.impl;

import com.javaweb.entity.AssignBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.repository.AssignmentBuildingRepository;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IAssignmentBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentBuildingService implements IAssignmentBuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private AssignmentBuildingRepository assignmentBuildingRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void deleteByBuildings(Long[] ids) {
//        for(Long id : ids) {
//            BuildingEntity buildingEntity = buildingRepository.findById(id).get();
//            assignmentBuildingRepository.deleteByBuildingEntity(buildingEntity);
//        }
        assignmentBuildingRepository.deleteByBuildingEntityIdIn(ids);
    }

    @Override
    public void addAssignmentBuildingEntity(AssignmentBuildingDTO assignmentBuildingDTO) {
        BuildingEntity buildingEntity = buildingRepository.findById(assignmentBuildingDTO.getBuildingId()).get();
        assignmentBuildingRepository.deleteByBuildingEntity(buildingEntity);

        List<Long> staffIds = assignmentBuildingDTO.getStaffs();
        for(Long staffId : staffIds){
            AssignBuildingEntity assignBuildingEntity = new AssignBuildingEntity();
            assignBuildingEntity.setBuildingEntity(buildingEntity);
            UserEntity userEntity = userRepository.findById(staffId).get();
            assignBuildingEntity.setUserEntity(userEntity);
            assignmentBuildingRepository.save(assignBuildingEntity);
        }
    }
}
