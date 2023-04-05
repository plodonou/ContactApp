package contact.ContactApp.web;

import contact.ContactApp.domain.Contact;
import contact.ContactApp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;


    @GetMapping("contacts/{firstName}")
    public ResponseEntity<?> getContact(@PathVariable String firstName){

       Contact contact = contactService.findByName(firstName);
        if (contact == null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Contact with firstName= "+ firstName + " is not available"),
            HttpStatus.NOT_FOUND);
        }

       return new ResponseEntity<Contact>(contact, HttpStatus.OK);

    }


    @PostMapping("contact")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
        contactService.addContact(contact);
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);

    }


    @PutMapping("contacts/{firstName}")
    public ResponseEntity<?> update(@PathVariable String firstName, @RequestBody Contact contact){
         contactService.updateContact(contact);
         return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    }

    @GetMapping("contacts")
    public ResponseEntity<?> getAllContacts(){
        Contacts contacts = new Contacts(contactService.findAll());
        return new ResponseEntity<Contacts>(contacts,HttpStatus.OK);
    }

    @DeleteMapping("contacts/{firstName}")
    public ResponseEntity<?> deleteContact(@PathVariable String firstName){
        Contact contact = contactService.findByName(firstName);
        if(contact == null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType(" Contact with firstName= " + firstName + " is not available"),HttpStatus.NOT_FOUND);
        }
        contactService.delete(firstName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
