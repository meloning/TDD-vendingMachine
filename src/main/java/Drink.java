


public class Drink {
    private String drink;
    private int price;
    public Drink(String drink, int price) {
        this.drink=drink;
        this.price=price;
    }

    public String getDrink() {
        return drink;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
