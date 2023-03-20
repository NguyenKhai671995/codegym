package ss11_queue_stack.bai_tap.queue_circular;

public class Queue {
    public Node front;
    public Node rear;

    public Queue() {
    }

    public Queue(Node node) {
        this.front = node;
        this.rear = node;
        front.next = rear;
    }

    public void enQueue(int value){
        Node temp = new Node(value);
        if(front == null){
            front = temp;
        }
        else {
            rear.next = temp;
        }
        rear = temp;
        rear.next = front;
    }

    public void deQueue(){
        if (front == null) return;
        if (front == rear) {
            front = rear = null;
            return;
        }
        Node temp = front.next;
        rear.next = temp;
        front = temp;
    }

    public void displayQueue(){
        Node temp = front;
        do{
            System.out.print(temp.getData());
            temp = temp.next;
            System.out.print("->");
        } while (temp != front);
    }
}

