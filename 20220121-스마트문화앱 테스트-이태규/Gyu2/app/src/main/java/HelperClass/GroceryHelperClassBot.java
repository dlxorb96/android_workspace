package HelperClass;

public class GroceryHelperClassBot {


    int image;
    String title, price;

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public GroceryHelperClassBot(int image, String title, String price) {
        this.image = image;
        this.title = title;
        this.price = price;
    }
}
