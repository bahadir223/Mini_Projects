package mini_projects.MiniBookStore;

// 1-a tüm ürünlerin ortak özellikleri ve metodları burada.
public class Product {

    private static int count = 0;
    private int id;
    private String name;
    private String price;
    private int stock;

    public Product(String name, String price, int stok) {
        count++; //her bir ürün oluşturulduğunda count 1 artsın ve ürünün id si de bu sayacın değeri olsun dedik.
        this.id = count;
        this.name = name;
        this.price = price;
        this.stock = stok;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Product.count = count;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
