package com.SECAPCompass.stakeholderapi.dao;

import com.SECAPCompass.stakeholderapi.model.Stakeholder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class StakeholderDataAccessService implements StakeholderDao{

    private static List<Stakeholder> DB = new ArrayList<Stakeholder>();

    @Override
    public int insertStakeholder(UUID id, Stakeholder stakeholder) {
        DB.add(new Stakeholder(id,stakeholder.getClass().getName()));
        return 0;
    }

    public List<Stakeholder> selectAllStakeholders(){
        return DB;
    }

    @Override
    public Optional<Stakeholder> selectPersonByID(UUID id) {
        return DB.stream()
                .filter(stakeholder -> stakeholder.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deleteStakeholderByID(UUID id) {
        Optional<Stakeholder> stakeholderMaybe = selectPersonByID(id);
        if(stakeholderMaybe.isEmpty())
            return 0;
        DB.remove(stakeholderMaybe.get());
        return 1;
    }

    @Override
    public int updateStakeholderByID(UUID id,Stakeholder stakeholder) {
        //this lambda function might require a fix
        return selectPersonByID(id)
                .map(s -> {
                    int indexOfStakeholder = DB.indexOf(s);
                    if (indexOfStakeholder >= 0){
                        DB.set(indexOfStakeholder,new Stakeholder(id,stakeholder.getUserName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
