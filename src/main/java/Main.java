import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Contacts contacts = new Contacts();
        MissedCalls missedCalls = new MissedCalls();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            showMenu();
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                if (input == 7) {
                    System.out.println("Вы вышли из программы");
                    break;
                }
                switch (input) {
                    case 1:
                        System.out.println("Введите данные нового контакта через пробел: Имя, Фамилия, тел., группа (WORK/FRIENDS/FAMILY)");
                        Scanner scanner1 = new Scanner(System.in);
                        String input1 = scanner1.nextLine();
                        String[] parts = input1.split(" ");
                        Contact contact = new Contact(parts[0], parts[1], parts[2], Group.valueOf(parts[3]));
                        contacts.addContact(contact);
                        System.out.println("Контакт добавлен");
                        break;
                    case 2:
                        System.out.println("Введите имя и фамилию контакта для удаления через пробел");
                        Scanner scanner2 = new Scanner(System.in);
                        String input2 = scanner2.nextLine();
                        String[] parts1 = input2.split(" ");
                        if (contacts.getContact(parts1[0], parts1[1]) != null) {
                            contacts.deleteContact(parts1[0], parts1[1]);
                            System.out.println("Контакт удален из справочника");
                        } else System.out.println("Такого контакта нет в справочнике");
                        break;
                    case 3:
                        if (contacts.isEmpty()) {
                            System.out.println("Список контактов пуст");
                        } else System.out.println("Список контактов:\n" + contacts);
                        break;
                    case 4:
                        System.out.println("Добавьте номер пропущенного вызова");
                        Scanner scanner3 = new Scanner(System.in);
                        String input3 = scanner3.nextLine();
                        missedCalls.addMissedCall(input3);
                        System.out.println("Номер добавлен");
                        break;
                    case 5:
                        List<MissedCallItem> items = missedCalls.getMissedCallsList(contacts);
                        System.out.println("Список пропущенных вызовов:");
                        if (items.isEmpty()) {
                            System.out.println("Пропущенных вызовов нет\n");
                        } else {
                            for (MissedCallItem item : items) {
                                System.out.println(item);
                            }
                        }
                        break;
                    case 6:
                        missedCalls.deleteMissedCalls();
                        System.out.println("Список пропущенных вызовов очищен");
                        break;
                    default:
                        throw new RuntimeException("Некорректный ввод! Перезапустите программу и попробуйте снова!");
                }
            } else {
                System.out.println("Вы ввели не число! Попробуйте снова");
            }
            continue;
        }
    }

    public static void showMenu() {
        System.out.println("Выберите пункт из меню (1-7):\n" +
                "Меню:\n" +
                "\t1. Добавить контакт в справочник\n" +
                "\t2. Удалить контакт из справочника\n" +
                "\t3. Вывести список контактов\n" +
                "\t4. Добавить пропущенный вызов\n" +
                "\t5. Вывести все пропущенные вызовы\n" +
                "\t6. Очистить пропущенные вызовы\n" +
                "\t7. Выход");
    }
}

