
public class SinglyLinkedList {
    private Node head;

    private static class Node {
        private Task task;
        private Node next;

        public Node(Task task) {
            this.task = task;
            this.next = null;
        }
    }

    // Add a task
    public void addTask(Task task) {
        Node newNode = new Node(task);
        newNode.next = head;
        head = newNode;
    }

    // Search for a task by taskId
    public Task searchTask(String taskId) {
        Node current = head;
        while (current != null) {
            if (current.task.getTaskId().equals(taskId)) {
                return current.task;
            }
            current = current.next;
        }
        return null; // not found
    }

    // Traverse all tasks
    public void traverseTasks() {
        Node current = head;
        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    // Delete a task by taskId
    public void deleteTask(String taskId) {
        if (head == null) return;

        if (head.task.getTaskId().equals(taskId)) {
            head = head.next;
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId().equals(taskId)) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
    public static void main(String[] args) {
        SinglyLinkedList taskList = new SinglyLinkedList();

        Task task1 = new Task("T001", "Design database schema", "Pending");
        Task task2 = new Task("T002", "Develop API", "In Progress");
        Task task3 = new Task("T003", "Write documentation", "Completed");

        taskList.addTask(task1);
        taskList.addTask(task2);
        taskList.addTask(task3);

        System.out.println("All tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearch for T002:");
        System.out.println(taskList.searchTask("T002"));

        System.out.println("\nDelete T002:");
        taskList.deleteTask("T002");

        System.out.println("\nAll tasks after deletion:");
        taskList.traverseTasks();
    }
}
