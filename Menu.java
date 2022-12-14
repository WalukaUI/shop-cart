import java.util.Scanner;

public class Menu {
    private String[] menuOptions = {"Exit", "List Products","Buy Product", "Find Product", "Show Cart" , "Checkout"};
    private Scanner scanner;
    private Shop shop;

    

//Constructor
    public Menu(Scanner scanner, Shop shop) {
       this.scanner = scanner;
       this.shop = shop;
    }

//Execute the menu
    public void executeMenu() {
        printMenu();
        int answer= getNextIntFromUser();

       while(answer != 0){
        if(answer == 1){
            shop.printProducts();
            printMenu();
        }else if(answer == 3){
            System.out.println("Enter the item to search for:");
            String itemToFind= getNextStringLineFromUser();
            int itemNum= shop.findProduct(itemToFind);
                if(itemNum == -1){
                  System.out.println("That product was not found.");
                }else{
                  System.out.println( itemToFind+" was found and its product id is "+itemNum);
                }
            printMenu();
        }else if(answer == 2){
            System.out.println("Please enter the ID of the product you would like to purchase:");
            int itemfromCustomer=getNextIntFromUser();
            shop.addToCart(itemfromCustomer);
            printMenu();
            
        }else if(answer == 4){
           shop.showCartDetails();  
           printMenu();
        }else if(answer == 5){
           shop.cartCheckout();
           printMenu();
        }else{
            printMenu();
        }
       answer= getNextIntFromUser();
        
       }
     exit();
    }
    

//Greet customer with name
    public void greet() {
        System.out.println("Hello. Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Welcome " + name + " to " + "T-Shirt Mart");
    }

//Print menu
    private void printMenu() {
        System.out.println();
        System.out.println("--Main Menu--");
        System.out.println("Select an option using one of the numbers shown");
        System.out.println();

        for (int i = 0; i < menuOptions.length; i++) {
            System.out.print(i + ": ");
            System.out.println(menuOptions[i]);
        }
    }

//* Prints an exit statement and closes the scanner object.

    private void exit() {
        System.out.println("Exiting now. Goodbye.");
        scanner.close();
    }

/**
* Collects next user-entered int.
* @return integer value denoting the user selection
*/
    private int getNextIntFromUser() {
        return scanner.nextInt();
    }

/**
* Skips a line of empty input from the scanner's input stream
* and then returns the next available line.
* @return string representing the line of input typed by the user
*/
    private String getNextStringLineFromUser() {
        scanner.nextLine();
        return scanner.nextLine();
    }
}
