import java.util.ArrayList;

public class Shop{
    private ArrayList<Product> products;
    private String name;
    private Cart cart;

   public Shop(ArrayList<Product> products, Cart cart,String name)  {
         this.products = products;
         this.name=name;
         this.cart=cart;
   }

     public String getname(){
      return name;
   }

  //Print product list

   public void printProducts(){
    System.out.println("--Products--");
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
     

  //Find product by ID

     public void addToCart(int answer){
      boolean added=false;
      String ittName="";
      for(Product p : products){
      int idI=p.getID();
      if(idI == answer){
         added=true;
         cart.additem(p);
         ittName=p.getName();
       }
      }
     String ifAdded=String.format("%s has been added to your cart.",ittName);
     System.out.println(added?ifAdded:"That item ID is invalid and could not be added to the cart.");
    }

  //show details
         public void showCartDetails(){
          cart.showDetails();
         }
         public boolean cartCheckout(){
          return cart.checkout();
         }

}
