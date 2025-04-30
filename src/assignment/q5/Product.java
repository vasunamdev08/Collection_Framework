package assignment.q5;

class Product {
    private int id;
    private String name;
    private double price;
    private double rating;
    private int stock;

    public Product(int id, String name, double price, double rating, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", Price: $" + price +
                ", Rating: " + rating +
                ", Stock: " + stock;
    }
}
