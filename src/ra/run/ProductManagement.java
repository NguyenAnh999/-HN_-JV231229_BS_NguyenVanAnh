package ra.run;

import ra.business.config.InputMethods;
import ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductManagement {

    public static void main(String[] args) {
        Manage call = new Manage();
        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-BASIC-MENU*************** \n" +
                    "1. Nhập số sản phẩm và nhập thông tin sản phẩm    \n" +
                    "2. Hiển thị thông tin các sản phẩm      \n" +
                    "3. Sắp xếp sản phẩm theo lợi nhuận tăng dần     \n" +
                    "4. Xóa sản phẩm theo mã sản phẩm      \n" +
                    "5. Tìm kiếm sản phẩm theo tên sản phẩm     \n" +
                    "6. Thay đổi trạng thái của sản phẩm theo mã sản phẩm   \n" +
                    "7. Thoát ");
            System.out.println("mời bạn nhập");
            byte choice = InputMethods.getByte();
            switch (choice) {
                case 1:
                    call.addElement();
                    break;
                case 2:
                    call.displayData();
                    break;
                case 3:
                    call.sortElementByInterest();
                    break;
                case 4:
                    call.deleteElement();
                    break;
                case 5:
                    call.searchByName();
                    break;
                case 6:
                    call.updateElement();
                    break;
                case 7:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không đúng");
                    break;

            }
        }
    }

}
