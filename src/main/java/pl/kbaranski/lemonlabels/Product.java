/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kbaranski.lemonlabels;

/**
 *
 * @author krzysiek
 */
public class Product {
    
    private Integer code;
    private String name;
    private Float price;
    private String unit;

    public Product() {
    }
    
    public Product(Integer code, String name, Float price, String unit) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.unit = unit;
    }
    
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }    
}
