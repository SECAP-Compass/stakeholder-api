package com.SECAPCompass.stakeholderapi.controller;

import com.SECAPCompass.stakeholderapi.dto.createStakeholder.CreateStakeholderRequest;
import com.SECAPCompass.stakeholderapi.dto.createStakeholder.CreateStakeholderResponse;
import com.SECAPCompass.stakeholderapi.dto.getStakeholder.GetStakeholderResponse;
import com.SECAPCompass.stakeholderapi.dto.updateStakeholder.UpdateStakeholderRequest;
import com.SECAPCompass.stakeholderapi.dto.updateStakeholder.UpdateStakeholderResponse;
import com.SECAPCompass.stakeholderapi.service.StakeholderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/stakeholder")
public class StakeholderController {
    private final StakeholderService stakeholderService;

    public StakeholderController(StakeholderService stakeholderService) {
        this.stakeholderService = stakeholderService;
    }

    @PostMapping
    ResponseEntity<CreateStakeholderResponse> createStakeholder(@RequestBody CreateStakeholderRequest createStakeholderRequest){
        var stakeholder = stakeholderService.addStakeholder(createStakeholderRequest);
        return new ResponseEntity<>(
                new CreateStakeholderResponse(stakeholder.getUserName(),stakeholder.geteMail()),
                HttpStatus.CREATED);
    }

    @PutMapping("/update/{stakeholderId}")
    ResponseEntity<UUID> updateStakeholder(@RequestBody UpdateStakeholderRequest updateStakeholderRequest,
                                                                @PathVariable UUID stakeholderId){
        var stakeholder = stakeholderService.getStakeholderById(stakeholderId);
        stakeholder = stakeholderService.updateStakeholder(updateStakeholderRequest,stakeholder);
        return new ResponseEntity<>(stakeholder.getId(),HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    GetStakeholderResponse getStakeholderById(@PathVariable UUID id){
        var stakeholder = stakeholderService.getStakeholderById(id);
        return new GetStakeholderResponse();
    }

    @GetMapping("/userName/{userName}")
    GetStakeholderResponse getStakeholderByUserName(@PathVariable String userName){
        var stakeholder = stakeholderService.getStakeholderByUserName(userName);
        return new GetStakeholderResponse();
    }
}
