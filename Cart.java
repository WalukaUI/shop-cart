import java.util.ArrayList;

public class Cart{
    private ArrayList<Product> items;
    private double total;
    private double taxRate = 0.1;

    public Cart() {
        this.items= new ArrayList<>();
    }
//Add items to cart
    public void additem(Product p){
        items.add(p);
        total = total + (p.getPrice());
    }
//Show cart details   
    public void showDetails(){
        StringBuilder detailsSb = new StringBuilder();
        int count=items.size();
            if(count > 0){
           detailsSb.append(String.format("--Cart--%n"));
           detailsSb.append(String.format("Item Count: %d%n", items.size()));
           detailsSb.append(String.format("Items:%n"));
      
        for(Product p : items){
        detailsSb.append(
                    String.format(
                        "%s: $%.2f%n",
                        p.getName(),
                        p.getPrice()
                    )
                );
        } 
         detailsSb.append(String.format("%n"));
           
         detailsSb.append(
                String.format("Pre-Tax Total: $%.2f%n",total));                 
                          
          detailsSb.append(
                String.format(
                    "Post-Tax Total (%.2f%% Tax): $%.2f%n",
                    taxRate * 100,
                    total * (1 + taxRate)
                )
            );
         System.out.print(detailsSb);
                          
        }else{   
        System.out.println("The cart is empty. Please add at least one product to see it in the cart.");    
        }
        }

//Checkout cart
        public boolean checkout(){
            int count=items.size();    
                if(count > 0){
            System.out.println(String.format("Your total is $%.2f",total+(total * (taxRate/100)) ));  
            System.out.println("Thank you for shopping at T-Shirt Mart.");
            items.removeAll(items);
            return true;
                }else{
                   System.out.println("Your cart is currently empty. Please add at least one product to check out.");
                   return false;
                }
            }

}
