public enum Group {
    WORK("Работа"),
    FRIENDS("Друзья"),
    FAMILY("Семья");

    private String name;

    Group(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
