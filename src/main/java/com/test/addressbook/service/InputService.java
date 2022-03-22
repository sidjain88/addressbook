package com.test.addressbook.service;

import com.test.addressbook.model.Contact;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

@Service
public class InputService {

    private ContactService contactService;

    public InputService(ContactService contactService) {
        this.contactService = contactService;
    }

    public void takeInput(){
        while (true) {
            System.out.print("\n!! Welcome, please choose from the following options !!\n" +
                    "1 - Add new contact\n" +
                    "2 - View existing contacts\n" +
                    "3 - Compare an addressbook\n" +
                    "4 - Exit\n" +
                    "Please make a selection (1/2/3/4) : ");

            Scanner sc = new Scanner(System.in);

            String input = sc.nextLine();

            String invalidInputMsg = "Invalid selection. Please try again.";
            try {
                int i = Integer.parseInt(input);
                if (i == 4) {
                    break;
                }

                if (i != 1 && i != 2 && i != 3) {
                    System.out.println(invalidInputMsg);
                }

                switch (i){
                    case 1:
                        doAddNewContact(sc);
                        break;
                    case 2:
                        doDisplayContacts();
                        break;
                    case 3:
                        doCompareAddressBook(sc);
                        break;
                }


            } catch (NumberFormatException ex) {
                System.out.println(invalidInputMsg);
            }
        }
    }

    private void doCompareAddressBook(Scanner sc) {
        System.out.print("Type all the names comma-separated and press enter : ");
        String commaSeparatedNames = sc.nextLine();
        contactService.compareAddressBook(commaSeparatedNames);
    }

    private void doDisplayContacts() {
        List<Contact> contacts = contactService.getContacts();
        contacts.sort(Comparator.comparing(Contact::getName));
        contacts.forEach(c -> System.out.println(c.getName()+" "+c.getNumber()));
    }

    private void doAddNewContact(Scanner sc) {
        System.out.print("Type the name and press enter : ");
        String name = sc.nextLine();
        System.out.print("Type the phone number and press enter : ");
        String number = sc.nextLine();
        contactService.addNewContact(new Contact(name, number));
    }

}
