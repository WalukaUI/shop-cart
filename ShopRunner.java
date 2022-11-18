
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;

public class ShopRunner {
    

    public static void main(String[] args) {

        ArrayList<Product> product=new ArrayList<Product>(
                Arrays.asList(
                    new Product(0, "Crew Neck", 20.00),
                    new Product(1, "V-Neck", 20.00),
                    new Product(2, "Polo", 25.50),
                    new Product(3, "Boat Neck", 30.25),
                    new Product(4, "Tank Top", 15.75)
                )
            );
        Scanner catchInput = new Scanner(new InputStreamReader(System.in, Charset.forName("UTF-8")));
        Cart cart=new Cart();
        Shop shop =new Shop(product,cart,"T-Shirt Mart");
        Menu menu = new Menu(catchInput, shop);
        menu.greet();
        menu.executeMenu();
        

        //menu.formatPriceLine("https://labs.vocareum.com/main/main.php?m");


}
}

