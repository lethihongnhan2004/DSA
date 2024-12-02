import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StudentManager {
    private LinkedList<Students> students;
    private int nextId = 1; // ID tự động tăng bắt đầu từ 1

    public StudentManager() {
        students = new LinkedList<>();
    }

    // Kiểm tra tính hợp lệ của tên
    private boolean isValidName(String name) {
        return Pattern.matches("[a-zA-Z\\s]+", name);
    }

    public void add(String name, double marks) {
        try {
            if (!isValidName(name)) {
                System.out.println("Invalid name. Please use only letters and no numbers.");
                return;
            }
            if (marks > 10) {
                System.out.println("Error: Marks cannot be greater than 10.");
                return;
            }
            String id = String.valueOf(nextId++);
            Students st = new Students(id, name, marks);
            students.add(st);
            System.out.println("Student added: " + st);
        } catch (Exception e) {
            System.out.println("Error adding student: " + e.getMessage());
        }
    }

    public void edit(String studentId, Scanner sc) {
        try {
            for (Students student : students) {
                if (student.getId().equals(studentId)) {
                    System.out.println("Current information of the student:");
                    System.out.println(student);
                    String newName;
                    while (true) {
                        System.out.print("Enter new name (or press Enter to keep current): ");
                        newName = sc.nextLine();
                        if (newName.isEmpty() || isValidName(newName)) {
                            break;
                        } else {
                            System.out.println("Invalid name. Please use only letters and spaces, no numbers or special characters.");
                        }
                    }
                    if (!newName.isEmpty()) {
                        student.setName(newName);
                    }
                    double newMarks;
                    while (true) {
                        System.out.print("Enter new marks (or -1 to keep current): ");
                        try {
                            newMarks = sc.nextDouble();
                            sc.nextLine(); // Consume newline
                            if (newMarks == -1) {
                                break; // Giữ nguyên điểm hiện tại
                            } else if (newMarks >= 0 && newMarks <= 10) {
                                student.setMarks(newMarks);
                                break; // Cập nhật điểm và thoát khỏi vòng lặp
                            } else {
                                System.out.println("Invalid marks. Please enter a number between 0 and 10, or -1 to keep current.");
                            }
                        } catch (Exception e) {
                            System.out.println("Invalid input. Please enter a numeric value.");
                            sc.nextLine(); // Clear the invalid input
                        }
                    }
                    System.out.println("Student updated: " + student);
                    return;
                }
            }
            System.out.println("Student not found.");
        } catch (Exception e) {
            System.out.println("Error editing student: " + e.getMessage());
            sc.nextLine(); // Clear invalid input if any
        }
    }

    public void delete(String id) {
        try {
            for (Students student : students) {
                if (student.getId().equals(id)) {
                    System.out.println("Student deleted: " + student);
                    students.remove(student);
                    return;
                }
            }
            System.out.println("Student not found.");
        } catch (Exception e) {
            System.out.println("Error deleting student: " + e.getMessage());
        }
    }

    public void search(String query) {
        try {
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
        } catch (Exception e) {
            System.out.println("Error searching for student: " + e.getMessage());
        }
    }

    public void bubbleSortStudents() {
        try {
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
            System.out.println("Students sorted by marks using Bubble Sort:");
            display();
        } catch (Exception e) {
            System.out.println("Error sorting students by Bubble Sort: " + e.getMessage());
        }
    }

    public void selectionSortStudents() {
        try {
            int n = students.size();
            for (int i = 0; i < n - 1; i++) {
                int minIndex = i;
                for (int j = i + 1; j < n; j++) {
                    if (students.get(j).getMarks() < students.get(minIndex).getMarks()) {
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    Students temp = students.get(i);
                    students.set(i, students.get(minIndex));
                    students.set(minIndex, temp);
                }
            }

            System.out.println("Students sorted by marks using Selection Sort:");
            display();
        } catch (Exception e) {
            System.out.println("Error sorting students by Selection Sort: " + e.getMessage());
        }
    }

    public void display() {
        try {
            if (students.isEmpty()) {
                System.out.println("No students to display.");
            } else {
                System.out.println("ID\tName\tMarks\tRank");
                for (Students student : students) {
                    System.out.println(student.getId() + "\t" + student.getName() + "\t"
                            + student.getMarks() + "\t" + student.getRank());
                }
            }
        } catch (Exception e) {
            System.out.println("Error displaying students: " + e.getMessage());
        }
    }

}
