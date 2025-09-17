import java.util.Scanner;

public class Q6 {
    
    static int[] roll = new int[50];
    static String[] name = new String[50];
    static int[] marks = new int[50];
    static int studentCount = 0;
    
    public static void addStudent(int rollNum, String studentName, int studentMarks) {
        if (studentCount < 50) {
            roll[studentCount] = rollNum;
            name[studentCount] = studentName;
            marks[studentCount] = studentMarks;
            studentCount++;
            System.out.println("Student added successfully.");
        } else {
            System.out.println("Maximum capacity reached!");
        }
    }
    
    public static void displayAll() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
            return;
        }
        
        System.out.println("Roll\tName\t\tMarks\tGrade");
        for (int i = 0; i < studentCount; i++) {
            System.out.println(roll[i] + "\t" + name[i] + "\t\t" + marks[i] + "\t" + grade(marks[i]));
        }
        System.out.println("Total Students: " + studentCount);
    }
    
    public static void search(int rollNum) {
        for (int i = 0; i < studentCount; i++) {
            if (roll[i] == rollNum) {
                System.out.println("Found:");
                System.out.println("Roll: " + roll[i]);
                System.out.println("Name: " + name[i]);
                System.out.println("Marks: " + marks[i]);
                System.out.println("Grade: " + grade(marks[i]));
                return;
            }
        }
        System.out.println("No record found.");
    }
    
    public static void search(String studentName) {
        for (int i = 0; i < studentCount; i++) {
            if (name[i].equalsIgnoreCase(studentName)) {
                System.out.println("Found:");
                System.out.println("Roll: " + roll[i]);
                System.out.println("Name: " + name[i]);
                System.out.println("Marks: " + marks[i]);
                System.out.println("Grade: " + grade(marks[i]));
                return;
            }
        }
        System.out.println("No record found.");
    }
    
    public static double computeAverage(int[] marksArray, int count) {
        if (count == 0) return 0.0;
        
        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += marksArray[i];
        }
        return (double) sum / count;
    }
    
    public static char grade(int studentMarks) {
        if (studentMarks >= 85) {
            return 'A';
        } else if (studentMarks >= 70) {
            return 'B';
        } else if (studentMarks >= 50) {
            return 'C';
        } else {
            return 'F';
        }
    }
    
    public static void classAverageAndTopper() {
        if (studentCount == 0) {
            System.out.println("No students to analyze.");
            return;
        }
        
        System.out.println("==== Class Average & Topper ====");
        double average = computeAverage(marks, studentCount);
        System.out.println("Class Average: " + String.format("%.2f", average));
        
        int topperIndex = 0;
        for (int i = 1; i < studentCount; i++) {
            if (marks[i] > marks[topperIndex]) {
                topperIndex = i;
            }
        }
        
        System.out.println("Topper:");
        System.out.println("Roll: " + roll[topperIndex]);
        System.out.println("Name: " + name[topperIndex]);
        System.out.println("Marks: " + marks[topperIndex]);
        System.out.println("Grade: " + grade(marks[topperIndex]));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("==== Student Gradebook Manager ====");
            System.out.println("1) Add Student");
            System.out.println("2) Display All");
            System.out.println("3) Search Student (by Roll / by Name)");
            System.out.println("4) Class Average & Topper");
            System.out.println("5) Exit");
            System.out.print("Choice: ");
            int choice = scanner.nextInt();
            
            if (choice == 1) {
                System.out.print("Enter Roll: ");
                int rollNum = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter Name: ");
                String studentName = scanner.nextLine();
                
                int studentMarks;
                while (true) {
                    System.out.print("Enter Marks (0-100): ");
                    studentMarks = scanner.nextInt();
                    if (studentMarks >= 0 && studentMarks <= 100) {
                        break;
                    } else {
                        System.out.println("Invalid marks! Please enter a value between 0 and 100.");
                        continue;
                    }
                }
                addStudent(rollNum, studentName, studentMarks);
                
            } else if (choice == 2) {
                displayAll();
                
            } else if (choice == 3) {
                System.out.println("Search by: 1) Roll 2) Name");
                int searchChoice = scanner.nextInt();
                
                if (searchChoice == 1) {
                    System.out.print("Enter Roll to search: ");
                    int searchRoll = scanner.nextInt();
                    search(searchRoll);
                } else if (searchChoice == 2) {
                    scanner.nextLine();
                    System.out.print("Enter Name to search: ");
                    String searchName = scanner.nextLine();
                    search(searchName);
                } else {
                    System.out.println("Invalid search option!");
                }
                
            } else if (choice == 4) {
                classAverageAndTopper();
                
            } else if (choice == 5) {
                System.out.println("Goodbye!");
                break;
                
            } else {
                System.out.println("Invalid choice! Please try again.");
                continue;
            }
        }
        
        scanner.close();
    }
}
