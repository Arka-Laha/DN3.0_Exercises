import java.util.Arrays;
import java.util.Map;

import java.util.*;

public class Sort {
    // Method to sort orders by totalPrice using Bubble Sort
    public static void bubbleSort(List<Order> orderList) {
        int n = orderList.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orderList.get(j).getTotalPrice() > orderList.get(j + 1).getTotalPrice()) {
                    Collections.swap(orderList, j, j + 1);
                }
            }
        }
    }

    // Method to sort orders by totalPrice using Quick Sort
    public static void quickSort(List<Order> orderList) {
        quickSortHelper(orderList, 0, orderList.size() - 1);
    }

    private static void quickSortHelper(List<Order> orderList, int low, int high) {
        if (low < high) {
            int pi = partition(orderList, low, high);
            quickSortHelper(orderList, low, pi - 1);
            quickSortHelper(orderList, pi + 1, high);
        }
    }

    private static int partition(List<Order> orderList, int low, int high) {
        double pivot = orderList.get(high).getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orderList.get(j).getTotalPrice() <= pivot) {
                i++;
                Collections.swap(orderList, i, j);
            }
        }
        Collections.swap(orderList, i + 1, high);
        return i + 1;
    }
}
