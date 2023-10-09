package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.*;

public class ProductManagement {
    private static List<Catalog> catalogs = new ArrayList<>();
    private static List<Product> products = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("****************JAVA-HACKATHON-05-ADVANCE-2-MENU***************");
            System.out.println("1. Nhập số danh mục sản phẩm và nhập thông tin các danh mục");
            System.out.println("2. Nhập số sản phẩm và nhập thông tin các sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá sản phẩm tăng dần");
            System.out.println("4. Tìm kiếm sản phẩm theo tên danh mục sản phẩm");
            System.out.println("5. Thoát");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addCatalog();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    sortProductByPrice();
                    break;
                case 4:
                    searchProductByCategoryName();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }

    private static void addCatalog() {
        System.out.print("Nhập số danh mục sản phẩm: ");
        Scanner scanner = new Scanner(System.in);
        int numCatalogs = scanner.nextInt();
        for (int i = 0; i < numCatalogs; i++) {
            Catalog catalog = new Catalog();
            catalog.inputData();
            catalogs.add(catalog);
        }
    }

    private static void addProduct() {
        System.out.print("Nhập số sản phẩm: ");
        Scanner scanner = new Scanner(System.in);
        int numProducts = scanner.nextInt();
        for (int i = 0; i < numProducts; i++) {
            Product product = new Product();
            product.inputData();
            products.add(product);
        }
    }

    private static void sortProductByPrice() {
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Float.compare(p1.getExportPrice(), p2.getExportPrice());
            }
        });

        System.out.println("Sản phẩm đã được sắp xếp theo giá sản phẩm tăng dần:");
        for (Product product : products) {
            if (product != null) {
                product.displayData();
            }
        }
    }

    private static void searchProductByCategoryName() {
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        System.out.print("Nhập tên danh mục sản phẩm cần tìm kiếm: ");
        String categoryName = scanner.nextLine();
        System.out.println("Các sản phẩm trong danh mục '" + categoryName + "':");
        for (Product product : products) {
            if (product.getCatalog().getCatalogName().equalsIgnoreCase(categoryName)) {
                product.displayData();
            }
        }
    }
}
