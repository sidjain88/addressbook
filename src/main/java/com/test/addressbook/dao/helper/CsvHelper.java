package com.test.addressbook.dao.helper;

import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.test.addressbook.dao.ContactDao;
import com.test.addressbook.model.Contact;

@Component
public class CsvHelper {

	private static final Logger LOG = LoggerFactory.getLogger(ContactDao.class);
	
    public String[] beanToArray(Contact contact){
        return new String[]{ contact.getName(), contact.getNumber()};
    }

    public Contact arrayToBean(String[] arr){
        return new Contact(arr[0], arr[1]);
    }
    
    
    public List<String[]> readAllFromFile(String filePath){
    	 try (
               CSVReader reader = new CSVReader(new FileReader(filePath))
         ) {        	
         	return reader.readAll();
         } catch (IOException | CsvException e) {
             LOG.error(e.getMessage());
         } 
    	 return Collections.emptyList();
    }
    

}
