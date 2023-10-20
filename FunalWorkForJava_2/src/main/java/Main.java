import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("В данный момент база игрушек для розыгрыша - пуста!");
        System.out.println("================================================");
        System.out.print("Начать заполнение базы (y/n): ");

        String confirm = scanner.nextLine();
        if (confirm.equals("y")) {
        //    FillDataOfToys();

                   int tempPercent;
       int tempIdToy = 1;
       int remainder = 100;
       Toy[] toys = new Toy[10];

       while (remainder > 0){
           toys[tempIdToy] = new Toy();
           System.out.printf("Введите наименование %d-й игрушки: " ,tempIdToy);
           String testNameToy = scanner.nextLine();
           System.out.print("Введите вероятность выпадения данной (от 1 до 100): ");
           tempPercent = Integer.parseInt(scanner.nextLine());
           CheckPercent(tempPercent, remainder);

           toys[tempIdToy].nameToy = testNameToy;
           toys[tempIdToy].idToy = tempIdToy;
           toys[tempIdToy].weightToy = tempPercent / 10;

           remainder = remainder - tempPercent;
           System.out.println(toys[tempIdToy].nameToy);
           tempIdToy++;

       }

       for (int i = 1; i < tempIdToy ;i++){
           System.out.println(toys[i].idToy + " - " + toys[i].weightToy + " - " + toys[i].nameToy);
       }





        }
        else if (confirm.equals("n")) {
            System.out.println("Работа программы завершена.");
            return;
        }
        else {
            System.out.println("Вы ввели не верный символ, повторите попытку");
        }


    }
//    static void FillDataOfToys(){
//       int tempPercent;
//       int tempIdToy = 1;
//       int remainder = 100;
//       Toy[] toys = new Toy[10];
//
//       while (remainder > 0){
//           toys[tempIdToy] = new Toy();
//           System.out.printf("Введите наименование %d-й игрушки: " ,tempIdToy);
//           String testNameToy = scanner.nextLine();
//           System.out.print("Введите вероятность выпадения данной (от 1 до 100): ");
//           tempPercent = Integer.parseInt(scanner.nextLine());
//           CheckPercent(tempPercent, remainder);
//
//           toys[tempIdToy].nameToy = testNameToy;
//           toys[tempIdToy].idToy = tempIdToy;
//           toys[tempIdToy].weightToy = tempPercent / 10;
//
//           remainder = remainder - tempPercent;
//          // System.out.println(toys);
//           tempIdToy++;
//
//       }
//    }

    static int CheckPercent(int percent, int remPercent){
        if ((remPercent - percent) < 0 ){
            System.out.println("Проверка корректности, процента вероятности для игрушки...");
            int toMach = remPercent - percent;
            int newPercent = percent + toMach;
            System.out.printf("Оставшийся процент вероятности для распрелеления - %d значение исправлено автоматически.", newPercent);
            return newPercent;
        }
        return percent;
    }
}
