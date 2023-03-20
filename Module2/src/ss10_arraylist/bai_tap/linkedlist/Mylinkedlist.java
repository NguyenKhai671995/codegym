package ss10_arraylist.bai_tap.linkedlist;

import javax.xml.soap.Node;

public class Mylinkedlist<E>{
    private class Node{
        private Node next;
        private Object data;
        public Node(Object data){
            this.data = data;
        }
        public Object getData(){
            return this.data;
        }
    }

    //phan tu dau
    private Node head;
    //so luong phan tu
    private int numNodes = 0;

    public Mylinkedlist() {
    }

    public Mylinkedlist(Object data){
        head = new Node(data);
    }

    public void add(int index, E element){
        Node temp = head;
        Node holder;
        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(element);
        temp.next.next = holder;
        numNodes++;
    }

    public void addFirst(E element){
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element){
        Node temp = head;
        while (temp.next != null ){
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public Object get(int index){
        Node temp = head;
        for (int i = 0; i < index ; i++) {
            temp = temp.next;
        }
        return temp.data;
    }

    public int size(){
        return numNodes;
    }
    public E removeIndex(int index){
        if(index < 0 || index > numNodes){
           throw new IllegalArgumentException("Error: index " + index);
        }
        Node temp = head;

        Object data;
        if (index == 0){
            data = temp.data;
            head = head.next;
        }
        else {
            for (int i = 0; i < index - 1 && temp.next != null; i++) {
                temp = temp.next;
            }
            data = temp.next.data;
            temp.next = temp.next.next;
            numNodes--;
        }
        return (E) data;

    }

    public boolean removeElement(E element){
        if (head.data.equals(element)){
            removeIndex(0);
            return true;
        }
        else{
            Node temp = head;
            while (temp.next != null){
                if (temp.next.data.equals(element)){
                    temp.next = temp.next.next;
                    numNodes--;
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    public Mylinkedlist<E> clone(){
        if (numNodes == 0){
            throw new NullPointerException("Linked is null");
        }
        Mylinkedlist<E> returnLinkedList = new Mylinkedlist<>();
        Node temp = head;
        returnLinkedList.addFirst((E) temp);
        temp = temp.next;
        while (temp != null){
            returnLinkedList.addLast((E) temp.data);
            temp = temp.next;
        }
        return returnLinkedList;
    }

    public boolean constrains(E element){
        Node temp = head;
        while (temp.next != null){
            if (temp.data.equals(element)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public int indexof(E element){
        Node temp = head;
        for (int i = 0; i < numNodes; i++) {
            if (temp.getData().equals(element)){
                return i;
            }
        }
        return -1;
    }

    public void showData() {
        Node head = this.head;
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

}
