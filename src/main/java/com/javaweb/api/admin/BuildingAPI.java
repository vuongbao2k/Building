package com.javaweb.api.admin;

import com.javaweb.model.dto.AssignmentBuildingDTO;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.IAssignmentBuildingService;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.impl.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Transactional
@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {
    @Autowired
    private IBuildingService buildingService;
    @Autowired
    private IAssignmentBuildingService assignmentBuildingService;

    @PostMapping
    public void addOrUpdateBuilding(@RequestBody BuildingDTO buildingDTO) {
        BuildingDTO building = buildingService.addOrUpdateBuilding(buildingDTO);
    }

    @DeleteMapping("/{ids}")
    public void deleteBuilding(@PathVariable Long[] ids) {
        buildingService.deleteBuildings(ids);
    }

    @GetMapping("/{id}/staff")
    public ResponseDTO loafStaff(@PathVariable Long id){
        ResponseDTO result = buildingService.listStaff(id);
        return result;
    }

    @PostMapping("/assignment")
    public void updateAssignmentBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
        assignmentBuildingService.addAssignmentBuildingEntity(assignmentBuildingDTO);
    }
}
