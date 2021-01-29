package com.udemy.model;

public class ContactModel {
    
    private String id;
    private String firstname;
    private String lastname;
    private String telephone;
    private String city;

    public ContactModel() {
    }

    public ContactModel(String firstname, String lastname, String telephone, String city) {
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
        return "ContactModel [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", telephone=" 
            + telephone + ", city=" + city + "]";
    }

}
