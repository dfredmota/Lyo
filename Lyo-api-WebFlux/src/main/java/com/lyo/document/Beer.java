package com.lyo.document;

import com.mongodb.gridfs.GridFS;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author Fred Mota
 * Dfredmota@gmail.com
 */

@Document(collection = "beer")
public class Beer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    public String id;
    public String name;
    public String brewery;
    public String coutry;
    public Double price;
    public Double discount;
    public Double quantity;
    public Double totalUnity;
    public Double totalBox;
    public String currency;
    public String probar;
    public String star;
    public GridFS imagem;

    // Constructors
    public Beer() {}

    public Beer(String id, String name, String brewery, String coutry,
                Double price, Double discount, Double quantity, Double totalUnity,
                Double totalBox, String currency, String probar, String star, GridFS imagem) {
        super();
        this.id = id;
        this.name = name;
        this.brewery = brewery;
        this.coutry = coutry;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.totalUnity = totalUnity;
        this.totalBox = totalBox;
        this.currency = currency;
        this.probar = probar;
        this.star = star;
        this.imagem = imagem;

    }

  public double getTotalUnity() {
        double price = getPrice();
        double quantity = getQuantity();
        if (price != 0  & quantity != 0 ) {
            double totalUnity = ( price * quantity );
            return totalUnity;
        } else {
            return Double.parseDouble(null);
        }
    }

    public double getTotalBox() {
        double price = getPrice();
        double quantity = getQuantity();
        double discount = getDiscount();
        if (price != 0  & quantity >= 6.0){
            double totalBox = ( price * quantity ) - discount;
            return totalBox;
        } else {
            double totalBox = 0.0;
            return totalBox;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    public String getCoutry() {
        return coutry;
    }

    public void setCoutry(String coutry) {
        this.coutry = coutry;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public void setTotalUnity(double totalUnity) {
        this.totalUnity = totalUnity;
    }

    public void setTotalBox(double totalBox) {
        this.totalBox = totalBox;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getProbar() {
        return probar;
    }

    public void setProbar(String probar) {
        this.probar = probar;
    }

    public String getStar() {
        return star;
    }

    public void setStar(String star) {
        this.star = star;
    }

    public GridFS getImagem() {
        return imagem;
    }

    public void setStar(GridFS imagem) {
        this.imagem = imagem;
    }
}

