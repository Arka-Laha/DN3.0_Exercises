import java.util.*;

class Sort {

    // Bubble Sort method
    public void bubbleSort(AllOrders allOrders) {
        List<Order> orders = allOrders.getOrders();
        int n = orders.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders.get(j).getTotalPrice() > orders.get(j + 1).getTotalPrice()) {
                    Order temp = orders.get(j);
                    orders.set(j, orders.get(j + 1));
                    orders.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    // Quick Sort method
    public void quickSort(AllOrders allOrders) {
        List<Order> orders = allOrders.getOrders();
        quickSortHelper(orders, 0, orders.size() - 1);
    }

    private void quickSortHelper(List<Order> orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);

            quickSortHelper(orders, low, pi - 1);
            quickSortHelper(orders, pi + 1, high);
        }
    }

    private int partition(List<Order> orders, int low, int high) {
        double pivot = orders.get(high).getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders.get(j).getTotalPrice() <= pivot) {
                i++;

                Order temp = orders.get(i);
                orders.set(i, orders.get(j));
                orders.set(j, temp);
            }
        }

        Order temp = orders.get(i + 1);
        orders.set(i + 1, orders.get(high));
        orders.set(high, temp);

        return i + 1;
    }
}
