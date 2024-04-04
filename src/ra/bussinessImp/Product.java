package ra.bussinessImp;

import ra.business.IProduct;
import ra.business.config.InputMethods;

public class Product implements IProduct,Comparable<Product> {
    private int productId;
    private String productName;
    private String title;
    private String descriptions;
    private float importPrice;
    private float exportPrice;
    private float interest;
    private boolean productStatus;

    // Constructors
    public Product() {
        // Default constructor
    }

    public Product(int productId, String productName, String title, String descriptions,
                   float importPrice, float exportPrice, boolean productStatus) {
        this.productId = productId;
        this.productName = productName;
        this.title = title;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.productStatus = productStatus;
        this.interest = calculateInterest();
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public float getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(float importPrice) {
        this.importPrice = importPrice;
    }

    public float getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(float exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isProductStatus() {
        return productStatus;
    }

    public void setProductStatus(boolean productStatus) {
        this.productStatus = productStatus;
    }

    public void inputData() {
        // Assume you have a Scanner object for input
        System.out.print("Mời bạn nhập Id: ");
        this.productId = InputMethods.getInteger();
        System.out.print("mời bạn nhập tên: ");
        this.productName =InputMethods.getString();
        System.out.print("Mời bạn nhâp tiêu đề: ");
        this.title = InputMethods.getString();
        System.out.print("Mời bạn nhập mô tả: ");
        this.descriptions = InputMethods.getString();
        System.out.print("mời bạn nhập giá nhập vào: ");
        this.importPrice = InputMethods.getFloat();
        System.out.print("mời bạn nhập giá bán ra: ");
        this.exportPrice = InputMethods.getFloat();
        System.out.println("mời bạn nhập vào trạng thái (true/false)");
        this.productStatus=InputMethods.getBoolean();
        this.interest = calculateInterest();
    }

    // Method to calculate interest
    private float calculateInterest() {
        return this.exportPrice - this.importPrice;
    }

    // Method to display all product information
    public void displayData() {
        System.out.print(" ID: " + this.productId);
        System.out.print(" | tên: " + this.productName);
        System.out.print(" | Tiêu đề: " + this.title);
        System.out.print(" | Mô thả: " + this.descriptions);
        System.out.print(" | Giá mua vào: " + this.importPrice);
        System.out.print(" | Giá bán ra: " + this.exportPrice);
        System.out.print(" | Lợi nhuận: " + this.interest);
        System.out.println(" | Trạng thái: " +( this.productStatus?"hoạt dộng":"không hoạt động"));
    }

    @Override
    public int compareTo(Product o) {
        return Float.compare(this.interest,o.interest);
    }
}
