package contact.ContactApp.web;

import contact.ContactApp.domain.Contact;
import contact.ContactApp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {
    @Autowired
    ContactService contactService;

    @GetMapping("contacts/{firstName}")
    public ResponseEntity<?> getContact(@PathVariable String firstName){
        Contact contact = contactService.findByName(firstName);
        if (contact == null){
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Contact with firstName = "+ firstName + "is not available"),
            HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Contact>(contact, HttpStatus.OK);

    }

}
