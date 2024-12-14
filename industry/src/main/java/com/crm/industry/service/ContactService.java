package com.crm.industry.service;

import com.crm.industry.model.Contact;

public interface ContactService {
    Contact save(Contact contact);

    Contact update(Contact contact, String id);

    Contact get(String id);

    void delete(String id);
}
