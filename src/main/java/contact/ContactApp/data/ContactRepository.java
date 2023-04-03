package contact.ContactApp.data;

import contact.ContactApp.domain.Contact;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ContactRepository {

    private Map<String, Contact> contacts = new HashMap<String, Contact>();

    public void save(Contact contact){
        contacts.put(contact.getFirstName(), contact);
    }


}
