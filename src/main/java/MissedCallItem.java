import java.time.LocalDateTime;

public class MissedCallItem {
    LocalDateTime time;
    protected String phone;

    public MissedCallItem(LocalDateTime time, String phone) {
        this.time = time;
        this.phone = phone;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return time + "\n" + phone;
    }
}
