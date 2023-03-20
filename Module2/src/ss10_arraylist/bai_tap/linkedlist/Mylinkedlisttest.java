package ss10_arraylist.bai_tap.linkedlist;

public class Mylinkedlisttest {
    public static void main(String[] args) {
        Mylinkedlist<Integer> linkedList = new Mylinkedlist<>();
        linkedList.addFirst(30);
        linkedList.addLast(10);
        linkedList.addLast(14);
        linkedList.addLast(15);
        linkedList.addLast(14);
        linkedList.addLast(19);
        linkedList.addFirst(30);
        linkedList.addFirst(34);
        linkedList.add(3, 16);
        linkedList.removeElement(15);
        linkedList.removeIndex(5);
        linkedList.showData();
    }
}
