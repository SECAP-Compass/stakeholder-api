package com.SECAPCompass.stakeholderapi.service;

import com.SECAPCompass.stakeholderapi.dao.StakeholderDao;
import com.SECAPCompass.stakeholderapi.model.Stakeholder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StakeholderService {

    private final StakeholderDao stakeholderDao;

    @Autowired
    public StakeholderService(@Qualifier("STAKEHOLDER") StakeholderDao stakeholderDao) {
        this.stakeholderDao = stakeholderDao;
    }

    public int addPerson(Stakeholder stakeholder){
        return stakeholderDao.insertStakeholder(stakeholder);
    }

    public List<Stakeholder> getAllStakeholders(){
        return stakeholderDao.selectAllStakeholders();
    }

    public Optional<Stakeholder> getStakeholderByID(UUID id){
        return stakeholderDao.selectPersonByID(id);
    }

    public int deleteStakeholderByID(UUID id){
        return stakeholderDao.deleteStakeholderByID(id);
    }

    public int updateStakeholderByID(UUID id,Stakeholder stakeholder){
        return stakeholderDao.updateStakeholderByID(id,stakeholder);
    }
}
