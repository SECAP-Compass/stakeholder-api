package com.SECAPCompass.stakeholderapi.controller;

import com.SECAPCompass.stakeholderapi.dto.createStakeholder.CreateStakeholderRequest;
import com.SECAPCompass.stakeholderapi.dto.createStakeholder.CreateStakeholderResponse;
import com.SECAPCompass.stakeholderapi.dto.getStakeholder.GetStakeholderResponse;
import com.SECAPCompass.stakeholderapi.service.StakeholderService;
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
    CreateStakeholderResponse createStakeholder(@RequestBody CreateStakeholderRequest createStakeholderRequest){
        var stakeholder = stakeholderService.addStakeholder(createStakeholderRequest);
        return new CreateStakeholderResponse(stakeholder.getUserName(),stakeholder.geteMail());
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
