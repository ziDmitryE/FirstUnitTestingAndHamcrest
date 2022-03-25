import java.time.LocalDateTime;
import java.util.*;

public class MissedCalls {
    private Map<LocalDateTime, String> missedCalls = new TreeMap<>();
    List<MissedCallItem> MissedCallsList = new ArrayList<>();

    public void addMissedCall(String phone) {
        missedCalls.put(LocalDateTime.now(), phone);
    }

    public List<MissedCallItem> getMissedCallsList(Contacts contacts) {
        MissedCallsList.clear();
        for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
            if (contacts.findContact(entry.getValue()) != null) {
                MissedCallsList.add(new MissedCallItem(entry.getKey(), contacts.getNameSurname(entry.getValue())));
            } else {
                MissedCallsList.add(new MissedCallItem(entry.getKey(), entry.getValue()));
            }
        }
        return MissedCallsList;
    }

    public void deleteMissedCalls() {
        missedCalls.clear();
    }

}

