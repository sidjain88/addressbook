package com.test.addressbook.dao;

import static org.hamcrest.CoreMatchers.anything;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.addressbook.dao.helper.CsvHelper;
import com.test.addressbook.model.Contact;
import com.test.addressbook.properties.ContactProperties;
import com.test.addressbook.service.ContactService;

@ExtendWith(MockitoExtension.class)
public class ContactDaoTest {
		
	private ContactDao contactDao;
	
	@Mock
	private CsvHelper csvHelper;
	@Mock
	private ContactProperties properties;

	@BeforeEach
	public void beforeEach() {
		contactDao = new ContactDao(csvHelper, properties);
		when(properties.getStorageFileName()).thenReturn("contacts.csv");		
	}
	
	public void testCreate() {
		Contact contact = new Contact("Sid", "0411223344");
		contactDao.create(contact);
	}

}
