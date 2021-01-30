package com.udemy.component;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

import org.springframework.stereotype.Component;

@Component("contactConverter")
public class ContactConverter {
    
    public Contact convertContactModel2Contact(ContactModel contactModel) {
        Contact contact = new Contact();
        contact.setFirstname(contactModel.getFirstname());
        contact.setLastname(contactModel.getLastname());
        contact.setTelephone(contactModel.getTelephone());
        contact.setCity(contactModel.getCity());
        return contact;
    }

    public ContactModel convertContact2ContactModel(Contact contact) {
        ContactModel contactModel = new ContactModel();
        contactModel.setFirstname(contact.getFirstname());
        contactModel.setLastname(contact.getLastname());
        contactModel.setTelephone(contact.getTelephone());
        contactModel.setCity(contact.getCity());
        return contactModel;
    }
}
