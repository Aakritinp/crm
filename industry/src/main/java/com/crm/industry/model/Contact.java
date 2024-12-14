package com.crm.industry.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Contact {
    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private String address;
}
