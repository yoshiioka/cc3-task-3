import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Repository repo = new Repository();
        Scanner sc = new Scanner(System.in);

        // Asking how many students to add
        System.out.print("How many students would you like to add? ");
        int count = sc.nextInt();
        sc.nextLine(); // Consume the leftover newline

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Entering Details for Student #" + (i + 1) + " ---");

            // Using the Builder Pattern from the Student class [cite: 32, 60]
            Student.Builder builder = new Student.Builder();

            System.out.print("Surname: ");
            builder.setSurname(sc.nextLine());

            System.out.print("First Name: ");
            builder.setFirstName(sc.nextLine());

            System.out.print("Middle Name: ");
            builder.setMiddleName(sc.nextLine());

            System.out.print("Age: ");
            builder.setAge(sc.nextInt());
            sc.nextLine(); // Clear buffer

            System.out.print("Gender: ");
            builder.setGender(sc.nextLine());

            System.out.print("Birth Month: ");
            builder.setBirthMonth(sc.nextLine());

            System.out.print("Birth Year: ");
            builder.setBirthYear(sc.nextInt());
            sc.nextLine(); // Clear buffer

            System.out.print("Student ID No: ");
            builder.setStudentID(sc.nextInt());
            sc.nextLine(); // Clear buffer

            System.out.print("Course: ");
            builder.setCourse(sc.nextLine());

            System.out.print("Year Level: ");
            builder.setYear(sc.nextInt());
            sc.nextLine(); // Clear buffer

            // Save the Student Object to the database via Repository [cite: 7, 57]
            repo.save(builder.build());
        }

        // Generating the master list of all students 
        List<Student> allStudents = repo.findAll();

        System.out.println("\n========================================================");
        System.out.println("                STUDENT MASTER LIST");
        System.out.println("========================================================");
        System.out.printf("%-12s | %-15s | %-15s | %-10s%n", "ID", "SURNAME", "FIRSTNAME", "COURSE");
        System.out.println("--------------------------------------------------------");

        for (Student s : allStudents) {
            // Accessing data via Getters defined in the Student class [cite: 18, 19, 30]
            System.out.printf("%-12d | %-15s | %-15s | %-10s%n",
                    s.getStudentId(), s.getSurname(), s.getFirstName(), s.getCourse());
        }
    }
}
