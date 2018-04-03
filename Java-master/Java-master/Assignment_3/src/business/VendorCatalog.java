/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class VendorCatalog {
    private ArrayList<Vendor> vendor;

    public VendorCatalog() {
        vendor = new ArrayList<Vendor>();
    }

    public ArrayList<Vendor> getVendor() {
        return vendor;
    }

    public void setVendor(ArrayList<Vendor> vendor) {
        this.vendor = vendor;
    }
    public Vendor addVendor()
   {
      Vendor v = new Vendor();
      vendor.add(v);
      return v;
      
   }
   public void removeVendor(Vendor v)
   {
      vendor.remove(v);
   }
    
}
