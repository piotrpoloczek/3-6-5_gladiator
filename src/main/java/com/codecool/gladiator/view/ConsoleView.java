package com.codecool.gladiator.view;

import java.util.Scanner;

/**
 * Basic console view implementation
 */
public class ConsoleView implements Viewable {

    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void display(String text) {
        System.out.println(text);
    }

    @Override
    public int getNumberBetween(int min, int max) {
        while (true) {
            System.out.printf(
                    "Please provide the number between %s and %s",
                    min, max);

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice >= min && choice <= max) {
                return choice;
            }
            System.out.println("Invalid choice. Please try again.");
        }
    }
}
