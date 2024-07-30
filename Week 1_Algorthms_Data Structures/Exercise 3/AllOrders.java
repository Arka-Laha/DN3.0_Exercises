import java.util.*;

public class AllOrders {
    private Map<Integer, Order> orders;

    public AllOrders() {
        this.orders = new HashMap<>();
    }

    public void addOrder(Order order) {
        orders.put(order.getOrderId(), order);
    }

    public void removeOrder(int orderId) {
        orders.remove(orderId);
    }

    public void displayOrders() {
        for (Order order : orders.values()) {
            System.out.println("Order ID: " + order.getOrderId());
            System.out.println("Customer Name: " + order.getCustomerName());
            System.out.println("Total Price: " + order.getTotalPrice());
            System.out.println();
        }
    }
/*
    public Map<Integer, Order> getOrders() {
        return orders;
    }
*/
    public List<Order> getOrderList() {
        return new ArrayList<>(orders.values());
    }

    public void updateOrders(List<Order> orderList) {
        orders.clear();
        for (Order order : orderList) {
            orders.put(order.getOrderId(), order);
        }
    }
}