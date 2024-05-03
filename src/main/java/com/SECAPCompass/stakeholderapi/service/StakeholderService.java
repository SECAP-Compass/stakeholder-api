package com.SECAPCompass.stakeholderapi.service;

import com.SECAPCompass.stakeholderapi.dto.createStakeholder.CreateStakeholderRequest;
import com.SECAPCompass.stakeholderapi.dto.updateStakeholder.UpdateStakeholderRequest;
import com.SECAPCompass.stakeholderapi.exception.DomainNotFoundException;
import com.SECAPCompass.stakeholderapi.exception.EntityNotFoundException;
import com.SECAPCompass.stakeholderapi.exception.UsernameNotFound;
import com.SECAPCompass.stakeholderapi.model.Stakeholder;
import com.SECAPCompass.stakeholderapi.model.User;
import com.SECAPCompass.stakeholderapi.repository.StakeholderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StakeholderService {

    private final StakeholderRepository stakeholderRepository;

    public StakeholderService(StakeholderRepository stakeholderRepository) {
        this.stakeholderRepository = stakeholderRepository;
    }

    public Stakeholder addStakeholder(CreateStakeholderRequest createStakeholderRequest){
        var stakeholder = new Stakeholder(createStakeholderRequest.userName(),createStakeholderRequest.eMail(),
                createStakeholderRequest.name(), createStakeholderRequest.surname(), createStakeholderRequest.city());

        return stakeholderRepository.save(stakeholder);
    }

    public Stakeholder updateStakeholder(UpdateStakeholderRequest updateStakeholderRequest){
        if(updateStakeholderRequest == null){
            throw new EntityNotFoundException("entity.not-found",UpdateStakeholderRequest.class.getName());
        }
        var stakeholder = stakeholderRepository.findById(updateStakeholderRequest.userId())
                .orElseThrow(() -> new DomainNotFoundException("domain.not-found",updateStakeholderRequest.userId()));
        stakeholder.setCity(updateStakeholderRequest.city());
        stakeholder.setName(updateStakeholderRequest.name());
        stakeholder.setSurname(updateStakeholderRequest.surname());
        return stakeholderRepository.save(stakeholder);
    }

    public Stakeholder getStakeholderById(UUID id){
        return stakeholderRepository.findById(id)
                .orElseThrow(() -> new DomainNotFoundException("domain.not-found",id));
    }

    public Stakeholder getStakeholderByUserName(String userName){
        return stakeholderRepository.findByUserName(userName).orElseThrow(() -> new UsernameNotFound("username.not-found",userName));
    }

}
