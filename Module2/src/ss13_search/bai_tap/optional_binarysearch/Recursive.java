package ss13_search.bai_tap.optional_binarysearch;

import java.util.Arrays;

import static java.util.Arrays.sort;

public class Recursive {
    public static void main(String[] args) {
        int[] numbers = {1,3,5,4,3,2};
        sort(numbers);
        System.out.println(Arrays.toString(numbers));
        System.out.println(searchByRecursive(numbers,0,numbers.length-1,4));

    }
    static int searchByRecursive(int[] numbs, int left, int right, int value){
        int root = (left + right)/2;
        if (value == numbs[root]){
            return root;
        }
        if (value > numbs[root]){
            return searchByRecursive(numbs,root+1,right,value);
        }
        if (value < numbs[root]){
            return searchByRecursive(numbs,root-1,right,value);
        }
        return -1;
    }
}
