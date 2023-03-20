package ss11_queue_stack.bai_tap.optional_demerging;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.*;

public class Demerging {
    static List<Person> list = new LinkedList<>();

    public static void main(String[] args) {
        list.add(new Person("Tuan","Nam","14/4/1990"));
        list.add(new Person("Nhan","Nam","12/4/1994"));
        list.add(new Person("Khai","Nam","06/07/1995"));
        list.add(new Person("aaa","Nu","13/2/1990"));
        list.add(new Person("ddd","Nu","16/1/1996"));
        list.add(new Person("sss","Nu","16/07/1993"));

        Collections.sort(list);

        for (Person person:list) {
            System.out.println(person);
        }
    }
}
