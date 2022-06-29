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
        return String.format(" {\n\tProduct name:%s" +"\n\t"+ "Product price:%f "+"\n\t"+"Product rate: %f\n\n}", name, price, rate);
    }
}