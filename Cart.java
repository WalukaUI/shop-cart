import java.util.ArrayList;

public class Cart{
    private ArrayList<Product> items;
    private double total;
    private double taxRate = 10;

    public Cart() {
        this.items= new ArrayList<>();
    }

    public void additem(Product p){
        items.add(p);
        total = total + (p.getPrice());
    }
    
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
                String.format(
                    "%s: $%.2f%n",
                    "Pre-Tax Total",
                    total
                )
            );                 
                          
          detailsSb.append(
                String.format(
                    "%s (%.2f%% Tax): $%.2f%n",
                    "Post-Tax Total",
                    taxRate * 100,
                    total * (1 + taxRate)
                )
            );
         System.out.print(detailsSb);
                          
        }else{   
        System.out.println("The cart is empty. Please add at least one product to see it in the cart.");    
        }
        }
        
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
