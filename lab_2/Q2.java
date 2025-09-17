import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] numbers = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        
        int sum = 0;
        int min = numbers[0];
        int max = numbers[0];
        int evenCount = 0;
        int oddCount = 0;
        
        for (int i = 0; i < n; i++) {
            sum += numbers[i];
            
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            
            if (numbers[i] % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }
        
        double average = (double) sum / n;
        
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + String.format("%.2f", average));
        System.out.println("Minimum: " + min);
        System.out.println("Maximum: " + max);
        System.out.println("Count of even numbers: " + evenCount);
        System.out.println("Count of odd numbers: " + oddCount);
        System.out.println("\n");
        
        System.out.println("\nArray in reverse:");
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
            if (i > 0) {
                System.out.print(", ");
            }
        }
        System.out.println();
        
        scanner.close();
    }
}
