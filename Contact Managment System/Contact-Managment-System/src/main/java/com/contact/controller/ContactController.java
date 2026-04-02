package com.contact.controller;

import com.contact.contact.Contact;
import com.contact.repository.ContactRepository;
import com.contact.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private ContactRepository contactRepository;

    @PostMapping("/create")
    public ResponseEntity<Contact> createContact(@RequestBody Contact contact) {
        return ResponseEntity.ok(contactRepository.save(contact));
    }

    @GetMapping("/view")
    public ResponseEntity<List<Contact>> getAllContacts()
    {
        return ResponseEntity.ok(contactRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id){
        return contactService.getContactById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Contact> update(@PathVariable Long id, @RequestBody Contact contact){
        return ResponseEntity.ok(contactService.updateContact(id, contact));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Contact> deleteContactById(@PathVariable Long id){
        contactService.deleteContactById(id);
        return ResponseEntity.noContent().build();
    }
}
