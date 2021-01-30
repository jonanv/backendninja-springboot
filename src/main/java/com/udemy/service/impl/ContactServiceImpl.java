package com.udemy.service.impl;

import java.util.List;

import com.udemy.component.ContactConverter;
import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;
import com.udemy.repository.ContactRepository;
import com.udemy.service.ContactService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("contactService")
public class ContactServiceImpl implements ContactService {

    @Autowired
    @Qualifier("contactRepository")
    private ContactRepository contactRepository;

    @Autowired
    @Qualifier("contactConverter")
    private ContactConverter contactConverter;

    @Override
    public Contact addContact(ContactModel contactModel) {
        Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
        return contact;
    }

    @Override
    public List<Contact> listAllContact() {
        return null;
    }

    @Override
    public int removeContact(int id) {
        return 0;
    }

    @Override
    public Contact updateContact(Contact contact) {
        return null;
    }
    
}
