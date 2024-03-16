package com.SECAPCompass.stakeholderapi.api;

import com.SECAPCompass.stakeholderapi.model.Stakeholder;
import com.SECAPCompass.stakeholderapi.service.StakeholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StakeholderController {

    private final StakeholderService stakeholderService;

    @Autowired
    public StakeholderController(StakeholderService stakeholderService) {
        this.stakeholderService = stakeholderService;
    }

    @PostMapping
    public void addStakeholder(Stakeholder stakeholder){
        stakeholderService.addPerson(stakeholder);
    }
}
