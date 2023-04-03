package contact.ContactApp.service;

import contact.ContactApp.data.ContactRepository;
import contact.ContactApp.domain.Contact;
import contact.ContactApp.integration.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    @Autowired
    EmailSender emailSender;

    public void addContact(Contact contact){
        contactRepository.save(contact);
        emailSender.sendEmail("Welcome", contact.getEmail());
    }


}
