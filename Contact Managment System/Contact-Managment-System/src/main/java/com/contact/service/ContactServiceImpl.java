package com.contact.service;

import com.contact.contact.Contact;
import com.contact.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

@Autowired
ContactRepository contactRepository;

    @Override
    public Contact createContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public Optional<Contact> getContactByName(String name) {
        return contactRepository.getContactByName(name);
    }

    @Override
    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);
    }

    @Override
    public Contact updateContact( Long id, Contact contact) {
        Contact existingContact = contactRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Contact Not Found"));

        existingContact.setName(contact.getName());
        existingContact.setEmail(contact.getEmail());
        existingContact.setPhone(contact.getPhone());
        existingContact.setAddress(contact.getAddress());
        return contactRepository.save(existingContact);
    }
}
