package ru.gb.goncharov;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static String [] testData = {
            "Иванов 123456",
            "Петров 527456",
            "Сидоров 456789",
            "Иванов 654321",
            "Петров 456123",
            "Иванов 456135"};

    public static void main(String[] args) {
        System.out.println("Промежуточная аттестация по Java.");
        System.out.println("====================================");
        int lengthOfMenu = 7; //Колличество пунктов Меню.
        boolean showMenu = true;
        while (showMenu) {
            System.out.println();
            System.out.println("Работа с телефонной книгой");
            System.out.println("1 - Показать всю телефонную книгу");
            System.out.println("2 - Добавить контакт");
            System.out.println("3 - Удалить контакт");
            System.out.println("4 - Найти контакт по имени");
            System.out.println("5 - Найти контакт по номеру");
            System.out.println("6 - Заполнить телефонную книгу тестовыми данными");
            System.out.println("7 - Удалить все данные из телефонной книги");
            System.out.println("0 - Завершение работы приложения");
            System.out.println("=====================================");
            System.out.print("Выберете пункт меню: ");

            String numberForCheck = scanner.nextLine();
            int numberOfMenu;
            if ((numberOfMenu = tryParseInt(numberForCheck))>lengthOfMenu || numberOfMenu < 0){
                System.out.println("Некорректно выбран пункт меню, попробуйте еще раз");
                continue;
            }
                switch (numberOfMenu) {
                    case 1:
                        showPhoneBook();
                        break;
                    case 2:
                        addContactToPhoneBook();
                        break;
                    case 3:
                        removeContactFromPhoneBook();
                        break;
                    case 4:
                        SearchContactInPhoneBook();
                        break;
                    case 5:
                        SearchNumberInPhoneBook();
                        break;
                    case 6:
                        FillTestsData(testData);
                        break;
                    case 7:
                        EraseAllData();
                        break;
                    case 0:
                        showMenu = false;
                        break;
                }

        }

}
    static HashMap<Integer, String > contact = new HashMap<>();

    private static int tryParseInt(String checkNum) {
        try {
            return Integer.parseInt(checkNum);
        }
        catch (NumberFormatException e1){
                System.out.println("Ошибка: Для выбора пункта меню, введите № пункта меню.");
                return -1;
            }

    }

    //1 - Показать всю телефонную книгу +
    private static void showPhoneBook() {
        System.out.println("Вывожу весь список..");
        if (contact.isEmpty()){
            System.out.println("В вашем списке пока нет контактов, внесите контакты или импортируйте тестовый спсок");
        }
        for (Map.Entry<Integer, String> e: contact.entrySet()) {
            System.out.println(e);
        }
    }

    //2 - Добавить контакт +
    private static void addContactToPhoneBook() {
        System.out.print("Введите имя контакта: ");
        String name = scanner.nextLine();
        System.out.println();
        System.out.print("Введите номер контакта: ");
        int number = Integer.parseInt(scanner.nextLine());
        for (Map.Entry<Integer, String> e:contact.entrySet())
            if (!contact.containsKey(number)){
                contact.put(number, name);
                System.out.println("Контакт успешно дорбавлен.");
                return;
            }
            else
            if (e.getKey().equals(number)){
                System.out.printf("Данный номер уже существует %d - %s\n", e.getKey(), e.getValue());
                System.out.println("Хотите его перезаписать? (y/n)");
                String confirm = scanner.nextLine();
                if (confirm.equals("y")) {
                    contact.put(number, name);
                    System.out.println("Контакт успешно обновлен.");
                    return;
                }
                else if (confirm.equals("n")) {
                    return;
                }
                else {
                    System.out.println("Вы ввели не верный символ, повторите попытку");
                }
            }

    }

    //3 - Удалить контакт -
    private static void removeContactFromPhoneBook() {
        System.out.print("Введите Имя или номер контакта для Удаления: ");
        String eraseData = scanner.nextLine();
        int checkData = tryParseInt(eraseData);
        if(checkData==-1){
            System.out.println("Ищу контакт..");
            for (Map.Entry<Integer, String> e:contact.entrySet())
                if (!contact.containsValue(eraseData)){
                    System.out.println("Контакт не найден.");
                    return;
                }
                else
                if (e.getValue().equals(eraseData)){
                    System.out.printf("%d - %s\n", e.getKey(), e.getValue());
                }
                System.out.print("Действительно хотите удалить данный контакт? (y/n): ");
                String confirm = scanner.nextLine();
                if (confirm.equals("y")) {
                    for (Map.Entry<Integer, String> e:contact.entrySet()) {
                        if (e.getValue().equals(eraseData)){
                            contact.remove(e.getKey());
                            System.out.println("Контакт успешно удален.");
                        }
                        return;
                    }
                }
                else if (confirm.equals("n")) {
                    return;
                }
                else {
                    System.out.println("Вы ввели не верный символ, повторите попытку");
                }
        }
        else {
            System.out.println("Ищу номер..");
            for (Map.Entry<Integer, String> e:contact.entrySet())
                if (!contact.containsKey(checkData)){
                    System.out.println("Контакт не найден.");
                    return;
                }
                else
                if (e.getKey().equals(checkData)) {
                    System.out.printf("%d - %s\n", e.getKey(), e.getValue());
                    System.out.print("Действительно хотите удалить данный контакт? (y/n): ");
                        String confirm = scanner.nextLine();
                        if (confirm.equals("y")) {
                            contact.remove(e.getKey());
                            System.out.println("Контакт успешно удален.");
                            return;
                        }
                        else if (confirm.equals("n")) {
                            return;
                        } else {
                         System.out.println("Вы ввели не верный символ, повторите попытку");
                        }
                }
        }

    }

    //4 - Найти контакт по имени +
    private static void SearchContactInPhoneBook() {
        System.out.print("Введите Имя контакта: ");
        String contForSearch = scanner.nextLine();
        System.out.println("Ищу контакт..");
        for (Map.Entry<Integer, String> e:contact.entrySet())
            if (!contact.containsValue(contForSearch)){
                System.out.println("Контакт не найден.");
                return;
            }
            else
            if (e.getValue().equals(contForSearch)){
                System.out.printf("%d - %s\n", e.getKey(), e.getValue());
            }

    }

    //5 - Найти контакт по номеру +
    private static void SearchNumberInPhoneBook() {
        System.out.print("Введите номер контакта: ");
        int nunForSearchInt = Integer.parseInt(scanner.nextLine());
        System.out.println("Ищу номер..");
        for (Map.Entry<Integer, String> e:contact.entrySet())
            if (!contact.containsKey(nunForSearchInt)){
                System.out.println("Контакт не найден.");
                return;
            }
            else
            if (e.getKey().equals(nunForSearchInt)){
                System.out.printf("%d - %s\n", e.getKey(), e.getValue());
            }
    }

    //6 - Заполнить телефонную книгу тестовыми данными +

    private static void FillTestsData(String[] data) {
        System.out.println("Заполняем Книгу тестовыми значениями..");
        for (String person : data){
            String[] personParts = person.split(" ");
            contact.put(Integer.parseInt(personParts[1]), personParts[0]);
        }
        System.out.println("---------------------------------------");
        System.out.println("Импорт выполненен!");
    }

    //7 - Удалить все данные из телефонной книги +

    private static void EraseAllData() {
        System.out.print("Вы действительно хотите удалить все данные?(y/n): ");
        String confirm = scanner.nextLine();

        if (confirm.equals("y")) {
            contact.clear();
        }
        else if (confirm.equals("n")) {
            return;
        }
        else {
            System.out.println("Вы ввели не верный символ, повторите попытку");
        }
    }

}
