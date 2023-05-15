package mini_projects.MiniBookStore;
//1-> c product özllklri + brand + sheet + code
public class NoteBook extends Product {

    private String brand;
    private int sheet;
    private String code;

    public NoteBook(String name, String price, int stok, String brand, int sheet, String code) {
        super(name, price, stok);
        this.brand = brand;
        this.sheet = sheet;
        this.code = code;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getSheet() {
        return sheet;
    }

    public void setSheet(int sheet) {
        this.sheet = sheet;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
