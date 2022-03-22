package com.test.addressbook.service;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.addressbook.dao.ContactDao;
import com.test.addressbook.model.Contact;

@ExtendWith(MockitoExtension.class)
public class ContactServiceTest {
	
	@Mock
	private ContactDao contactDao;
	
	private ContactService contactService;

	@BeforeEach
	public void beforeEach() {
		contactService = new ContactService(contactDao);
	}
	
	@Test
	public void testAddValidContact() {
		Contact contact = new Contact("Sid", "0411223344");
		contactService.addNewContact(contact);
		verify(contactDao,times(1)).create(contact);
	}
	
	@Test
	public void testGetContacts() {
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Sid", "0411223344"));
		contacts.add( new Contact("John", "0411223345"));
		when(contactDao.findAll()).thenReturn(contacts);
		List<Contact> result = contactService.getContacts();
		assertArrayEquals(result.toArray(), contacts.toArray());
	}
	
}
