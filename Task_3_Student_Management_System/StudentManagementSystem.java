import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class StudentManagementSystem {

    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("\nStudent has been Added\n");
    }

    public void removeStudent(int rollNumber) {
        boolean removed = false;
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            if (student.getRollNumber() == rollNumber) {
                students.remove(i);
                removed = true;
                System.out.println("\nStudent has been Removed\n");
                break;
            }
        }
        if (!removed) {
            System.out.println("\nNo Student available with Roll Number: " + rollNumber + "\n");
        }
    }

    public void searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println("\nStudent Details Available\n");
                System.out.println("Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Department: " + student.getDept());
                return;
            }
        }
        System.out.println("\nNo Student available with Roll Number: " + rollNumber + "\n");
    }

    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("\nStudent Database is Empty");
        } else {
            System.out.println("\nStudent Database shows as follows :");
            for (Student student : students) {
                System.out.println("\n");
                System.out.println("Name: " + student.getName());
                System.out.println("Roll Number: " + student.getRollNumber());
                System.out.println("Department: " + student.getDept());
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("-----------------------------");
            System.out.println("\n1. Add New Student");
            System.out.println("2. Remove a Student");
            System.out.println("3. Find a Student");
            System.out.println("4. All Student Details");
            System.out.println("5. Exit Application");
            System.out.print("\nEnter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter Student Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Student Roll Number: ");
                    int rollNumber = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String grade = scanner.nextLine();

                    Student student = new Student(name, rollNumber, grade);
                    system.addStudent(student);
                    break;

                case 2:
                    System.out.print("Enter Roll Number of Student : ");
                    int removeRollNumber = scanner.nextInt();
                    scanner.nextLine();

                    system.removeStudent(removeRollNumber);
                    break;

                case 3:
                    System.out.print("Enter Roll Number of Student : ");
                    int searchRollNumber = scanner.nextInt();
                    scanner.nextLine();

                    system.searchStudent(searchRollNumber);
                    break;

                case 4:
                    system.displayAllStudents();
                    break;

                case 5:
                    System.out.println("\nThank You for using our Student Management System");
                    System.exit(0);

                default:
                    System.out.println("\nInvalid choice");
                    break;
            }
        }
    }
}


