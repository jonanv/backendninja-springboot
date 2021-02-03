package com.udemy.service.impl;

import java.util.ArrayList;
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
    public ContactModel addContact(ContactModel contactModel) {
        Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
        return contactConverter.convertContact2ContactModel(contact);
    }

    @Override
    public List<ContactModel> listAllContacts() {
        List<Contact> contacts = contactRepository.findAll();
        List<ContactModel> contactsModel = new ArrayList<ContactModel>();
        for (Contact contact : contacts) {
            contactsModel.add(contactConverter.convertContact2ContactModel(contact));
        }
        return contactsModel;
    }

    @Override
    public Contact findContactById(int id) {
        return contactRepository.findById(id);
    }

    @Override
    public ContactModel findContactByIdModel(int id) {
        Contact contact = findContactById(id);
        return contactConverter.convertContact2ContactModel(contact);
    }

    @Override
    public void removeContact(int id) {
        Contact contact = findContactById(id);
        if (contact != null) {
            contactRepository.delete(contact);
        }
    }

}
