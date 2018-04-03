/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

/**
 *
 * @author varsha
 */
public class Vendor {
    private String vendorName;
   // private ProductCatalog productCatalog;
    private String vendorMail;
    private String vendorID;

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }
    
    public String getVendorMail() {
        return vendorMail;
    }

    public void setVendorMail(String vendorMail) {
        this.vendorMail = vendorMail;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

   /* public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }*/
   
    @Override
    public String toString()
    {
        return vendorName;
    }
}
