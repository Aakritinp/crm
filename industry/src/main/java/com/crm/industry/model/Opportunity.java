package com.crm.industry.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
public class Opportunity {
    @Id
    private String id;
    private String policyNumber;
    private Date expiry;
    private Date effective;
}
