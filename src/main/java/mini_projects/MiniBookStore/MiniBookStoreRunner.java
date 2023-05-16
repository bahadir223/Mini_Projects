package mini_projects.MiniBookStore;
/*
Proje: Mini Book Store...
       Online bir kitap market için ürün yönetim uygulaması yapınız.
       Kitap markette kitap ve defter satışı olacak, ancak ileride yeni ürün çeşidi eklenebilir olmalı.

       Kitap  özellikleri: id, isim, birim fiyatı, stok, yazar adı, yayınevi, isbn no
       Defter özellikleri: id, isim, birim fiyatı, stok, marka, yaprak sayısı, ürün kodu

       Kullanıcı ilgili kategorideki ürünleri listeleyebilmeli
       Kullanıcı kategoriye göre ürün ekleyebilmeli, ürün mevcutsa uyarı verilmeli
       Kullanıcı ürünleri benzersiz numaralarına göre silebilmeli
       Kullanıcı ürünleri marka(defter) veya yayınevine(kitap) göre filtreleyip listeleyebilmeli.

       NoteBook Service Odev...
       update product optional ödev...


 */

import java.util.Scanner;

public class MiniBookStoreRunner {

    public static void main(String[] args) {
        start();
    }

    /*1-> book class'i, notebook class'ina ihtiyacım var. şimdi yukarıda da görüldüğü üzere kitap class'inda da
    defter class'inda da id, isim, birim fiyatı, stok, variable'lari ortak. ben bu variable'lari iki class'ta da
    yazarsam kod tekrarı yapmış olurum. Bu yüzden product diye bir class oluşturup ortak özellikleri bunun içinde
    oluşturacağım.
     */


    private static void start() {
        Scanner input = new Scanner(System.in);
        String secim;
        do {
            System.out.println("************************* Mini Book Store ************************* ");
            System.out.println("Ürün Yönetim Paneli");
            System.out.println("1-->Kitaplar");
            System.out.println("2-->Defterler");
            System.out.println("3-->Çıkış");
            System.out.println("Seçiminiz : ");
            secim = input.next();

            switch (secim) {
                case "1":
                    BookService book = new BookService();
                    book.processMenu();
                    break;
                case "2":
                    NoteBookService notebook = new NoteBookService();
                    notebook.processMenu();
                    break;
                case "3":
                    System.out.println("İyi günler");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir değer giriniz.");
                    break;
            }
        } while (secim != "3");

    }


}
