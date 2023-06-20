//Реализуйте структуру телефонной книги с помощью HashMap.
//Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
//их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.

import java.util.*;

public class HomeWork5 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> contacts = new HashMap<>();

        Scanner scanner = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            showMenu();
            String input = "0";
            if (scanner.hasNext()) {
                input = scanner.nextLine();
            }
            switch (input) {
                case "0" -> flag = false;
                case "1" -> showContacts(contacts);
                case "2" -> addContact(scanner, contacts);
            }
        }
    }

    public static void addContact(Scanner scanner, HashMap<String, ArrayList<String>> contacts) {
        System.out.print("Введите имя:");
        String name = scanner.nextLine();
        System.out.print("Введите телефон:");
        String phone = scanner.nextLine();

        //если ключ (имя) уже есть
        if (contacts.containsKey(name)) {
            //получаем лист телефонов и добавляем новый
            contacts.get(name).add(phone);
        } else {
            //иначе создаем новый лист телефонов
            ArrayList<String> phones = new ArrayList<>();
            //добавляем новый
            phones.add(phone);
            //добавляем в хешмапу
            contacts.put(name, phones);
        }
    }

    public static void showContacts(HashMap<String, ArrayList<String>> contacts) {
        //получаем набор ключей из хешмапы и преобразуем в массив строк для чего передаем в toArray нулевую строку
        String[] keys = contacts.keySet().toArray(new String[0]);
        //сортируем массив ключей по размеру ArrayList телефонов который в значениях хешмапы
        Arrays.sort(keys, (o1, o2) -> contacts.get(o2).size() - contacts.get(o1).size());

        //выводим сортированный массив ключей (имен) и по нему получаем телефоны
        for (String key : keys) {
            System.out.println(key + " " + String.join(", ", contacts.get(key)));
        }
    }

    public static void showMenu() {
        System.out.println("\n1 - Показать контакты");
        System.out.println("2 - Добавить контакт\n");
    }
}
