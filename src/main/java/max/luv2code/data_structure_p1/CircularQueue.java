package max.luv2code.data_structure_p1;

public class CircularQueue {

    final int SIZE = 5;
    int front, rear;
    int[] items = new int[SIZE];

    private CircularQueue() {
        this.front = -1;
        this.rear = -1;
    }

    public static CircularQueue createCircularQueue() {
        return new CircularQueue();
    }

    // Check if the queue is full
    public boolean isFull() {
        if (this.front == 0 && this.rear == SIZE - 1) return true;
        if (this.front == rear + 1) return true;

        return false;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        if (this.front == -1 && this.rear == -1) return true;

        return false;
    }

    public void enQueue(int item) {
        // Check isFull
        if (isFull()) {
            System.out.println("The queue is full!!!");
        } else {
            // Check the index of the front
            if (this.front == -1)
                this.front = 0;

            this.rear = (this.rear + 1) % SIZE;
            items[rear] = item;
            System.out.println("Inserted item= " + item);
        }
    }

    public int deQueue() {
        int removeItem = 0;
        // Check Empty
        if (isEmpty()) {
            System.out.println("The queue is empty!!!");
        } else {
            removeItem = items[front];

            // Front == rear: last item of the queue needed to be removed
            // Set back front, rear to -1
            if (this.front == this.rear) {
                this.front = -1;
                this.rear = -1;
            } else {
                this.front = (this.front + 1) % SIZE;
            } // move the front index to the next item
        }
        return removeItem;
    }

    public int size() {
        return this.items.length;
    }

    public int getFront() {
        return this.front;
    }

    public int getRear() {
        return this.rear;
    }

    public static void main(String[] args) {
        var c1 = CircularQueue.createCircularQueue();
        System.out.println(c1.size());
        System.out.println(c1.getFront());
    }
}
