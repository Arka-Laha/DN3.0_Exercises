import java.util.ArrayList;
import java.util.List;

// Define the Search class
class Search {
    private Inventory inventory;

    public Search(Inventory inventory) {
        this.inventory = inventory;
    }

    // Method to search for a product using linear search
    public Product linearSearch(String attributeName, Object attributeValue) {
        for (Product product : inventory.getProducts().values()) {
            switch (attributeName.toLowerCase()) {
                case "productid":
                    if (product.getProductId() == (int) attributeValue) {
                        return product;
                    }
                    break;
                case "productname":
                    if (product.getProductName().equals(attributeValue)) {
                        return product;
                    }
                    break;
                case "quantity":
                    if (product.getQuantity() == (int) attributeValue) {
                        return product;
                    }
                    break;
                case "price":
                    if (product.getPrice() == (double) attributeValue) {
                        return product;
                    }
                    break;
                default:
                    System.out.println("Invalid attribute name.");
                    return null;
            }
        }
        System.out.println("Product not found in the inventory.");
        return null;
    }

    // Method to search for a product using binary search
    public Product binarySearch(String attributeName, Object attributeValue) {
        List<Product> productList = new ArrayList<>(inventory.getProducts().values());
        productList.sort((p1, p2) -> {
            switch (attributeName.toLowerCase()) {
                case "productid":
                    return Integer.compare(p1.getProductId(), p2.getProductId());
                case "productname":
                    return p1.getProductName().compareTo(p2.getProductName());
                case "quantity":
                    return Integer.compare(p1.getQuantity(), p2.getQuantity());
                case "price":
                    return Double.compare(p1.getPrice(), p2.getPrice());
                default:
                    System.out.println("Invalid attribute name.");
                    return 0;
            }
        });

        int low = 0;
        int high = productList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            Product midProduct = productList.get(mid);
            switch (attributeName.toLowerCase()) {
                case "productid":
                    if (midProduct.getProductId() == (int) attributeValue) {
                        return midProduct;
                    } else if (midProduct.getProductId() < (int) attributeValue) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                    break;
                case "productname":
                    if (midProduct.getProductName().equals(attributeValue)) {
                        return midProduct;
                    } else if (midProduct.getProductName().compareTo((String) attributeValue) < 0) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                    break;
                case "quantity":
                    if (midProduct.getQuantity() == (int) attributeValue) {
                        return midProduct;
                    } else if (midProduct.getQuantity() < (int) attributeValue) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                    break;
                case "price":
                    if (midProduct.getPrice() == (double) attributeValue) {
                        return midProduct;
                    } else if (midProduct.getPrice() < (double) attributeValue) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                    break;
                default:
                    System.out.println("Invalid attribute name.");
                    return null;
            }
        }
        System.out.println("Product not found in the inventory.");
        return null;
    }
}