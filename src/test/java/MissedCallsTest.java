import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MissedCallsTest {

    final Contacts cont = new Contacts();

    @Test
    void addMissedCall() {
        // given:
        MissedCalls mssdClls = new MissedCalls();
        cont.addContact(new Contact("Tom", "Fox", "987564321", Group.WORK));
        // when:
        mssdClls.addMissedCall("123456789");
        List<MissedCallItem> actual = mssdClls.getMissedCallsList(cont);
        // then:
        Assertions.assertNotNull(mssdClls);
        Assertions.assertFalse(mssdClls.getMissedCallsList(cont).isEmpty());
        assertThat(mssdClls, notNullValue());
        assertThat(actual, is(not(empty())));
        assertThat(actual, hasSize(1));
    }

    @Test
    void getMissedCallsList() {
        // given:
        MissedCalls mssdClls = new MissedCalls();
        mssdClls.addMissedCall("123456789");
        cont.addContact(new Contact("Tom", "Fox", "987564321", Group.WORK));
        String expectedPhone = "123456789";
        // when:
        List<MissedCallItem> actual = mssdClls.getMissedCallsList(cont);
        String actualPhone = actual.get(0).getPhone();
        // then:
        Assertions.assertEquals(expectedPhone, actualPhone);
        assertThat(actual, is(not(empty())));
        assertThat(actualPhone, anyOf(equalTo(expectedPhone), not(equalTo("55555"))));
        assertThat(actualPhone, endsWith("789"));
    }

    @Test
    void deleteMissedCalls() {
        // given:
        MissedCalls mssdClls = new MissedCalls();
        mssdClls.addMissedCall("123456789");
        cont.addContact(new Contact("Tom", "Fox", "987564321", Group.WORK));
        // when:
        mssdClls.deleteMissedCalls();
        List<MissedCallItem> actual = mssdClls.getMissedCallsList(cont);
        // then:
        Assertions.assertTrue(actual.isEmpty());
        assertThat(actual, allOf(empty(), hasSize(0)));
    }
}