package com.test.addressbook.service;

import com.test.addressbook.dao.ContactDao;
import com.test.addressbook.model.Contact;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Validated
public class ContactService {

    private ContactDao contactDao;

    public ContactService(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @ValidateOnExecution
    public void addNewContact(@Valid Contact contact) {
        contactDao.create(contact);
    }

    public List<Contact> getContacts() {

        return contactDao.findAll();
    }

    public void compareAddressBook(String commaSeparatedNames) {
    	String[] names = commaSeparatedNames.split(",");
    	List<String> nameList1 = List.of(names);
    	List<String> nameList2 = contactDao.findAll().stream().map(c -> c.getName()).collect(Collectors.toList());
    	List<String> result = Stream.concat(nameList1.stream(), nameList2.stream()).map(name -> name.toLowerCase()).distinct().filter(name -> !nameList1.contains(name) || !nameList2.contains(name)).collect(Collectors.toList());
    	result.forEach(name -> System.out.println(name));
    	
    	
    }
}
