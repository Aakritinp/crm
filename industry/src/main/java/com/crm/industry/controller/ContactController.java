package com.crm.industry.controller;

import com.crm.industry.model.Contact;
import com.crm.industry.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contacts/")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping("save")
    public Contact save(Contact contact) {
        contact = contactService.save(contact);
        return contact;
    }

    @PutMapping("/{id}")
    public Contact update(@PathVariable String id, @RequestBody Contact contact) {
        Contact newContact = contactService.update(contact, id);
        return newContact;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable String id) {
        Contact newContact = contactService.get(id);
        if(newContact != null){
            return ResponseEntity.ok(newContact);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<?> get(){
        List<Contact> newContact = contactService.get();
        if(newContact!=null){
            return ResponseEntity.ok(newContact);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping
    public void delete(@PathVariable String id) {
        contactService.delete(id);

    }
}

