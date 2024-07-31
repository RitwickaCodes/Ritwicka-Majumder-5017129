
public class SortingAlgorithms {
	public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
	}
	public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high] (pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;

        return i + 1;
    }
    public static void main(String[] args) {
        Order[] orders1 = {
            new Order("O001", "Alice", 250.75),
            new Order("O002", "Bob", 120.50),
            new Order("O003", "Tom", 320.00),
            new Order("O004", "Sam", 75.25),
            new Order("O005", "Eve", 450.00)
        };
        System.out.println("Bubble Sort");
        bubbleSort(orders1);

        for (Order order : orders1) {
            System.out.println(order);
        }
        Order[] orders2 = {
                new Order("O001", "Alice", 250.75),
                new Order("O002", "Bob", 120.50),
                new Order("O003", "Charlie", 320.00),
                new Order("O004", "Dave", 75.25),
                new Order("O005", "Eve", 450.00)
            };
        System.out.println("Quick Sort");
        quickSort(orders2, 0, orders2.length - 1);
        for (Order order : orders2) {
        	System.out.println(order);
        }
     }
        
}

