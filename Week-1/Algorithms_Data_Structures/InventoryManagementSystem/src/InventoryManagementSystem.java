import java.util.HashMap;
public class InventoryManagementSystem {
	private HashMap<String,Product> inventory;
	public InventoryManagementSystem() {
        inventory = new HashMap<>();
    }

    // Add product
    public void addProduct(Product product) {
        inventory.put(product.getProductId(), product);
    }

    // Update product
    public void updateProduct(Product product) {
        if (inventory.containsKey(product.getProductId())) {
            inventory.put(product.getProductId(), product);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Delete product
    public void deleteProduct(String productId) {
        if (inventory.containsKey(productId)) {
            inventory.remove(productId);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Display all products
    public void displayAllProducts() {
        for (Product product : inventory.values()) {
            System.out.println(product);
        }
    }
    public static void main(String[] args) {
        InventoryManagementSystem ims = new InventoryManagementSystem();

        Product product1 = new Product("01", "Laptop", 10, 15000.0);
        Product product2 = new Product("02", "Smartphone", 20, 7000.0);

        ims.addProduct(product1);
        ims.addProduct(product2);

        ims.displayAllProducts();

        product1.setPrice(17000.0);
        ims.updateProduct(product1);
        ims.displayAllProducts();

        ims.deleteProduct("02");
        ims.displayAllProducts();
    }
}
