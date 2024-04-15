import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

class gradetracker {
    private String name;
    private String regno;
    private int[] marks;

    public void setName(String name) {
        this.name = name;
    }

    public void setRegno(String regno) {
        this.regno = regno;
    }

    public void setMarks(int[] marks) {
        this.marks = marks;
    }

    public String getRegno() {
        return regno;
    }

    public int[] getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public char[] calculateGrades() {
        char[] grades = new char[marks.length];
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] >= 91) {
                grades[i] = 'A';
            } else if (marks[i] >= 81) {
                grades[i] = 'B';
            } else if (marks[i] >= 71) {
                grades[i] = 'C';
            } else if (marks[i] >= 61) {
                grades[i] = 'D';
            } else if (marks[i] >= 51) {
                grades[i] = 'E';
            } else {
                grades[i] = 'F';
            }
        }
        return grades;
    }

    public float calculateAverage() {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (float) sum / marks.length;
    }

    public int findMin() {
        return Arrays.stream(marks).min().orElse(0);
    }

    public int findMax() {
        return Arrays.stream(marks).max().orElse(0);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--------Welcome to AK Student tracker Application---------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter total students:");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline character
        gradetracker[] students = new gradetracker[n];
        for (int i = 0; i < n; i++) {
            students[i] = new gradetracker(); // Initialize each object
            System.out.println("Enter name of student " + (i + 1) + ": ");
            String name = sc.nextLine();
            students[i].setName(name);
            System.out.println("Enter regno: ");
            String regno = sc.nextLine();
            students[i].setRegno(regno);
            System.out.println("Enter student Eight subject marks:");
            int[] marks = new int[8];
            for (int j = 0; j < 8; j++) {
                marks[j] = sc.nextInt();
            }
            students[i].setMarks(marks);
            sc.nextLine(); // Consume newline character
        }

        // Search for a student by registration number
        System.out.println("-------Now track student grade and compute their averages-------");
        System.out.println("Enter the student register number to get student details:");
        String reg = sc.next();
        boolean found = false;
        for (gradetracker student : students) {
            if (Objects.equals(reg, student.getRegno())) {
                found = true;
                System.out.println("*******************************************************************************");
                System.out.println("Student details based on Reg number-" + student.getRegno() + ":");
                System.out.println("Student name: " + student.getName());
                System.out.println("Student marks: " + Arrays.toString(student.getMarks()));
                System.out.println("Student grades: " + Arrays.toString(student.calculateGrades()));
                System.out.println("Student average marks: " + student.calculateAverage());
                System.out.println("Student lowest score: " + student.findMin());
                System.out.println("Student highest score: " + student.findMax());
                System.out.println("*******************************************************************************");
                break;
            }
        }
        if (!found) {
            System.out.println("Student with register  number " + reg + " not found.");
        }
    }
}
