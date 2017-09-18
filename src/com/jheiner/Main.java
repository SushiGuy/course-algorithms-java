package com.jheiner;
import java.util.Arrays;

public class Main {

    static int mergeSortStepCount = 0;
    static int binarySearchStepCount = 0;

    public static void main(String[] args) {
        //int[] array = {4,9,7,1,3,6,5};
        int[] array = {98,4,9,7,1,22,3,6,5,17};   //For sort algorithms
        int[] sortedArray = {1, 3, 4, 5, 6, 7, 9, 17, 22, 98};   //For search algorithms
        //int[] lst = {9,5,7,3,6,2,1};   //For this array Selection sort beats Bubble sort
        //We could sort this array by simple doing:
        //Arrays.sort(lst);
        //System.out.println(Arrays.toString(lst));
        // print out [1,3,4,5,6,7,9]

        //But lets do it the hard way to learn some things
        int stepCount;

        int[] ssLst = array.clone();
        stepCount = selectionSort(ssLst);
        System.out.println("Selection sort: Array(" + Integer.toString(ssLst.length) + ") took "
                + Integer.toString(stepCount) + " steps " + Arrays.toString(ssLst));

        // Bubble Sort - O(n^2) "O of n squared"
        // O(1) space. That is, regardless of how big our input is, the amount of extra space it takes is constant. In this case, the amount is actually 0.
        int[] bsLst = array.clone();
        stepCount = bubbleSort(bsLst);
        System.out.println("Bubble sort   : Array(" + Integer.toString(bsLst.length) + ") took "
                + Integer.toString(stepCount) + " steps " + Arrays.toString(bsLst));

        // Merge Sort - O(n log(n)) "O of n log n"
        // For a large input of n, an O(n log(n)) algorithm outperforms an O(n^2) algorithm significantly, because nlog(n) grows much slower than n^2.
        // While Merge Sort is a lot faster, it is important to note that it takes a lot more space. In Bubble Sort, we don't utilize extra space at all
        // Space: O(n)
        /*int[] msLst = lst.clone();
        mergeSort(msLst);
        System.out.println("Merge sort   : Array(" + Integer.toString(msLst.length) + ") took "
                + Integer.toString(mergeSortStepCount) + " steps " + Arrays.toString(msLst));*/

        //Binary search - O (log(n)), pass in a sorted array (faster than linear search)
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

    /* Sample didn't work :(
    static int[] mergeSort(int[] lst) {
        //...

        // recursively split and merge
        left = mergeSort(left);
        right = mergeSort(right);

        // merge
        return merge(left, right);
    }

    // the function for merging two sorted arrays
    static int[] merge(int[] left, int[] right) {
        //...
    }*/

    //static int binarySearch(int v, int[] lst, int low, int high) {
        //...
        //if (v == lst[middle]) {
            //return middle;
        //}
        //else if (v > lst[middle]) {
            //return binarySearch(v, lst, middle+1, high);
        //}
        //else {
            //return binarySearch(v, lst, low, middle-1);
        //}
    //}
}
