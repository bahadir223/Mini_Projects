 package mini_projects.login;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserService {

    List<String> userNameList = new ArrayList<>();
    List<String> emailList = new ArrayList<>();
    List<String> passwordList = new ArrayList<>();

    public void showMenu() {
        System.out.println("======= Welcome to the  Project ======");
        System.out.println("1-->Üye ol");
        System.out.println("2-->Giriş Yap");
        System.out.println("3-->Çıkış");
        System.out.println("Seçiminiz: ");
    }

    public void register() {
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen ad soyad giriniz.");
        String name = input.nextLine();

        String userName;
        boolean existUserName;
        do {
            System.out.println("Kullanıcı adını giriniz.");
            userName = input.nextLine();
            existUserName = userNameList.contains(userName);
            if (existUserName) {
                System.out.println("Bu username daha önce kullanılmıştır. Yeni bir username deneyiniz.");
            }
        } while (existUserName);

        String eMail;
        boolean isValid;
        boolean existEmail;

        do {
            System.out.println("Lütfen e mail giriniz.");
            eMail = input.nextLine().trim();
            isValid = validateEmail(eMail);

            existEmail = emailList.contains(eMail);

            if (existEmail) {
                isValid = false;
                System.out.println("Bu e mail daha önce kullanılmıştır. Yeni bir e mail deneyiniz.");
            }


        } while (!isValid);

        String password;
        boolean isValidPassword;
        do {
            System.out.println("Lütfen şifrenizi giriniz.");
            password = input.nextLine();
            isValidPassword = validatePassword(password);
        } while (!isValidPassword);


        User u = new User(name, userName, eMail, password); // name,userName,eMail,password uygunsa alıp yeni bir kullanıcı
        userNameList.add(userName);                         // oluşturdum. Uygun değilse yukarıda tekrar tekrar istiyorum...
        emailList.add(eMail);
        passwordList.add(password);

        System.out.println(u);
        System.out.println("Tebrikler kayıt işleminiz gerçekleşmiştir.\nArtık kullanıcı adı/e mail  ve şifrenizle sisteme giriş " +
                "yapabilirsiniz.");


    }

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("Lütfen kullanıcı adı veya email giriniz.");
        String userNameOrEmail = input.nextLine();

        boolean isEMail = emailList.contains(userNameOrEmail);
        boolean isUserName = userNameList.contains(userNameOrEmail);

        if (isEMail || isUserName) {

            while (true) {
                System.out.println("Lütfen password giriniz.");
                String password = input.nextLine();
                int idx;
                if (isUserName) {
                    idx = userNameList.indexOf(userNameOrEmail);
                } else {
                    idx = emailList.indexOf(userNameOrEmail);
                }

                if (passwordList.get(idx).equals(password)) {
                    System.out.println("Sisteme giriş yaptınız.");
                    break;
                } else {
                    System.out.println("Şifreniz yanlış. Tekrar deneyiniz.");
                }
            }
        }else{
            System.out.println("Sisteme kayıtlı kullanıcı bulunamadı.");
            System.out.println("Bilgilerinizi kontrol ediniz.");
        }
    }


    public static boolean validateEmail(String email) {
        boolean isValid;

        boolean space = email.contains(" ");
        boolean isContainAt = email.contains("@");

        if (space) {
            System.out.println("Email boşluk içeremez.");
            isValid = false;
        } else if (!isContainAt) {
            System.out.println("Email @ içermelidir.");
            isValid = false;
        } else {
            String firstPart = email.split("@")[0];
            String secondPart = email.split("@")[1];

            boolean checkStart = firstPart.replaceAll("[a-zA-Z0-9_.-]", "").length() == 0;
            boolean checkEnd = secondPart.equals("gmail.com") ||
                    secondPart.equals("hotmail.com") ||
                    secondPart.equals("yahoo.com");

            if (!checkStart) {
                System.out.println("Email küçük harf,büyük harf, rakam ve _.- dışında karakter içeremez.");
            } else if (!checkEnd) {
                System.out.println("Email gmail.com, hotmail.com veya yahoo.com ile bitmeli.");
            }

            isValid = checkEnd && checkStart;
        }
        return isValid;
    }

    private static boolean validatePassword(String password) {

        boolean isValid;
        boolean space = password.contains(" ");
        boolean lengthGreaterThan6 = password.length() >= 6;
        boolean existUpper = password.replaceAll("[^A-Z]", "").length() > 0;
        boolean existLower = password.replaceAll("[^a-z]", "").length() > 0;
        boolean existDigit = password.replaceAll("[^0-9]", "").length() > 0;
        boolean existSymbol = password.replaceAll("[a-zA-Z0-9]", "").length() > 0;


        if (space) {
            System.out.println("Password boşluk içermemeli");
        } else if (!lengthGreaterThan6) {
            System.out.println("Password en az 6 karakterli olmalı.");
        } else if (!existUpper) {
            System.out.println("Password en az 1 tane büyük harf içermeli.");
        } else if (!existLower) {
            System.out.println("Password en az 1 tane küçük harf içermeli.");
        } else if (!existDigit) {
            System.out.println("Password en az 1 tane rakam içermeli.");
        } else if (!existSymbol) {
            System.out.println("Password en az 1 tane sembol içermeli.");
        }

        isValid = !space && lengthGreaterThan6 && existUpper && existLower && existDigit && existSymbol;

        if (!isValid) {
            System.out.println("Tekrar deneyiniz.");
        }
        return isValid;
    }


}
