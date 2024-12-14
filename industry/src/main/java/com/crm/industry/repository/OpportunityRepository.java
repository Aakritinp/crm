package com.crm.industry.repository;

import com.crm.industry.model.Opportunity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OpportunityRepository extends MongoRepository<Opportunity, String> {
}
