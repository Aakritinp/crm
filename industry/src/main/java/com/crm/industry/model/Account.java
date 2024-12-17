package com.crm.industry.model;

import com.crm.industry.object.Address;
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
    private Address address;
}