package max.luv2code.data_structure_p1;

public class SimpleQueue {
    private int front;
    private int rear;
    private static final int SIZE = 5;
    private int[] elements;

    public SimpleQueue() {
        this.elements = new int[SIZE];
        this.front = -1;
        this.rear = -1;
    }

    public void enQueue(int x) {
        if (isFull()) System.out.println("Queue is FULL!!!");

        // For first element, set the front index to 0
        if (this.front == -1) this.front = 0;
        // Insert the item value
        this.elements[++rear] = x;
    }

    public int deQueue() {
        int removedElement;
        if (isEmpty()) {
            System.out.println("There is nothing to dequeue!!!");
            return -1;
        }
        else {
            removedElement = this.elements[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } // Queue only 1 element, so reset the queue after deleting it
            else {
                this.front++;
                // Point the front index to the next element
            }
            System.out.println("Deleted -> " + removedElement);
            return (removedElement);
        }
    }

    public boolean isFull() {
        if (this.front == 0 && this.rear == SIZE - 1) return true;
        else return false;
    }

    public boolean isEmpty() {
        if (this.front == -1 ) return true;
        else return false;
    }

    public void display() {
        for (int i = 0; i <= rear; i++)
            System.out.print(this.elements[i] + "  ");

        System.out.println("\nRear index-> " + rear);
    }
}
