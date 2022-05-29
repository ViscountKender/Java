package guess_the_number;

import java.util.Scanner;

public class guess_the_number {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Ваша задача угадать число");
        for (int i = 10; i <= 30; i += 10) playlevel(i);
        System.out.println("Вы выиграли!!!");
        scanner.close();

    }

    private static void  playlevel (int range){
        int number = (int) (Math.random() * range);
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

    }
}
