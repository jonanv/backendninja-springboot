package com.udemy.entity;

import javax.persistence.Entity;

@Entity
public class Contact {
    
    private String firstname;
    private String lastname;
    private String telephone;
    private String city;

    public Contact() {
    }

    public Contact(String firstname, String lastname, String telephone, String city) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.telephone = telephone;
        this.city = city;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Contact [firstname=" + firstname + ", lastname=" + lastname + ", city=" + city + ", telephone="
                + telephone + "]";
    }
    
}
