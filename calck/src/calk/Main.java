package calk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите номер операции: ");
        System.out.println("1. Сложение ");
        System.out.println("2. Вычитание ");
        System.out.println("3. Умножение ");
        System.out.println("4. Деление ");
        Scanner scanner = new Scanner(System.in);
        int operation = scanner.nextInt();
        System.out.println("Ведите первое число");
        int a = scanner.nextInt();
        System.out.println("Ведите второе  число");
        int b = scanner.nextInt();
        System.out.println("Ведите номер операции");
        int result;
        if (operation == 1) {
            result = a + b;
        }
        else if (operation == 2 ) {

            result = a - b;
        }
        else if (operation == 3) {
            result = a * b;
        }
        else
        {
            result = a/b;
        }
        System.out.println("Результат = " + result);









    }
}
