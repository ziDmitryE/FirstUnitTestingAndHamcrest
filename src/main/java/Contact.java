public class Contact {
    protected String Name;
    protected String Surname;
    protected String Phone;
    protected Group Group;

    public Contact(String name, String surname, String phone, Group group) {
        Name = name;
        Surname = surname;
        Phone = phone;
        Group = group;
    }

    @Override
    public String toString() {
        return  Name + '\'' + Surname + '\'' + Group + "\n";
    }

    public String getName() {
        return Name;
    }

    public String getSurname() {
        return Surname;
    }

    public String getPhone() {
        return Phone;
    }

    public Group getGroup() {
        return Group;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public void setGroup(Group group) {
        Group = group;
    }
}

