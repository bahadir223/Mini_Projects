package mini_projects.MiniBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2-a ->>book ile ilgili işlemler yapıldı.
public class BookService implements ProductService {

    Scanner input = new Scanner(System.in);

    // 3- ->>Kitapları saklamak için bir list oluştur.
    List<Book> BookList = new ArrayList<>();


    //4- ->>Başlangıçta sistemde mevcut kitaplar olsun.(test etmek için).
    public BookService() {
        Book book1 = new Book("Fareler ve Insanlar", "120 Lira", 15, "J.Steinbeck", "Penguin", "A111");
        Book book2 = new Book("Sefiller", "150 Lira", 5, "V.Hugo", "Penguin", "A222");
        Book book3 = new Book("Suç ve Ceza", "120 Lira", 15, "Dostoyevski", "Dream", "A333");
        this.BookList.add(book1);
        this.BookList.add(book2);
        this.BookList.add(book3);
    }

    //5- ->>işlem menüsü
    @Override
    public void processMenu() {
        String secim;
        do {
            System.out.println("*************   Kitap Paneli   ************* ");
            System.out.println("1->Kitapları Listele");
            System.out.println("2->Kitap Ekle");
            System.out.println("3->Kitap Sil");
            System.out.println("4->Yayınevine göre Filtrele ");
            System.out.println("5->Kitap Güncelle ");
            System.out.println("0->Geri Dön");
            System.out.println("Seçiminiz : ");

            secim = input.next();
            input.nextLine();

            switch (secim) {
                case "1":
                    listProduct();
                    break;
                case "2":
                    addProduct();
                    break;
                case "3":
                    deleteProduct();
                    break;
                case "4":
                    System.out.println("Yayınevi : ");
                    String publisher = input.nextLine();
                    filterProducts(publisher);
                    break;
                case "5":
                    updateProduct();
                case "0":
                    System.out.println("Ana menüye yönlendiriliyorsunuz");
                    for (int i = 0; i <= 10; i++) {
                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        System.out.print(".");
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("Hatalı giriş !!");
                    break;
            }


        } while (!secim.equals("0"));
    }



    //6- ->>kitapları format ile yazdıralım.

    @Override
    public void listProduct() {
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                "ID", "Kitap Adı", "Yazar Adı", "Yayınevi", "ISBN NO", "Birim Fiyat", "Stok");
        System.out.println("--------------------------------------------------------------------------------------------");
        this.BookList.forEach(t -> System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-11s | %-3s\n",
                t.getId(), t.getName(), t.getAuthorName(), t.getPublisher(), t.getIsbn(), t.getPrice(), t.getStock()));
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println();
    }
    //7- ->>yeni kitap ekleme

    String isbn;
    @Override
    public void addProduct() {
        System.out.println("ISBN : ");
        isbn = input.nextLine();
        boolean isExist = false;

        for (Book w : this.BookList) {
            if (w.getIsbn().equals(isbn)) {
                System.out.println("Bu kitap sistemde zaten kayıtlı.");
                System.out.println("Eklemek istediğiniz miktarı giriniz:");
                int artirilacakMiktar = input.nextInt();
                addStock(artirilacakMiktar);
                isExist = true;


                this.BookList.forEach(t -> System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-11s | %-3s\n",
                        t.getId(), t.getName(), t.getAuthorName(), t.getPublisher(), t.getIsbn(), t.getPrice(), t.getStock()));

            }
        }


        if (!isExist) {
            System.out.println("Kitap Adı:");
            String name = input.nextLine();
            System.out.println("Yazar Adı:");
            String author = input.nextLine();
            System.out.println("Yayınevi:");
            String publisher = input.nextLine();
            System.out.println("Birim Fiyat:");
            String price = input.nextLine();
            System.out.println("Stok:");
            int stock = input.nextInt();
            input.nextLine();

            Book b = new Book(name, price, stock, author, publisher, isbn);
            this.BookList.add(b);
            System.out.println("Kitap eklendi.");
            listProduct();

        }

    }

    @Override
    public void addStock(int miktar) {
        for (Book w : this.BookList) {
            if(w.getIsbn().equals(isbn)){
                int newStock = w.getStock() + miktar;
                w.setStock(newStock);
            }



        }
    }


    //8- Kullanıcıdan alınan id ile ürünü bulalım ve listeden silelim.
    @Override
    public void deleteProduct() {
        boolean isExist = false;
        System.out.println("Kitap id: ");
        int id = input.nextInt();
        for (Book w : this.BookList) {
            if (w.getId() == id) {
                this.BookList.remove(w);
                System.out.println("Kitap listeden silindi.");
                isExist = true;
                break;
            } else {
                isExist = false;
            }
        }
        if (!isExist) {
            System.out.println("Girdiğiniz kitap id sistemde kayıtlı değil. Lütfen tekrar deneyiniz.");
        }

    }

    @Override
    public void updateProduct() {

        System.out.print("Kitap ID: ");
        int id = input.nextInt();

        for (Book book : BookList) {
            if (book.getId() == id) {
                System.out.print("Kitabın Yeni Fiyatı: ");
                String salary = input.next();
                book.setPrice(String.valueOf(salary));
                System.out.println("Kitap birim fiyatı başarıyla güncellendi!");
                return;
            }
        }
        System.out.println("Kitap bulunamadı!");
        //updateProduct : stok artırma, azaltma, birim fiyat ödev



    }

    //9-> Kitapları yayınevine göre filtreleme.
    @Override
    public void filterProducts(String filter) {
        /*this.BookList.stream().
                filter(t -> t.getPublisher().equalsIgnoreCase(filter)).
                forEach(t -> System.out.printf("%-2s | %-20s | %-15s | %-10s | %-4s | %-10s | %-3s\n",
                        t.getId(), t.getName(), t.getAuthorName(), t.getPublisher(), t.getIsbn(), t.getPrice(), t.getStock()));
*/

        int counter = 0;
        for (Book w : this.BookList) {
            if (w.getPublisher().equalsIgnoreCase(filter)) {
                System.out.printf("%-2s | %-20s | %-15s | %-10s | %-7s | %-11s | %-3s\n",
                        w.getId(), w.getName(), w.getAuthorName(), w.getPublisher(), w.getIsbn(), w.getPrice(),
                        w.getStock());
                counter++;
            }

        }
        if (counter == 0) {
            System.out.println("Ürün bulunamadı.");
        } else {
            System.out.println();
            System.out.println(counter + " adet ürün bulundu.");
        }

    }
}
