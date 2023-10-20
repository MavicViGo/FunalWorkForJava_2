import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("В данный момент база игрушек для розыгрыша - пуста!");
        System.out.println("================================================");
        System.out.print("Начать заполнение базы (y/n): ");

        String confirm = scanner.nextLine();
        if (confirm.equals("y")) {
            FillDataOfToys();
        }
        else if (confirm.equals("n")) {
            System.out.println("Работа программы завершена.");
            return;
        }
        else {
            System.out.println("Вы ввели не верный символ, повторите попытку");
        }

//
//        System.out.print("Введите наименование 1-й игрушки: ");
//        String testNameToy = scanner.nextLine();
//        System.out.print("Введите вероятность выпадения данной (от 1 до 100): ");
//        int testPercent = Integer.parseInt(scanner.nextLine());
    }
    static void FillDataOfToys(){
       String tempNameToy = null;
       int tempPercent = 0;
       int tempIdToy = 1;
       String tempToy = "toy";
       int remainder = 100;
       while (remainder > 0){
           Toy toy1 = new Toy();
           System.out.printf("Введите наименование %d-й игрушки: " ,tempIdToy);
           String testNameToy = scanner.nextLine();
           System.out.print("Введите вероятность выпадения данной (от 1 до 100): ");
           tempPercent = Integer.parseInt(scanner.nextLine());
           CheckPercent();

           toy1.nameToy = testNameToy;
           toy1.idToy = tempIdToy;
           toy1.weightToy = tempPercent / 10;

           remainder = ReminderPercent(tempPercent);
           System.out.println(remainder);
           System.out.println(toy1);
       }

    }
    static int ReminderPercent(int Percent){
        return (100 - Percent);
    }

    static void CheckPercent(){
        System.out.println("Проверка корректности, процента вероятности для игрушки");
    }
}
