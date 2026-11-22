import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

class Student {
    int id;
    String name;
    int mark;

    Student(int id, String name, int mark) {
        this.id = id;
        this.name = name;
        this.mark = mark;
    }
}

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        try {
            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Mark: ");
            int mark = sc.nextInt();

            students.add(new Student(id, name, mark));
            System.out.println("Student Added Successfully!");
        } catch (Exception e) {
            System.out.println("Invalid Input!");
            sc.nextLine();
        }
    }

    static void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No Student Records Found!");
        } else {
            for (Student s : students) {
                System.out.println("ID: " + s.id);
                System.out.println("Name: " + s.name);
                System.out.println("Mark: " + s.mark);
                System.out.println("----------------");
            }
        }
    }

    static void searchStudent() {
        System.out.print("Enter Student ID to Search: ");
        int id = sc.nextInt();
        for (Student s : students) {
            if (s.id == id) {
                System.out.println("Student Found!");
                System.out.println("Name: " + s.name);
                System.out.println("Mark: " + s.mark);
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    static void updateStudent() {
        System.out.print("Enter Student ID to Update: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (Student s : students) {
            if (s.id == id) {
                System.out.print("Enter New Name: ");
                s.name = sc.nextLine();
                System.out.print("Enter New Mark: ");
                s.mark = sc.nextInt();
                System.out.println("Student Updated Successfully!");
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).id == id) {
                students.remove(i);
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }
        System.out.println("Student Not Found!");
    }

    static void saveStudents() {
        try (PrintWriter writer = new PrintWriter("students.txt")) {
            for (Student s : students) {
                writer.println(s.id + "," + s.name + "," + s.mark);
            }
            System.out.println("Records Saved Successfully!");
        } catch (IOException e) {
            System.out.println("Error Saving File!");
        }
    }

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Save Records");
            System.out.println("7. Exit");
            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: viewStudents(); break;
                case 3: searchStudent(); break;
                case 4: updateStudent(); break;
                case 5: deleteStudent(); break;
                case 6: saveStudents(); break;
                case 7: System.out.println("Thank You!"); break;
                default: System.out.println("Invalid Choice!");
            }
        } while (choice != 7);
    }
}
