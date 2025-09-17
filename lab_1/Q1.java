import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Quiz Marks: ");
        int quizMarks = scanner.nextInt();
        
        System.out.print("Enter Assignment Marks: ");
        int assignmentMarks = scanner.nextInt();
        
        System.out.print("Enter Mid-Term Marks: ");
        int midTermMarks = scanner.nextInt();
        
        System.out.print("Enter Final Marks: ");
        int finalMarks = scanner.nextInt();
        
        int totalMarks = quizMarks + assignmentMarks + midTermMarks + finalMarks;
        double average = (double) totalMarks;
        
        System.out.println("Total Marks = " + totalMarks);
        System.out.println("Average = " + average);
        
        if (average >= 85) {
            System.out.println("Grade = A");
        } else if (average >= 70) {
            System.out.println("Grade = B");
        } else if (average >= 50) {
            System.out.println("Grade = C");
        } else {
            System.out.println("Grade = Fail");
        }
        
        scanner.close();
    }
}
