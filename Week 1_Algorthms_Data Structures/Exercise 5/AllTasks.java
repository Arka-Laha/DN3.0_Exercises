
// Node class for the linked list
class Node {
    Task task;
    Node next;

    // Constructor
    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

// AllTasks class
class AllTasks {
    private Node head;

    // Constructor
    public AllTasks() {
        this.head = null;
    }

    // Method to add a task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to search for a task by ID
    public Task searchTask(int taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.getTaskId() == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Method to traverse all tasks
    public void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Method to delete a task by ID
    public boolean deleteTask(int taskId) {
        if (head == null) {
            return false;
        }
        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return true;
        }
        Node temp = head;
        while (temp.next != null) {
            if (temp.next.task.getTaskId() == taskId) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
