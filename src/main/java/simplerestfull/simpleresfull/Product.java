/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplerestfull.simpleresfull;

/**
 *
 * @author acer
 */
public class Product {
    private String Id;
    private String Name;
    private int Price;
    private int Qty;
    private int Total;

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int Price) {
        this.Price = Price;
    }

    public int getQty() {
        return Qty;
    }

    public void setQty(int Qty) {
        this.Qty = Qty;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal() {
        this.Total = Price * Qty;
    }
    
    
}
