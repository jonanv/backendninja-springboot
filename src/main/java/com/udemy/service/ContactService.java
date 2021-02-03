package com.udemy.service;

import java.util.List;

import com.udemy.entity.Contact;
import com.udemy.model.ContactModel;

public interface ContactService {

    public abstract List<ContactModel> listAllContacts();

    public abstract ContactModel addContact(ContactModel contactModel);

    public abstract Contact findContactById(int id);

    public abstract void removeContact(int id);

}
