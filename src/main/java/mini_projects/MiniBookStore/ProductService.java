package mini_projects.MiniBookStore;
//2- ->>product işlemleri için bir standart oluşturuyorum.
//bu demektir ki ben ürünlerle ilgili bir servis class'i oluşturacağım zaman
//burada yazdığım method'lari kullanmak zorundayım.
public interface ProductService {

    void processMenu();
    void listProduct();
    void addProduct();
    void addStock(int miktar);
    void deleteProduct();
    void updateProduct();
    void filterProducts(String filter);


}
