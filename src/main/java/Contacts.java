import java.util.HashMap;
import java.util.Map;

public class Contacts {
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        if (!contacts.containsKey(contact.Phone)) {
            contacts.put(contact.Phone, contact);
        } else {
            System.out.println("Такой телефон уже есть");
        }
    }

    public void deleteContact(String name, String surname) {
        for (Contact contact : contacts.values()) {
            if (contact.Name.equals(name) & contact.Surname.equals(surname)) {
                contacts.remove(contact.Phone);
            }
        }
    }

    public Contact findContact(String phone) {
        if (contacts.containsKey(phone)) {
            return contacts.get(phone);
        } else {
            return null;
        }
    }

    public Contact getContact(String name, String surname) {
        for (Contact contact : contacts.values()) {
            if (contact.Name.equals(name) & contact.Surname.equals(surname)) {
                return contact;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        if (contacts.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Contact> stringContactEntry : contacts.entrySet()) {
            sb.append(stringContactEntry.getKey()).append("\n").append(stringContactEntry.getValue());
        }
        return sb.toString();
    }

    public String getNameSurname(String K) {
        return contacts.get(K).Name + " " + contacts.get(K).Surname;
    }

}
