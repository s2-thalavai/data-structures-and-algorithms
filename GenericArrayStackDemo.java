public class GenericArrayStack<T> {
	
    private T[] stack;
    private int top;
    private int capacity;

    // Constructor to initialize stack
    @SuppressWarnings("unchecked")
    public GenericArrayStack(int size) {
        stack = (T[]) new Object[size];
        capacity = size;
        top = -1;
    }

    // Push an element onto the stack
    public void push(T item) {
        if (top == capacity - 1) {
            System.out.println("Stack is full! Cannot push " + item);
            return;
        }
        stack[++top] = item;
    }

    // Pop an element from the stack
    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack[top--];
    }

    // Display the current stack
    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

}


public class GenericArrayStackDemo {

    public static void main(String[] args) {
		
        GenericArrayStack<Integer> intStack = new GenericArrayStack<>(5);
        
        intStack.push(10);
        intStack.push(20);
        intStack.push(30);
        intStack.display();

        System.out.println("Popped: " + intStack.pop());
        intStack.display();
        
        GenericArrayStack<String> stringStack = new GenericArrayStack<>(5);
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.display();
        
        System.out.println("Popped: " + stringStack.pop());
        stringStack.display();
    }
}