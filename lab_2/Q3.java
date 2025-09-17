import java.util.Scanner;

public class Q3 {
    
    public static int add(int a, int b) {
        return a + b;
    }
    public static int subtract(int a, int b) {
        return a - b;
    }
    public static long multiply(int a, int b) {
        return a * b;
    }
    public static double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero!");
            return 0.0;
        }
        return (double) a / b;
    }
    
    public static int maxOfThree(int a, int b, int c) {
        int max = a;
        
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        
        return max;
    }
    
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CALCULATOR PROGRAM ===");
        System.out.println("This program demonstrates various mathematical operations.");
        System.out.println();
        
        System.out.println("----ADDITION----");
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        int sum = add(num1, num2);
        System.out.println("Result: " + num1 + " + " + num2 + " = " + sum);
        System.out.println();
        
        System.out.println("----SUBTRACTION----");
        System.out.print("Enter first number: ");
        int sub1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int sub2 = scanner.nextInt();
        int difference = subtract(sub1, sub2);
        System.out.println("Result: " + sub1 + " - " + sub2 + " = " + difference);
        System.out.println();
        
        System.out.println("----MULTIPLICATION----");
        System.out.print("Enter first number: ");
        int mul1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int mul2 = scanner.nextInt();
        long product = multiply(mul1, mul2);
        System.out.println("Result: " + mul1 + " X " + mul2 + " = " + product);
        System.out.println();
        
        System.out.println("----DIVISION----");
        System.out.print("Enter first number (dividend): ");
        int div1 = scanner.nextInt();
        System.out.print("Enter second number (divisor): ");
        int div2 = scanner.nextInt();
        double quotient = divide(div1, div2);
        if (div2 != 0) {
            System.out.println("Result: " + div1 + " ÷ " + div2 + " = " + String.format("%.2f", quotient));
        }
        System.out.println();
        
        System.out.println("----MAXIMUM OF THREE NUMBERS----");
        System.out.print("Enter first number: ");
        int max1 = scanner.nextInt();
        System.out.print("Enter second number: ");
        int max2 = scanner.nextInt();
        System.out.print("Enter third number: ");
        int max3 = scanner.nextInt();
        int maximum = maxOfThree(max1, max2, max3);
        System.out.println("The maximum of " + max1 + ", " + max2 + ", and " + max3 + " is: " + maximum);
        System.out.println();
        
        System.out.println("----PRIME NUMBER CHECK----");
        System.out.print("Enter a number to check if it's prime: ");
        int primeNum = scanner.nextInt();
        boolean isPrimeResult = isPrime(primeNum);
        if (isPrimeResult) {
            System.out.println(primeNum + " is a PRIME number!");
        } else {
            System.out.println(primeNum + " is NOT a prime number.");
        }
        
        System.out.println();
        scanner.close();
    }
}
