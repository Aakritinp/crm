package com.crm.industry.service;

import com.crm.industry.model.Contact;
import com.crm.industry.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class ContactServiceImpl implements ContactService {
    @Autowired

    private ContactRepository contactRepository;

    @Override
    public Contact save(Contact contact) {
        if (contact != null) {
            contactRepository.save(contact);
            return contact;
        }
        return null;
    }

    @Override
    public Contact update(Contact contact, String id) {
        if (contact != null && id != null) {
            //   contact.setId(id);
            contactRepository.save(contact);
            return contact;
        }
        return null;
    }

    @Override
    public Contact get(String id) {
        if (id != null) {
            Optional<Contact> contact = contactRepository.findById(id);
            if (contact.isPresent()) {
                return contact.get();
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        if (id != null) {
            contactRepository.deleteById(id);
        }
    }
}
