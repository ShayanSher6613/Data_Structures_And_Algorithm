import java.util.Scanner;

public class Q4 {
    
    public static double area(double radius) {
        return 3.14159 * radius * radius;
    }
    
    public static double area(double length, double width) {
        return length * width;
    }
    
    public static double area(int side) {
        return side * side;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== AREA CALCULATOR ===");
        
        System.out.println("1. CIRCLE AREA");
        System.out.print("Enter radius: ");
        double radius = scanner.nextDouble();
        double circleArea = area(radius);
        System.out.println("Area of circle with radius " + radius + " = " + (circleArea * 100.0) / 100.0);
        System.out.println();
        
        System.out.println("2. RECTANGLE AREA");
        System.out.print("Enter length: ");
        double length = scanner.nextDouble();
        System.out.print("Enter width: ");
        double width = scanner.nextDouble();
        double rectangleArea = area(length, width);
        System.out.println("Area of rectangle with length " + length + " and width " + width + " = " +(rectangleArea * 100.0) / 100.0);
        System.out.println();
        
        System.out.println("3. SQUARE AREA");
        System.out.print("Enter side length (integer): ");
        int side = scanner.nextInt();
        double squareArea = area(side);
        System.out.println("Area of square with side " + side + " = " +(squareArea * 100.0) / 100.0);
        System.out.println();
        
        scanner.close();
    }
}
