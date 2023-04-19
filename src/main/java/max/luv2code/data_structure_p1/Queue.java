package max.luv2code.data_structure_p1;


// FIFO
public class Queue {
    private int front;
    private int rear;
    private int[] arr;
    private int size;

    public Queue(int size) {
        this.arr = new int[size];
        this.front = -1;
        this.rear = -1;
    }

    public void enQueue(int x) {
        if (isFull())
            System.out.println("Queue is full!!!");

        else {
            if (front == -1)
                front = 0;
            rear++;
            arr[rear] = x;
        }
    }

    public int deQueue(int x) {
        int temp = 0;
        if (isEmpty())
            System.out.println("Queue is empty!!!");

        else {
            temp = arr[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            }
            else {
                front++;
            }
        }
        return temp;
    }

    public boolean isFull() {
        if (front == 0 && rear == size - 1) return true;
        else return false;
    }

    public boolean isEmpty() {
        if (front == -1) return true;
        else return false;
    }

    public void display() {
        for (int i = front; i <= rear; i++)
            System.out.print(arr[i] + "  ");

        System.out.println("\nRear index-> " + rear);
    }

}
