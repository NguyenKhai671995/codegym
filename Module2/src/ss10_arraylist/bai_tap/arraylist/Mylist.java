package ss10_arraylist.bai_tap.arraylist;

import java.util.Arrays;

public class Mylist<E> {
    int size = 0;
    static final int DEFAULT_CAPACITY = 10;
    Object[] myList;

    public Mylist() {
    }

    public Mylist(int capacity) {
        this.size = capacity;
        myList = new Object[size];
    }

    public Object[] clone() {
        return Arrays.copyOf(myList, myList.length + 1);
    }

    public void add(int index, E element) {
        Object[] result = clone();
        for (int i = 0; i < getSize(); i++) {
            if (i == index) {
                result[i] = element;
            }
            if (i > index) {
                result[i] = myList[i];
            }
        }
        myList = result;
    }

    public void remove(int index) {
        Object[] result = clone();
        for (int i = index; i < getSize(); i++) {
            if (i > index) result[i - 1] = myList[i];
        }
        myList = result;
    }

    public int getSize() {
        return myList.length;
    }

    public boolean contains(E element) {
        for (Object e : myList) {
            if (e == element) return true;
        }
        return false;
    }

    public int indexOf(E element) {
        for (int i = 0; i < getSize(); i++) {
            if (myList[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E element) {
        for (Object e : myList) {
            if (e == element) return true;
        }
        return false;
    }

    public void ensureCapacity(int minCapacity) {
        int newSize = getSize() + 5;
        myList = new Object[newSize];
    }

    E get(int i){
        for (int j = 0; j < getSize(); j++) {
            if(i == j){
               return (E) myList[i];
            }
        }
        return null;
    }

    public void getInfo() {
        for (Object e : myList) {
            System.out.print(e + ", ");
        }
        System.out.print("\n");
    }

    public void clear(){
        Object[] result  = new Object[DEFAULT_CAPACITY];
        myList = result;
    }
}
