
import java.util.*;

class Student {
    int id;
    String name;
    String course;
    double marks;

    Student(int id, String name, String course, double marks) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.marks = marks;
    }

    void display() {
        System.out.println(id + " | " + name + " | " +
                           course + " | " + marks);
    }
}

public class CollegeManagement {

    static ArrayList<Student> students = new ArrayList<>();
    static HashMap<Integer, Student> studentMap = new HashMap<>();
    static LinkedList<String> courses = new LinkedList<>();

    static Scanner sc = new Scanner(System.in);

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (studentMap.containsKey(id)) {
            System.out.println("Student ID already exists!");
            return;
        }

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, course, marks);

        students.add(s);
        studentMap.put(id, s);

        System.out.println("Student Added Successfully!");
    }

    static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\nID | Name | Course | Marks");

        for (Student s : students) {
            s.display();
        }
    }

    static void searchStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = studentMap.get(id);

        if (s != null) {
            System.out.println("Student Found:");
            s.display();
        } else {
            System.out.println("Student Not Found!");
        }
    }

    static void deleteStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = studentMap.remove(id);

        if (s != null) {
            students.remove(s);
            System.out.println("Student Deleted Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }

    static void updateStudent() {
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student s = studentMap.get(id);

        if (s != null) {
            System.out.print("Enter New Name: ");
            s.name = sc.nextLine();

            System.out.print("Enter New Course: ");
            s.course = sc.nextLine();

            System.out.print("Enter New Marks: ");
            s.marks = sc.nextDouble();

            System.out.println("Student Updated Successfully!");
        } else {
            System.out.println("Student Not Found!");
        }
    }

    static void sortStudents() {
        students.sort((a, b) ->
            Double.compare(b.marks, a.marks));

        System.out.println("Students Sorted By Marks:");
        displayStudents();
    }

    static void addCourse() {
        sc.nextLine();
        System.out.print("Enter Course Name: ");
        String course = sc.nextLine();

        courses.add(course);

        System.out.println("Course Added Successfully!");
    }

    static void displayCourses() {
        System.out.println("\nAvailable Courses:");

        for (String course : courses) {
            System.out.println(course);
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== COLLEGE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Sort Students By Marks");
            System.out.println("7. Add Course");
            System.out.println("8. Display Courses");
            System.out.println("9. Exit");

            System.out.print("Enter Your Choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    updateStudent();
                    break;

                case 5:
                    deleteStudent();
                    break;

                case 6:
                    sortStudents();
                    break;

                case 7:
                    addCourse();
                    break;

                case 8:
                    displayCourses();
                    break;

                case 9:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 9);
    }
}
