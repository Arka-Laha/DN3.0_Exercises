import java.util.*;

class AllOrders {
    private List<Order> orders;

    public AllOrders() {
        this.orders = new ArrayList<>();
    }

    // Method to add an order
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    // Getters and Setters
    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
