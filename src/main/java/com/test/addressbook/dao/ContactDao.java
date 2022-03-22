package com.test.addressbook.dao;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import com.opencsv.CSVWriter;
import com.test.addressbook.dao.helper.CsvHelper;
import com.test.addressbook.model.Contact;
import com.test.addressbook.properties.ContactProperties;

@Repository
public class ContactDao {	

    private static final Logger LOG = LoggerFactory.getLogger(ContactDao.class);

    private final CsvHelper helper;
    
    private final ContactProperties contactProperties;

    private URL file;

    public ContactDao(CsvHelper helper, ContactProperties contactProperties) {
        this.helper = helper;
        this.contactProperties = contactProperties;
        try {
			this.file = ResourceUtils.getURL(this.contactProperties.getStorageFileName());
		} catch (FileNotFoundException e) {
			LOG.error(e.getMessage());
		}		
    }

    public void create(Contact contact){ 
    	
    	List<String[]> allContacts = helper.readAllFromFile(file.getPath());
    	
        try (
              CSVWriter writer  = new CSVWriter(new FileWriter(file.getPath()));
        ) {        	
            String[] newContact = helper.beanToArray(contact);
            allContacts.add(newContact);
			writer.writeAll(allContacts); 
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }

    public List<Contact> findAll(){
    	List<String[]> list = helper.readAllFromFile(file.getPath());
        return list.stream().map(arr -> helper.arrayToBean(arr)).collect(Collectors.toList());                      
    }
}
