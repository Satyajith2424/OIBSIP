package com.oasis.exam;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ExamService exam = new ExamService();

        System.out.println("===== ONLINE EXAMINATION SYSTEM =====");

        System.out.print("Enter User ID: ");
        String userId = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if (!exam.login(userId, password)) {
            System.out.println("Invalid Credentials!");
            sc.close();
            return;
        }

        System.out.println("Login Successful!");

        int choice;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Start Exam");
            System.out.println("2. Update Password");
            System.out.println("3. Logout");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                int score = exam.startExam(sc);

                
                System.out.println("Your Score: "
                        + score + "/"
                        + exam.getQuestions().size());

                break;

            case 2:
                System.out.print("Enter new password: ");
                sc.nextLine();
                String newPassword = sc.nextLine();

                exam.updatePassword(newPassword);
                break;

            case 3:
                System.out.println("Logged out successfully.");
                break;

            default:
                System.out.println("Invalid choice.");
            }

        } while (choice != 3);

        sc.close();
    }
}