import java.util.Arrays;

public class GenericLIFOStack<T> {
	
    private T[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize stack
    @SuppressWarnings("unchecked")
    public GenericLIFOStack(int size) {
        stack = (T[]) new Object[size];
        capacity = size;
        top = -1;
    }

    // Push an element onto the stack
    public void push(T item) {
        if (top == capacity - 1) {
            resize();
        }
        stack[++top] = item;
    }

    // Pop an element from the stack (LIFO principle)
    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack[top--];
    }

    // Resize the array dynamically
    @SuppressWarnings("unchecked")
    private void resize() {
        capacity *= 2;
        stack = Arrays.copyOf(stack, capacity);
        System.out.println("Stack resized to capacity: " + capacity);
    }

    // Display the current stack elements
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack elements (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

}

public class GenericLIFOStackDemo {

    public static void main(String[] args) {
		
        GenericLIFOStack<Integer> intStack = new GenericLIFOStack<>(5);

        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.display();

        System.out.println("Popped: " + intStack.pop());
        intStack.display();

        GenericLIFOStack<String> stringStack = new GenericLIFOStack<>(3);
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.display();

        System.out.println("Popped: " + stringStack.pop());
        stringStack.display();
    }
	
}