package ru.makhnutin.contacts.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ru.makhnutin.contacts.model.Contact;
import ru.makhnutin.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api")
public class RestApiController {

	@Autowired
	ContactService contactService;

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public ResponseEntity<List<Contact>> listAllContacts() {
		List<Contact> contacts = contactService.findAllContacts();
		if (contacts.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(contacts, HttpStatus.OK);
	}

	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getContact(@PathVariable("id") long id) {
		Contact contact = contactService.fineById(id);
		if (contact == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}

	@RequestMapping(value = "/contacts/", method = RequestMethod.POST)
	public ResponseEntity<?> createContact(@RequestBody Contact contact) {
		contactService.saveContact(contact);
		return new ResponseEntity<String>(HttpStatus.CREATED);
	}

	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateContact(@PathVariable("id") long id, @RequestBody Contact contact) {
		Contact currentContact = contactService.fineById(id);
		if (currentContact == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		currentContact.setFirstName(contact.getFirstName());
		currentContact.setSecondName(contact.getSecondName());
		currentContact.setPhone(contact.getPhone());
		currentContact.setEmail(contact.getEmail());
		currentContact.setBirthDay(contact.getBirthDay());
		contactService.saveContact(currentContact);
		return new ResponseEntity<>(currentContact, HttpStatus.OK);
	}

	@RequestMapping(value = "/contacts/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteContact(@PathVariable("id") long id) {
		Contact contact = contactService.fineById(id);
		if (contact == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		contactService.deleteUserById(id);
		return new ResponseEntity<Contact>(HttpStatus.NO_CONTENT);
	}

}