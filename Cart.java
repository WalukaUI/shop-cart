import java.util.ArrayList;

public class Cart{
    private ArrayList<Product> items;
    private double total;
    private double taxRate;

    public Cart() {
    }

    public void additem(Product p){
        
        items.add(p);
        System.out.println("item added successfully");
    }
    
    public void showDetails(){
    if(items.size() > 0){

        for (Product i : items) {
            System.out.println(i);
        }
    }

    }
    public boolean checkout(){
    if(total != 0){
        return true;
    }else{
        return false;
    }
   
    }

}
