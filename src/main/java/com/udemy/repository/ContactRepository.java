package com.udemy.repository;

import java.io.Serializable;

import com.udemy.entity.Contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("contactRepository")
public interface ContactRepository extends JpaRepository<Contact, Serializable>{
    
}