package com.crm.industry.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Account {
    @Id
    private String id;
    private String name;
    private String type;
}