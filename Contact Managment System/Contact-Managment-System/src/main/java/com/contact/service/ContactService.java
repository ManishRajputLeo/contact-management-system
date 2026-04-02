package com.contact.service;

import com.contact.contact.Contact;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ContactService {

    Contact createContact(Contact contact);
    List<Contact> getAllContacts();
    Optional<Contact> getContactById(Long id);
    void deleteContactById(Long id);
    Contact updateContact(Long id, Contact contact);
}
