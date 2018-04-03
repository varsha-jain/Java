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
public class Product {
   private String prodName;
   private String modelNumber;
   private String prodDesc;
   private String vendorName;
   private Double basePrice;
   private String prodFeature;
   private String type;
   private Double ceilPrice;
   private Double floorPrice;

    public Double getCeilPrice() {
        return ceilPrice;
    }

    public void setCeilPrice(Double ceilPrice) {
        this.ceilPrice = ceilPrice;
    }

    public Double getFloorPrice() {
        return floorPrice;
    }

    public void setFloorPrice(Double floorPrice) {
        this.floorPrice = floorPrice;
    }
   
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProdFeature() {
        return prodFeature;
    }

    public void setProdFeature(String prodFeature) {
        this.prodFeature = prodFeature;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getProdDesc() {
        return prodDesc;
    }

    public void setProdDesc(String prodDesc) {
        this.prodDesc = prodDesc;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }
    @Override
    public String toString()
    {
        
        return vendorName;
    }
}
