//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.ArrayList;

// Student class to hold individual student details
class Student {
    String name;
    int id;
    int age;
    double grade;

    // Constructor
    public Student(String name, int id, int age, double grade) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.grade = grade;
    }

    // Method to update student details
    public void updateDetails(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    // Method to display student details
    @Override
    public String toString() {
        return "Student ID: " + id + "\nName: " + name + "\nAge: " + age + "\nGrade: " + grade;
    }
}

// StudentManagement class to handle student records
class StudentManagement {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static int totalStudents = 0;

    // Method to add a new student
    public static void addStudent(String name, int age, double grade) {
        int id = ++totalStudents;
        Student newStudent = new Student(name, id, age, grade);
        studentList.add(newStudent);
        System.out.println("Student added successfully with ID: " + id);
    }

    // Method to update student information
    public static void updateStudent(int id, String name, int age, double grade) {
        for (Student student : studentList) {
            if (student.id == id) {
                student.updateDetails(name, age, grade);
                System.out.println("Student information updated successfully.");
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    // Method to view student details
    public static void viewStudent(int id) {
        for (Student student : studentList) {
            if (student.id == id) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student ID not found.");
    }

    // Method to display all students
    public static void viewAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records available.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
                System.out.println("----------------------");
            }
        }
    }
}

// Main class to run the program
class StudentRecordManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Administrator Interface");
            System.out.println("1. Add New Student");
            System.out.println("2. Update Student Information");
            System.out.println("3. View Student Details");
            System.out.println("4. View All Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter student age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter student grade: ");
                    double grade = scanner.nextDouble();
                    StudentManagement.addStudent(name, age, grade);
                    break;
                case 2:
                    System.out.print("Enter student ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new student name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new student age: ");
                    int newAge = scanner.nextInt();
                    System.out.print("Enter new student grade: ");
                    double newGrade = scanner.nextDouble();
                    StudentManagement.updateStudent(updateId, newName, newAge, newGrade);
                    break;
                case 3:
                    System.out.print("Enter student ID to view: ");
                    int viewId = scanner.nextInt();
                    StudentManagement.viewStudent(viewId);
                    break;
                case 4:
                    StudentManagement.viewAllStudents();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting the system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}
