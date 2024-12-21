package com.crm.industry.service;

import com.crm.industry.model.Contact;

import java.util.List;

public interface ContactService {
    Contact save(Contact contact);

    Contact update(Contact contact, String id);

    Contact get(String id);

    List <Contact> get();

    void delete(String id);
}
