package com.SECAPCompass.stakeholderapi.service;

import com.SECAPCompass.stakeholderapi.dao.StakeholderDao;
import com.SECAPCompass.stakeholderapi.model.Stakeholder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StakeholderService {

    private final StakeholderDao stakeholderDao;

    @Autowired
    public StakeholderService(@Qualifier("fakeDao") StakeholderDao stakeholderDao) {
        this.stakeholderDao = stakeholderDao;
    }

    public int addPerson(Stakeholder stakeholder){
        return stakeholderDao.insertStakeholder(stakeholder);
    }
}
