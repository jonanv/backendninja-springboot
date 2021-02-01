package com.udemy.service;

import java.util.List;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

public interface ContactService {

    public abstract List<ContactModel> listAllContacts();

    public abstract ContactModel addContact(ContactModel contactModel);

    // public abstract Contact updateContact(Contact contact);

    // public abstract int removeContact(int id);

}
