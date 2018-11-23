package ru.makhnutin.contacts.service;

import ru.makhnutin.contacts.model.Contact;
import ru.makhnutin.contacts.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepository;

	@Override
	public Contact fineById(Long id) {
		return contactRepository.findOne(id);
	}

	@Override
	public void saveContact(Contact contact) {
		contactRepository.save(contact);
	}

	@Override
	public List<Contact> findAllContacts() {
		return contactRepository.findAll();
	}

	@Override
	public void deleteUserById(Long id) {
		contactRepository.delete(id);
	}


}
