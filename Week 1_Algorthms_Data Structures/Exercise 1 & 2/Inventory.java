import java.util.HashMap;
import java.util.Map;

// Define the Inventory class
class Inventory {
    private Map<Integer, Product> products;

    public Inventory() {
        this.products = new HashMap<>();
    }

    // Method to add a product to the inventory
    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    // Method to update a product in the inventory
    public void updateProduct(int productId, Product updatedProduct) {
        if (products.containsKey(productId)) {
            products.put(productId, updatedProduct);
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }

    // Method to delete a product from the inventory
    public void deleteProduct(int productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
        } else {
            System.out.println("Product not found in the inventory.");
        }
    }

    // Method to display all products in the inventory
    public void displayProducts() {
        for (Product product : products.values()) {
            System.out.println("Product ID: " + product.getProductId());
            System.out.println("Product Name: " + product.getProductName());
            System.out.println("Quantity: " + product.getQuantity());
            System.out.println("Price: " + product.getPrice());
            System.out.println();
        }
    }

    // Method to provide access to the products map
    public Map<Integer, Product> getProducts() {
        return products;
    }
}