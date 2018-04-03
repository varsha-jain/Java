/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
/**
 *
 * @author varsha
 */
public class ProductCatalog {
  private ArrayList<Product> product;
  private  ArrayList<Product> prod;
  

    /*public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }*/
  
    public ProductCatalog() {
        this.product= new ArrayList<Product>();
        
    }

    

    public ArrayList<Product> getProduct() {
        return product;
    }

    public void setProduct(ArrayList<Product> product) {
        this.product = product;
    }
   public Product addProduct()
   {
      Product p = new Product();
      
      product.add(p);
      return p;
      
   }
   /*public ArrayList<Product> addProductList()
   {
       productList = new ArrayList<Product>();
       //Product p=new Product();
       Vendor v= new Vendor();
       for(Product p : product)
       {
          if(p.getVendorName().equalsIgnoreCase(v.getVendorName()))
            {
                productList.add(p);
            }
               
         }
       return productList;
   }*/
   
   public void removeProduct(Product p)
   {
      product.remove(p);
   }

    public  ArrayList<Product> getProd() {
        return prod;
    }

    public  void setProd(ArrayList<Product> prod) {
        this.prod = prod;
    }
   
   public ArrayList<Product> searchByName(String productName)
    {
        prod = new ArrayList<Product>();
       for(Product p: product)
       {
          if(p.getProdName().toLowerCase().contains(productName.toLowerCase()))
            {
                prod.add(p);
            }
               
         }
        return prod;
    }
   
   public ArrayList<Product> searchByModelNumber(String modelNumber)
    {
        prod = new ArrayList<Product>();
        for(Product p: product)
        {
            if(p.getModelNumber().toLowerCase().contains(modelNumber.toLowerCase()))
            {
                 prod.add(p);
            }
        }
        return prod;
    }
   public ArrayList<Product> searchByVendorName(String vendorName)
    {
        prod = new ArrayList<Product>();
        for(Product p: product)
        {
            if(p.getVendorName().toLowerCase().contains(vendorName.toLowerCase()))
            {
                prod.add(p);
            }
        }
      return prod;
    }
   public ArrayList<Product> searchByKeyword(String keyword)
    {
          prod = new ArrayList<Product>();   
         for(Product p: product)
        {
            
            if(p.getProdDesc().toLowerCase().contains(keyword.toLowerCase()))
            {
                prod.add(p);
            }
        }
      return prod;
    }
   public ArrayList<Product> searchByFeature(String feature)
    {
          prod = new ArrayList<Product>();   
         for(Product p: product)
        {
            
            if(p.getProdFeature().toLowerCase().contains(feature.toLowerCase()))
            {
                prod.add(p);
            }
        }
      return prod;
    }
   public ArrayList<Product> others(String combination)
   {
       prod = new ArrayList<Product>();   
        /* for(Product p: product)
        {
            
            if(p.getProdFeature().toLowerCase().contains(combination.toLowerCase())
                    ||p.getModelNumber().toLowerCase().contains(combination.toLowerCase())
                    ||p.getProdDesc().toLowerCase().contains(combination.toLowerCase())
                    ||p.getProdName().toLowerCase().contains(combination.toLowerCase())
                    ||p.getVendorName().toLowerCase().contains(combination.toLowerCase()
                    ))
            {
                prod.add(p);
            }
        }*/
        
        String[] result = combination.split(" ");
        for(Product p : product){
            int counter=0;
             for(int j=0; j<result.length;j++)
             {
                 if(p.getProdName().equalsIgnoreCase(result[j]))
                     counter++;
                 if(p.getVendorName().equalsIgnoreCase(result[j]))
                     counter++;
                 if(p.getModelNumber().equalsIgnoreCase(result[j]))
                     counter++;
                 
            }
           if(counter == result.length)
             {
                 prod.add(p);
             }  
        }
        return prod;
   }
   /*public Product searchByLowestPrice()
    {
       try
       {
           Product minPrice = Collections.min(product, new ProdCompare());
       
        return minPrice;
       }catch(Exception e)
       {
           return null;
       }
    }*/
   
   public ArrayList<Product> searchByLowestPrice()
   {
       int n=0;
       int i=-1;
       int retVal=-1;
       prod = new ArrayList<Product>();
      try{
      Double min = product.get(0).getBasePrice();
         for(Product p : product)
         {
             ++i;
             if(  p.getBasePrice()<min)
             {
                 min = p.getBasePrice();
                 n=i;
             //prod.add(product.get(i));
             }
           
         }
            if(n==0)
            {
                Double newmin = min;
               for(Product p1 : product)
             {
                 System.out.println(p1.getBasePrice());
                 System.out.println(min);
                 Double newP = p1.getBasePrice();
                 System.out.println(newP);
           if(newP == newmin)
           {
               prod.add(p1);
           }
             }
        }
            else
            {
                Product p11= product.get(n);
                prod.add(p11);
            }
      }catch(Exception e)
      {
          JOptionPane.showMessageDialog(null,"No data found");
      }
             
           /*  retVal = Double.compare(min,p.getBasePrice());
                   if(retVal>0)
                   {
                       min = p.getBasePrice();
                     //   prod.add(p);
                   }*/
       //  }
        /* for(Product p1: product){
                  Double val=p1.getBasePrice();
             if(retVal==0)
                   {
                      
                       if(val==min)
                            prod.add(p1);
                       
                   }
                   if(retVal>0)
                   {
                      if(val==min)
                       prod.add(p1);
                   }
                   }*/
     
  
         return prod;
   }
/*public ArrayList<Product> searchByLowestPrice()
{
    prod = new ArrayList<Product>();
   // Object obj= Collections.min(product);
    
}*/
public ArrayList<Product> searchByType(String item)
   {
      prod = new ArrayList<Product>();
      
      ///Double min = product.get(0).getBasePrice();
          for(Product p: product)
        {
            
            if(p.getType().toLowerCase().contains(item.toLowerCase()))
            {
                prod.add(p);
            }
        }
       
       return prod; 
   }
}

/*class ProdCompare implements Comparator<Product>
{
    @Override
    public int compare(Product p1, Product p2)
    {
        return p1.getBasePrice().compareTo(p2.getBasePrice());
    }
}*/