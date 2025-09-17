import java.util.Scanner;

public class Q5 {
    
    static int balance = 0;
    static final int correctPIN = 1234;
    
    public static void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
        } else {
            System.out.println("Invalid amount! Try again.");
        }
    }
    
    public static void withdraw(int amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful.");
            } else {
                System.out.println("Insufficient balance!");
            }
        } else {
            System.out.println("Invalid amount! Try again.");
        }
    }
    
    public static void checkBalance() {
        System.out.println("Your balance is: " + balance);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loginSuccessful = false;
        
        for (int attempts = 3; attempts > 0; attempts--) {
            System.out.print("Enter PIN: ");
            int enteredPin = scanner.nextInt();
            
            if (enteredPin == correctPIN) {
                System.out.println("Login successful!");
                loginSuccessful = true;
                break;
            } else {
                if (attempts > 1) {
                    System.out.println("Wrong PIN! Attempts left: " + (attempts - 1));
                } else {
                    System.out.println("Account locked! Too many failed attempts.");
                }
            }
        }
        
        if (loginSuccessful) {
            while (true) {
                System.out.println("==== ATM Menu ====");
                System.out.println("1) Deposit");
                System.out.println("2) Withdraw");
                System.out.println("3) Check Balance");
                System.out.println("4) Exit");
                System.out.print("Choice: ");
                int choice = scanner.nextInt();
                
                if (choice == 1) {
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = scanner.nextInt();
                    deposit(depositAmount);
                } else if (choice == 2) {
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = scanner.nextInt();
                    withdraw(withdrawAmount);
                } else if (choice == 3) {
                    checkBalance();
                } else if (choice == 4) {
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                } else {
                    System.out.println("Invalid choice! Please try again.");
                    continue;
                }
            }
        }
        
        scanner.close();
    }
}
