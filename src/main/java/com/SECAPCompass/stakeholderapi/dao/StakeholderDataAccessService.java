package com.SECAPCompass.stakeholderapi.dao;

import com.SECAPCompass.stakeholderapi.model.Stakeholder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("fakeDao")
public class StakeholderDataAccessService implements StakeholderDao{

    private static List<Stakeholder> DB = new ArrayList<Stakeholder>();

    @Override
    public int insertStakeholder(UUID id, Stakeholder stakeholder) {
        DB.add(new Stakeholder(id,stakeholder.getClass().getName()));
        return 0;
    }
}
