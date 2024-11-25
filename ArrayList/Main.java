package ArrayList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager(); // Loại bỏ "ArrayList." vì đã nằm trong cùng package
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add a student");
            System.out.println("2. Edit a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Search for a student");
            System.out.println("5. Sort students by marks using Bubble Sort");
            System.out.println("6. Sort students by marks using Selection Sort");
            System.out.println("7. Display all students");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Student Marks: ");
                    double marks = sc.nextDouble();
                    sc.nextLine(); // Consume newline
                    manager.add(name, marks);
                    break;
                case 2:
                    System.out.print("Enter Student ID to edit: ");
                    String studentId = sc.nextLine();
                    manager.edit(studentId, sc);
                    break;
                case 3:
                    System.out.print("Enter Student ID to delete: ");
                    String id = sc.nextLine();
                    manager.delete(id);
                    break;
                case 4:
                    System.out.print("Enter Student ID or Name to search: ");
                    String query = sc.nextLine();
                    manager.search(query);
                    break;
                case 5:
                    manager.BubbleStudents();
                    break;
                case 6:
                    manager.selectionSortStudents();
                    break;
                case 7:
                    manager.display();
                    break;
                case 8:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        } while (choice != 8);

        sc.close();
    }
}
