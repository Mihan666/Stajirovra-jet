package ru.guzev.stajirovka_jet.forContacts.modelForContacts;

import java.util.Objects;

public class GroupDataForContacts {
    private  int id;
    private final String firstName;
    private final String lastName;
    private final String phone;
    private final String email;

    public GroupDataForContacts(int id, String firstName, String lastName, String phone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    public GroupDataForContacts(String firstName, String lastName, String phone, String email) {
        this.id = 0;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupDataForContacts contacts = (GroupDataForContacts) o;
        return id == contacts.id &&
                Objects.equals(firstName, contacts.firstName) &&
                Objects.equals(lastName, contacts.lastName) &&
                Objects.equals(phone, contacts.phone) &&
                Objects.equals(email, contacts.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, phone, email);
    }

    public void setId(int id) {
        this.id = id;
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
