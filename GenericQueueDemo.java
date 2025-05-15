import java.util.LinkedList;
import java.util.Queue;

public class GenericQueue<T> {

    private Queue<T> queue;

    // Constructor to initialize queue
    public GenericQueue() {
        queue = new LinkedList<>();
    }

    // Push an element into the queue
    public void push(T item) {
        queue.offer(item);
        System.out.println("Pushed: " + item);
    }

    // Pop an element from the queue
    public T pop() {
        if (queue.isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        T item = queue.poll();
        System.out.println("Popped: " + item);
        return item;
    }

    // Display the current queue elements
    public void display() {
        System.out.println("Queue elements: " + queue);
    }

}

public class GenericQueueDemo {

    public static void main(String[] args) {
	
        GenericQueue<Integer> intQueue = new GenericQueue<>();

        intQueue.push(10);
        intQueue.push(20);
        intQueue.push(30);
        intQueue.display();

        intQueue.pop();
        intQueue.display();

        GenericQueue<String> stringQueue = new GenericQueue<>();
        stringQueue.push("Hello");
        stringQueue.push("World");
        stringQueue.display();

        stringQueue.pop();
        stringQueue.display();
    }
}