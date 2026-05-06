package com.student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if(choice == 1) {
                Student s = new Student();

                System.out.print("Enter name: ");
                s.setName(sc.nextLine());

                System.out.print("Enter email: ");
                s.setEmail(sc.nextLine());

                System.out.print("Enter course: ");
                s.setCourse(sc.nextLine());

                dao.addStudent(s);
            } 
            else if(choice == 2) {
                dao.viewStudents();
            } 
            else if(choice == 3) {
                System.out.println("Exiting...");
                break;
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }
}
