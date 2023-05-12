package mini_projects.login;

import java.util.Scanner;

public class LoginMain {
    /*
    Project: Bir siteye üye olma ve giriş yapma sayfası tasarlayınız.

    menü: kullanıcıya işlem seçimi için menü gösterilir.

    üye olma(register): kullanıcıdan ad-soyad, kullanıcı adı, email ve şifre bilgileri alınız.
                        kullanıcı adı, mail ve şifre birer listede tutulur.
                        aynı kullanıcı adı veya e mail kabul edilmez.

    giriş(login): kullanıcı adı/email ve şifre girilir
                  kullanıcı adı veya e mail bulunamazsa kayıtlı değil,üye olun uyarısı verilir.
                  kullanıcı adı/email ile aynı indekste kayıtlı şifre doğrulanırsa siteye giriş yapılır.

    e mail validation: boşluk içermemeli
                       @ içermeli
                       gmail.com, hotmail.com veya yahoo.com ile bitmeli
                       mailin kullanıcı adı kısmında (@ ten önce) sadece büyük-küçük harf, rakam ya da -._ sembolleri olabilir.

    password validation: boşluk içermemeli
                         en az 6 karakter olmalı
                         en az 1 tane küçük harf içermeli
                         en az 1 tane büyük harf içermeli
                         en az 1 tane rakam içermeli
                         en az 1 tane sembol içermeli
     */


    public static void main(String[] args) {

        start();
    }

    public static void start() {

        Scanner input = new Scanner(System.in);
        UserService u = new UserService();
        String secim;

        do {
            u.showMenu();
            secim = input.next();

            switch (secim) {
                case "1":
                    u.register();
                    break;
                case "2":
                    u.login();
                    break;
                case "3":
                    System.out.println("İyi günler dileriz.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Hatalı giriş yaptınız.Yeniden deneyiniz.");
            }


        } while (secim != "3");

    }


}
