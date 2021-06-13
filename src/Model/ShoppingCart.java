package Model;


public class ShoppingCart {
    private String ISBN;
    private String title;
    private String publisher;
    private String category;
    private String price;
    private String quantity;

    public ShoppingCart(String ISBN, String title, String publisher, String category, String price, String quantity) {
        this.ISBN = ISBN;
        this.title = title;
        this.publisher = publisher;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
