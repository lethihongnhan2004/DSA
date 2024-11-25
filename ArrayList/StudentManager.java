package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentManager {
    private ArrayList<Students> students; //
    private int nextId = 1; // ID tự động tăng bắt đầu từ 1

    public StudentManager() {
        students = new ArrayList<>(); // Khởi tạo ArrayList
    }

    // Kiểm tra tính hợp lệ của tên
    private boolean isValidName(String name) {
        return Pattern.matches("[a-zA-Z\\s]+", name);
    }

    public void add(String name, double marks) {
        if (!isValidName(name)) {
            System.out.println("Invalid name. Please use only" +
                    " letters and no numbers.");
            return;
        }
        String id = String.valueOf(nextId++);
        Students st = new Students(id, name, marks);
        students.add(st);
        System.out.println("Student added: " + st);
    }

    public void edit(String studentId, Scanner sc) {
        for (Students student : students) {
            if (student.getId().equals(studentId)) {
                // Hiển thị thông tin cũ
                System.out.println("Current information of the student:");
                System.out.println(student);

                // Nhập thông tin mới
                System.out.print("Enter new name (or press Enter to keep current): ");
                String newName = sc.nextLine();
                if (!newName.isEmpty()) {
                    if (!isValidName(newName)) {
                        System.out.println("Invalid name. Please use only letters and no numbers.");
                        return;
                    }
                    student.setName(newName);
                }

                System.out.print("Enter new marks (or -1 to keep current): ");
                double newMarks = sc.nextDouble();
                sc.nextLine(); // Consume newline
                if (newMarks >= 0) {
                    student.setMarks(newMarks);
                }

                System.out.println("Student updated: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void delete(String id) {
        for (Students student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Student deleted: " + student);
                students.remove(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void search(String query) {
        boolean found = false;
        for (Students student : students) {
            if (student.getId().equals(query) || student.getName().equalsIgnoreCase(query)) {
                System.out.println("Student found: " + student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with ID or Name: " + query);
        }
    }

    // Hàm sắp xếp nổi bọt để sắp xếp sinh viên dựa trên điểm
    public void BubbleStudents() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    Students temp = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, temp);
                }
            }
        }
        System.out.println("Students sorted by marks:");
        display();
    }

    public void selectionSortStudents() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (students.get(j).getMarks() < students.get(minIndex).getMarks()) {
                    minIndex = j;
                }
            }
            // Hoán đổi sinh viên tại vị trí i với sinh viên có điểm nhỏ nhất
            if (minIndex != i) {
                Students temp = students.get(i);
                students.set(i, students.get(minIndex));
                students.set(minIndex, temp);
            }
        }

        System.out.println("Students sorted by marks using Selection Sort:");
        display();
    }

    public void display() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
        } else {
            System.out.println("ID\tName\tMarks\tRank");
            for (Students student : students) {
                System.out.println(student.getId() + "\t" + student.getName() + "\t" + student.getMarks() + "\t" + student.getRank());
            }
        }
    }
}

