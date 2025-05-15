import java.util.Arrays;

public class GenericFIFOQueue<T> {

    private T[] queue;
    private int front, rear, capacity;
    private int size;

    // Constructor to initialize queue
    @SuppressWarnings("unchecked")
    public GenericFIFOQueue(int capacity) {
        this.capacity = capacity;
        queue = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue (Push) an element into the queue
    public void enqueue(T item) {
        if (size == capacity) {
            resize();
        }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        size++;
    }

    // Dequeue (Pop) an element from the queue
    public T dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return null;
        }
        T item = queue[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    // Resize the queue dynamically
    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        queue = Arrays.copyOf(queue, capacity);
        System.out.println("Queue resized to capacity: " + capacity);
    }

    // Display queue elements
    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[(front + i) % capacity] + " ");
        }
        System.out.println();
    }

}


public class GenericFIFOQueueDemo {

    public static void main(String[] args) {
		
        GenericFIFOQueue<Integer> intQueue = new GenericFIFOQueue<>(5);

        intQueue.enqueue(10);
        intQueue.enqueue(20);
        intQueue.enqueue(30);
        intQueue.display();

        System.out.println("Dequeued: " + intQueue.dequeue());
        intQueue.display();

        GenericFIFOQueue<String> stringQueue = new GenericFIFOQueue<>(3);
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");
        stringQueue.display();

        System.out.println("Dequeued: " + stringQueue.dequeue());
        stringQueue.display();
    }
	
}