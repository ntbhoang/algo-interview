package max.luv2code.data_structure_p1;


// FILO : First In - Last Out
public class Stack {
    private int top;
    private int[] arr;
    private int capacity;

    public Stack(int size) {
        this.arr = new int[size];
        this.capacity = size;
        this.top = -1;
    }

    public void push(int x){
        if (isFull())
            System.out.println("OverFlow\n Terminated");

        this.arr[++top] = x;
    }

    public int pop(){
        if (isEmpty())
            System.out.println("Stack empty");
        return arr[top--];
    }

    public boolean isFull() {
        return this.top == capacity - 1;
    }

    public boolean isEmpty() {
        return this.top == -1;
    }

    public void printStack() {
        for (int i = 0; i <= this.top; i++)
            System.out.println(arr[i]);
    }

    public int size(){
        return this.top - 1;
    }

    /*
        - https://www.programiz.com/dsa/stack
     */
}
