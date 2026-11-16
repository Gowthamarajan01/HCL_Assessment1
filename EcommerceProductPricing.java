import java.util.Scanner;

class Product {
    protected int productId;
    protected String productName;
    protected double price;

    Product(int productId, String productName, double price) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
    }

    public double calculateDiscount() {
        return 0.0;
    }

    public double calculateFinalPrice() {
        return price - calculateDiscount();
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }
}

class ElectronicsProduct extends Product {
    ElectronicsProduct(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 12.0 / 100.0;
    }
}

class ClothingProduct extends Product {
    ClothingProduct(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 20.0 / 100.0;
    }
}

class GroceryProduct extends Product {
    GroceryProduct(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public double calculateDiscount() {
        return price * 5.0 / 100.0;
    }
}

public class EcommerceProductPricing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int productType = sc.nextInt();
        int productId = sc.nextInt();
        String productName = sc.next();
        double price = sc.nextDouble();

        Product product;
        switch (productType) {
            case 1:
                product = new ElectronicsProduct(productId, productName, price);
                break;
            case 2:
                product = new ClothingProduct(productId, productName, price);
                break;
            default:
                product = new GroceryProduct(productId, productName, price);
        }

        System.out.println("Product ID: " + product.getProductId());
        System.out.println("Product Name: " + product.getProductName());
        System.out.printf("Discount: %.2f%n", product.calculateDiscount());
        System.out.printf("Final Price: %.2f%n", product.calculateFinalPrice());

        sc.close();
    }
}
