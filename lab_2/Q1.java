import java.util.Scanner;
public class Q1{
    public static void main(String[] args){
        String size;
        int basePrice = 0;
        int totalPrice = 0;
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Enter pizza size : ");
            size = input.nextLine();
            if(size.equals("small")){
                basePrice = 100;
                break;
            }
            if(size.equals("medium")){
                basePrice = 200;
                break;
            }
            if(size.equals("large")){
                basePrice = 300;
                break;
            }
            else{
                System.out.println("Invalid input....Enter(small, medium, large)");
            }
        }
        totalPrice = basePrice;

        while(true){
            System.out.println("Do you want pepparoni? (yes/no)");
            String pepparoni = input.nextLine();
            if(pepparoni.equals("small")){
                totalPrice += 30;
                break;
            }
            if(pepparoni.equals("medium") || pepparoni.equals("large"))
            {
                totalPrice += 50;
                break;
            }
            else{
                break;
            }
        }

        while(true){
            System.out.println("Do you want extra cheese? (yes/no)");
            String extraCheese = input.nextLine();
            if(extraCheese.equals("yes")){
                totalPrice += 20;
                break;
            }
            if(extraCheese.equals("no")){
                totalPrice += 0;
                break;
            }
            
        }

        System.out.println("=======Final Bill=======");
        System.out.println("Total Price : Rs." + totalPrice);
        input.close();
    }
}