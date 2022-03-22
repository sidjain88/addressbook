package com.test.addressbook.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ContactProperties {

	@Value("${storage.file.name}")
	private String storageFileName;

	public String getStorageFileName() {
		return storageFileName;
	}
		
}
