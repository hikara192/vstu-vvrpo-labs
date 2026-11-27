package com.github.stokito.unitTestExample.calculator;

import java.util.Scanner;

/**
 * Консольная точка входа для запуска собранного jar-файла.
 */
public final class App {

    private App() {
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Первое число: ");
            int a = scanner.nextInt();
            System.out.print("Операция (+ - * /): ");
            String operation = scanner.next();
            System.out.print("Второе число: ");
            int b = scanner.nextInt();

            int result;
            switch (operation) {
                case "+":
                    result = calculator.sum(a, b);
                    break;
                case "-":
                    result = calculator.minus(a, b);
                    break;
                case "*":
                    result = calculator.multiply(a, b);
                    break;
                case "/":
                    result = calculator.divide(a, b);
                    break;
                default:
                    throw new IllegalArgumentException("Неизвестная операция: " + operation);
            }
            System.out.println("Результат: " + result);
        }
    }
}
