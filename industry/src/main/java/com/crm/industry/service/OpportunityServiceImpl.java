package com.crm.industry.service;

import com.crm.industry.model.Opportunity;
import com.crm.industry.repository.OpportunityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OpportunityServiceImpl implements OpportunityService {
    @Autowired
    private OpportunityRepository opportunityRepository;

    @Override
    public Opportunity save(Opportunity opportunity) {
        if (opportunity != null) {
            opportunityRepository.save(opportunity);
            return opportunity;
        }
        return null;
    }

    @Override
    public Opportunity update(Opportunity opportunity, String id) {
        if (opportunity != null && id != null) {
            opportunity.setId(id);
            opportunityRepository.save(opportunity);
            return opportunity;
        }
        return null;
    }

    @Override
    public Opportunity get(String id) {
        if (id != null) {
            Optional<Opportunity> opportunity = opportunityRepository.findById(id);
            if (opportunity.isPresent()) {
                return opportunity.get();
            }

        }
        return null;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            opportunityRepository.deleteById(id);
        }
    }
}
