import java.util.ArrayList;

public class Cart{
    private ArrayList<Product> items;
    private double total;
    private double taxRate;

    public Cart() {
        this.items= new ArrayList<>();
    }

    public void additem(Product p){
        
        items.add(p);
        System.out.println("item added successfully");
    }
    
    public void showDetails(){
    if(items.size() > 0){

        for (Product i : items) {
            int idnum=i.getID();
            String nm=i.getName();
            double pr=i.getPrice();
            String newS=String.format("Item ID %d name %s unit price %.2f",idnum,nm,pr);
            System.out.println(newS);
        }
    }else{
        System.out.println("The cart is empty. " +
        "Please add at least one product to see it in the cart.");
    }

    }
    public boolean checkout(){
        System.out.println("checked out");
    if(total != 0){
        return true;
    }else{
        return false;
    }
   
    }

}
