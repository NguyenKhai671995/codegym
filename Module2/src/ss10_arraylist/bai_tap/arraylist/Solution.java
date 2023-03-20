package ss10_arraylist.bai_tap.arraylist;

public class Solution {
    public static void main(String[] args) {
        Mylist<Integer> mylist = new Mylist<>(10);
        mylist.add(0,3);
        mylist.add(1,2);
        mylist.add(2,1);
        mylist.add(3,4);
        mylist.add(4,7);

        mylist.getInfo();

        mylist.remove(2);

        mylist.getInfo();
    }
}
