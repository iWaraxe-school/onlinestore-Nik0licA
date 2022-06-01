package bg.coherent.domain;

public class Product {
    private String name;
    private Double rate;
    private Double price;

    public Product(String name, Double rate, Double price) {
        this.name = name;
        this.rate = rate;
        this.price = price;

    }
    public String getName(){
        return name;
    }

    public Double getRate(){
        return rate;
    }

    public Double getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return String.format("Product name:%s" +"\n"+ "Product price:%f "+"\n"+"Product rate: %f", name, price, rate);
    }
}