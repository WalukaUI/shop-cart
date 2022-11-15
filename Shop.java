import java.util.ArrayList;

public class Shop{
    private ArrayList<Product> products;
    private String name;
    private Cart cart;

   public Shop(ArrayList<Product> products,String name)  {
         this.products = products;
         this.name=name;
   }

     public String getname(){
      return name;
   }
   
   //Print product list

   public void printProducts(){
     for (Product p : products) {
        System.out.println("ID "+(p.getID())+": "+(p.getName()) +" - $"+(p.getPrice()));
      }

   }
    //Find product by name

   public int findProduct(String searchText){
    for(Product p : products){
       String name=p.getName();
       if(name.equals(searchText)){
        return p.getID();
       }
     }              
     return -1;
   }

     //Find product by name

     public Product findProductbyId(int idNum){
            return 1;
     }
}
