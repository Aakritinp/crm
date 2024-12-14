package com.crm.industry.service;

import com.crm.industry.model.Opportunity;

public interface OpportunityService {
    Opportunity save(Opportunity opportunity);

    Opportunity update(Opportunity opportunity, String id);

    Opportunity get(String id);

    void delete(String id);
}
