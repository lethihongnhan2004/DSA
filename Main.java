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

                long startTime, endTime, duration; // Biến để lưu thời gian bắt đầu, kết thúc và độ trễ

                switch (choice) {
                    case 1:
                        // Đo thời gian cho việc thêm sinh viên
                        startTime = System.nanoTime();
                        String name;
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
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Time taken to add student: " + duration + " nanoseconds.");
                        break;

                    case 2:
                        // Đo thời gian cho việc sửa thông tin sinh viên
                        startTime = System.nanoTime();
                        System.out.print("Enter Student ID to edit: ");
                        String studentId = sc.nextLine();
                        manager.edit(studentId, sc);
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Time taken to edit student: " + duration + " nanoseconds.");
                        break;

                    case 3:
                        // Đo thời gian cho việc xóa sinh viên
                        startTime = System.nanoTime();
                        System.out.print("Enter Student ID to delete: ");
                        String id = sc.nextLine();
                        manager.delete(id);
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Time taken to delete student: " + duration + " nanoseconds.");
                        break;

                    case 4:
                        // Đo thời gian cho việc tìm kiếm sinh viên
                        startTime = System.nanoTime();
                        System.out.print("Enter Student ID or Name to search: ");
                        String query = sc.nextLine();
                        manager.search(query);
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Time taken to search student: " + duration + " nanoseconds.");
                        break;

                    case 5:
                        // Đo thời gian cho việc sắp xếp sinh viên (Bubble Sort)
                        startTime = System.nanoTime();
                        manager.bubbleSortStudents();
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Time taken for Bubble Sort: " + duration + " nanoseconds.");
                        break;

                    case 6:
                        // Đo thời gian cho việc sắp xếp sinh viên (Selection Sort)
                        startTime = System.nanoTime();
                        manager.selectionSortStudents();
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Time taken for Selection Sort: " + duration + " nanoseconds.");
                        break;

                    case 7:
                        // Đo thời gian cho việc hiển thị tất cả sinh viên
                        startTime = System.nanoTime();
                        manager.display();
                        endTime = System.nanoTime();
                        duration = endTime - startTime;
                        System.out.println("Time taken to display students: " + duration + " nanoseconds.");
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
