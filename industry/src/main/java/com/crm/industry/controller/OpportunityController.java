package com.crm.industry.controller;

import com.crm.industry.model.Opportunity;
import com.crm.industry.service.OpportunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/opportunities/")
public class OpportunityController {
    @Autowired
    private OpportunityService opportunityService;

    @PostMapping("save")
    public Opportunity save(Opportunity opportunity) {
        opportunity = opportunityService.save(opportunity);
        return opportunity;
    }

    @PutMapping("/{id}")
    public Opportunity update(@PathVariable String id, @RequestBody Opportunity opportunity) {
        Opportunity newOpportunity = opportunityService.update(opportunity, id);
        return newOpportunity;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        Opportunity newOpportunity = opportunityService.get(id);
        if (newOpportunity != null) {
            return ResponseEntity.ok(newOpportunity);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    public void delete(@PathVariable String id) {
        opportunityService.delete(id);

    }
}

