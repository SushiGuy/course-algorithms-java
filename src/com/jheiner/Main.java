package com.jheiner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] lst = {4,9,7,1,3,6,5,17};
        //We could sort this array by simple doing:
        //Arrays.sort(lst);
        //System.out.println(Arrays.toString(lst));
        // print out [1,3,4,5,6,7,9]

        int stepCount;

        //But lets do it the hard way
        stepCount = selectionSort(lst);
        //stepCount = bubbleSort(lst);

        System.out.println(Arrays.toString(lst) + " array size " + Integer.toString(lst.length) + " (n) in " + Integer.toString(stepCount) + " steps");
    }

    static int selectionSort(int[] lst) {
        int stepCount = 0;
        int n = lst.length;
        //Fix: n - 1 to avoid sorting of the last item, otherwise it could be considered the "smallest" of that run
        for (int i = 0; i < n - 1; i++) {
            int currIndex = i;   //edX course had this = 0!!
            int smallest = lst[i];
            for (int j = i; j < n; j++){
                if (lst[j] < smallest){
                    smallest = lst[j];
                    currIndex = j;
                }
                stepCount++;
            }
            int temp = lst[i];
            lst[i] = smallest;
            lst[currIndex] = temp;
            stepCount++;
        }
        return stepCount;
    }

    static int bubbleSort(int[] lst) {
        int stepCount = 0;
        int n = lst.length;
        boolean swapped;
        do
        {
            swapped = false;
            for (int i = 0; i < n-1; i++) {
                if (lst[i] > lst[i+1]) {
                    int temp = lst[i];
                    lst[i] = lst[i+1];
                    lst[i+1] = temp;
                    swapped = true;
                }
                stepCount++;
            }
        } while (swapped == true);
        return stepCount;
    }
}
