package ru.makhnutin.contacts.service;

import ru.makhnutin.contacts.model.Contact;
import java.util.List;

public interface ContactService {

	Contact fineById(Long id);

	void saveContact(Contact contact);

	List<Contact> findAllContacts();

	void deleteUserById(Long id);
}
