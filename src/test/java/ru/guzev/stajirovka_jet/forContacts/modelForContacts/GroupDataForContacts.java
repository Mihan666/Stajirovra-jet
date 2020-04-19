package ru.guzev.stajirovka_jet.forContacts.modelForContacts;

import java.util.Objects;

public class GroupDataForContacts {
    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDataForContacts contacts = (GroupDataForContacts) o;
        return Objects.equals(firstName, contacts.firstName) &&
                Objects.equals(lastName, contacts.lastName) &&
                Objects.equals(phone, contacts.phone) &&
                Objects.equals(email, contacts.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, phone, email);
    }

    public GroupDataForContacts withId(int id) {
        this.id = id;
        return this;
    }

    public GroupDataForContacts withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public GroupDataForContacts withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public GroupDataForContacts withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public GroupDataForContacts withEmail(String email) {
        this.email = email;
        return this;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "GroupDataForContacts{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
