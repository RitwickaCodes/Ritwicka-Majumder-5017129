import java.util.*;
public class SearchAlgorithms {
	//Linear Search
	public static Product linearSearch(Product[] products, String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }
	//Binary Search
	public static Product binarySearch(Product[] products, String productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = products[mid].getProductId().compareTo(productId);

            if (comparison == 0) {
                return products[mid];
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }
	public static void main(String[] args) {
        Product[] products = {
            new Product("01", "Laptop", "Electronics"),
            new Product("02", "Smartphone", "Electronics"),
            new Product("03", "Headphones", "Accessories"),
            new Product("04", "Camera", "Photography"),
            new Product("05", "Tablet", "Electronics")
        };

        // Sort products by productId for binary search
        Arrays.sort(products, Comparator.comparing(Product::getProductId));

        // Linear search
        Product result = linearSearch(products, "03");
        System.out.println("Linear Search Result: " + result);

        // Binary search
        result = binarySearch(products, "03");
        System.out.println("Binary Search Result: " + result);
    }
}
