import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter pizza size (small/medium/large): ");
        String pizzaSize = scanner.nextLine().toLowerCase();
        
        int basePrice = 0;
        switch (pizzaSize) {
            case "small":
                basePrice = 100;
                break;
            case "medium":
                basePrice = 200;
                break;
            case "large":
                basePrice = 300;
                break;
            default:
                System.out.println("Invalid pizza size! Please enter small, medium, or large.");
                scanner.close();
                return;
        }
        
        System.out.print("Do you want pepperoni? (yes/no): ");
        String pepperoniChoice = scanner.nextLine().toLowerCase();
        
        int pepperoniPrice = 0;
        if (pepperoniChoice.equals("yes")) {
            if (pizzaSize.equals("small")) {
                pepperoniPrice = 30;
            } else {
                pepperoniPrice = 50; 
            }
        }
        
        System.out.print("Do you want extra cheese? (yes/no): ");
        String cheeseChoice = scanner.nextLine().toLowerCase();
        
        int cheesePrice = 0;
        if (cheeseChoice.equals("yes")) {
            cheesePrice = 20; 
        }
        
        int finalBill = basePrice + pepperoniPrice + cheesePrice;
        
        System.out.println("Your final bill is: Rs." + finalBill);
        
        scanner.close();
    }
}
