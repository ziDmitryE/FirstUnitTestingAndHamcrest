import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactsTest {

    final Contact contact1 = new Contact("Alex", "Blake", "123456789", Group.WORK);
    final Contact contact2 = new Contact("Tom", "Fox", "987654321", Group.WORK);

    @Test
    void addContact() {
        // given:
        Contacts cont = new Contacts();
        // when:
        cont.addContact(contact1);
        String actual = cont.toString();
        // then:
        Assertions.assertFalse(cont.isEmpty());
        Assertions.assertEquals(contact1, cont.getContact(contact1.getName(), contact1.getSurname()));
        assertThat(cont, notNullValue());
        assertThat(actual, allOf(containsString("123456789"), containsString("Alex")));
        assertThat(actual, endsWith("WORK\n"));
    }

    @Test
    void deleteContact() {
        // given:
        Contacts cont = new Contacts();
        cont.addContact(contact1);
        // when:
        cont.deleteContact(contact1.getName(), contact1.getSurname());
        Contact actual = cont.getContact(contact1.getName(), contact1.getSurname());
        // then:
        Assertions.assertTrue(cont.isEmpty());
        assertThat(actual, nullValue());
    }

    @Test
    void findContact() {
        // given:
        Contacts cont = new Contacts();
        cont.addContact(contact1);
        Contact expected = contact1;
        // when:
        Contact actual = cont.findContact(contact1.getPhone());
        Contact actual2 = cont.findContact(contact2.getPhone());
        // then:
        Assertions.assertEquals(expected, actual);
        Assertions.assertNull(actual2);
        assertThat(actual, equalTo(expected));
        assertThat(actual2, nullValue());
    }
}