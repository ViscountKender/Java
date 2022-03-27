package guess_the_number;

import java.util.Scanner;

public class guess_the_number {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ваша задача угадать число");
        int range = 100;
        int number =(int)(Math.random()* range);
        while (true) {
            System.out.println("Угадайте число от 0 " + range);
            int input_number = scanner.nextInt();
            if (input_number == number) {
                System.out.println("Вы угадали число");
                break;
            }
            else if (input_number > number)
            {
                System.out.println("Загаднное число меньше ");
            }
            else {
                System.out.println("Загаднное число больше ");

            }
        }
        scanner.close();

    }
}
