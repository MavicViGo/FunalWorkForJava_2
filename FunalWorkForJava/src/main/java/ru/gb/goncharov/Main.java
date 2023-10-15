package ru.gb.goncharov;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Промежуточная аттестация по Java.");
        System.out.println("====================================");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("Работа с телефонной книгой");
            System.out.println("1 - Показать всю телефонную книгу");
            System.out.println("2 - Добавить контакт");
            System.out.println("3 - Удалить контакт");
            System.out.println("4 - Найти контакт по имени");
            System.out.println("5 - Найти контакт по номеру");
            System.out.println("0 - Завершение работы приложения");
            System.out.println("=====================================");
            System.out.print("Выберете пункт меню: ");

            String numberForCheck = scanner.nextLine();
            int numberOfMenu;
            if ((numberOfMenu = tryParseInt(numberForCheck))>5 || numberOfMenu < 0){
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
                    case 0:
                        showMenu = false;
                        break;
                }

        }

}

    private static int tryParseInt(String checkNum) {
        try {
            return Integer.parseInt(checkNum);
        }
        catch (NumberFormatException e1){
                System.out.println("Ошибка: Для выбора пункта меню, введите № пункта меню.");
                return -1;
            }

    }

    private static void SearchNumberInPhoneBook() {
        System.out.println("Ищу номер");
    }

    private static void SearchContactInPhoneBook() {
        System.out.println("Ищу контакт");
    }

    private static void removeContactFromPhoneBook() {
        System.out.println("Удаляю контакт");
    }

    private static void addContactToPhoneBook() {
        System.out.println("Добавляем контакт");
    }

    private static void showPhoneBook() {
        System.out.println("Вывожу весь список");
    }
}
