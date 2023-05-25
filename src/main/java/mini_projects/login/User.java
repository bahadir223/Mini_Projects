package mini_projects.login;

public class User {

    private String name;
    private String userName;
    private String eMail;
    private String password;

    public User(String name, String userName, String eMail, String password) {
        this.name = name;
        this.userName = userName;
        this.eMail = eMail;
        this.password = password;
    }

    public User() {     //parametresiz object oluşturmak için kullanıyoruz bunu.
    }                   //Default Constructor

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", eMail='" + eMail + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
