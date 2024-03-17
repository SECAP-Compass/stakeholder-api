package com.SECAPCompass.stakeholderapi.api;

import com.SECAPCompass.stakeholderapi.model.Stakeholder;
import com.SECAPCompass.stakeholderapi.service.StakeholderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/stakeholder")
@RestController
public class StakeholderController {

    private final StakeholderService stakeholderService;

    @Autowired
    public StakeholderController(StakeholderService stakeholderService) {
        this.stakeholderService = stakeholderService;
    }

    @PostMapping
    public void addStakeholder(@RequestBody Stakeholder stakeholder){
        stakeholderService.addPerson(stakeholder);
    }

    @GetMapping
    public List<Stakeholder> getAllPeople(){
        return stakeholderService.getAllStakeholders();
    }

    @GetMapping(path = "{id}")
    public Stakeholder getStakeholderByID(@PathVariable("id") UUID id){
        return stakeholderService.getStakeholderByID(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public int deleteStakeholderByID(@PathVariable("id") UUID id){
        return stakeholderService.deleteStakeholderByID(id);
    }

    @PutMapping(path = "{id}")
    public int updateStakeholderByID(@PathVariable("id") UUID id, @RequestBody Stakeholder toUpdate){
        return stakeholderService.updateStakeholderByID(id,toUpdate);
    }
}
