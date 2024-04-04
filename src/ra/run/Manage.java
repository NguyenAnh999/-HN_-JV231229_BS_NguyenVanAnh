package ra.run;

import ra.business.config.InputMethods;
import ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Manage {
    public static List<Product> productList = new ArrayList<>();
    static {
        productList.add(new Product(1,"caphe","tieu de","mota",12,17,true));
        productList.add(new Product(2,"caphe","tieu de","mota",12,14,true));
        productList.add(new Product(3,"caphe","tieu de","mota",12,13,true));
        productList.add(new Product(4,"caphe","tieu de","mota",12,15,true));


    }

    public void addElement() {
        System.out.println("Mời bạn nhập vào số sản phẩm muốn thêm");
        byte quantity = InputMethods.getByte();
        for (int i = 0; i < quantity; i++) {
            Product product = new Product();
            product.inputData();
            productList.add(product);
        }
        System.out.println("thêm thành công");
    }

    public void deleteElement() {
        displayData();
        while (true) {
            System.out.println("Mời bạn nhập vào ID sản phẩm muốn xóa");
            int IDDelete = InputMethods.getInteger();
            if (finByID(IDDelete) == null) {
                System.out.println("id bạn nhập vào chưa đúng");
            } else {
                productList.remove(finByID(IDDelete));
                System.out.println("Xóa sản phẩm thành công");
                return;
            }
        }
    }


    public void updateElement() {
        displayData();
            System.out.println("Mời bạn nhập vào ID sản phẩm muốn thay đổi trạng thái");
            int upDate = InputMethods.getInteger();
            if (finByID(upDate) == null) {
                System.out.println("id bạn nhập vào chưa đúng");
            } else {
                if(finByID(upDate).isProductStatus()){
                    finByID(upDate).setProductStatus(false);
                    System.out.println("bạn đã sửa trạng thái từ true thành false");
                }else {
                    finByID(upDate).setProductStatus(true);
                    System.out.println("bạn đã sửa trạng thái từ false thành true");
            }
        }
    }


    public void displayData() {
        if (productList.isEmpty()) {
            System.err.println("bạn chưa có sản phẩm nào");
        }
        productList.forEach(Product::displayData);
    }

    public Product finByID(int ID) {
        for (Product product : productList) {
            if (product.getProductId() == ID) {
                return product;
            }
        }
        return null;
    }

    public void sortElementByInterest() {
        Collections.sort(productList);
        System.out.println("Sắp xếp thành công");
        displayData();
    }
    public void searchByName() {
        System.out.println("mời bạn nhập vào tên sản phẩm muốn tìm");
        String name = InputMethods.getString();
        if (productList.stream().anyMatch(product -> product.getProductName().contains(name))){
            productList.stream().filter(product -> product.getProductName().contains(name)).forEach(Product::displayData);
        }else {
            System.out.println("không timg thấy sản phẩm bạn muốn");
        }
    }

}
