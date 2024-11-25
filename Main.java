import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("\n1. Add a student");
            System.out.println("2. Edit a student");
            System.out.println("3. Delete a student");
            System.out.println("4. Search for a student");
            System.out.println("5. Sort students by marks (Bubble Sort)");
            System.out.println("6. Sort students by marks (Selection Sort)");
            System.out.println("7. Display all students");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            try {
                choice = sc.nextInt();

                // Kiểm tra nếu lựa chọn nằm ngoài khoảng 1-8
                if (choice < 1 || choice > 8) {
                    System.out.println("Invalid choice. Please select a number between 1 and 8.");
                    continue; // Yêu cầu nhập lại nếu không hợp lệ
                }

                sc.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        String name;
                        // Kiểm tra tính hợp lệ của tên
                        while (true) {
                            System.out.print("Enter Student Name: ");
                            name = sc.nextLine();
                            if (name.matches("[a-zA-Z\\s]+")) {
                                break;
                            } else {
                                System.out.println("Invalid name. Please use only letters and spaces, no numbers or special characters.");
                            }
                        }

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
                        manager.bubbleSortStudents();
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
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 8.");
                sc.nextLine(); // Clear the invalid input
            }
        } while (choice != 8);

        sc.close();
    }
}
