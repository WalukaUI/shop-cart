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
        System.out.println("item added successfully");
        double pr=p.getPrice();
        total=total+pr;
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
    public void checkout(){

    if(total != 0){
        System.out.println("checked out");
        System.out.println(String.format("total is %.2f",total));
        System.out.println(String.format("total with tax is %.2f",total +(total * (taxRate/100))));
    }else{
        System.out.println("your cart is empty. Please add something to checked out");
    }
   
    }

}
