import java.util.Scanner;

public class Menu {
    private String[] menuOptions = {"Exit", "List Products","Buy Product", "Find Product", "Show Cart" , "Checkout"};
    private Scanner scanner;
    private Shop shop;
    private Cart cart;
    


    public Menu(Scanner scanner, Shop shop,Cart cart) {
       this.scanner = scanner;
       this.shop = shop;
       this.cart=cart;
    }



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
                  String outp=String.format("The product %s was not found. ", itemToFind);
                  System.out.println(outp);
                }else{
                  System.out.println( itemToFind+" was found and its product id is "+itemNum);
                }
            printMenu();
        }else if(answer == 2){

            System.out.println("Please enter the ID of the product you would like to purchase:");
            int itemToFnd= getNextIntFromUser();
            Product recivedProduct=shop.findProductbyId(itemToFnd);
            if(recivedProduct == null){
                System.out.println("not found");
                printMenu();
            }else{
                cart.additem(recivedProduct);
                String last=String.format("has been added to your cart %d.",itemToFnd);
                System.out.println(last);
                printMenu();
            }
            
            
        }else if(answer == 4){
            cart.showDetails();
            printMenu();
        
        }else if(answer == 5){
            cart.checkout();
            break;
        }else{
            printMenu();
        }
        answer= getNextIntFromUser();
             

       }
       exit();
    }
    


    public void greet() {
        System.out.println("Hello. Please enter your name:");
        String name = scanner.nextLine();
        System.out.println("Welcome " + name + " to " + "T-Shirt Mart");
    }


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

    // /**
    //  * Prints an exit statement and closes the scanner object.
    //  */
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
