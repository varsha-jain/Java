/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

//import static assignment4.MergeSort.endListGenerationNanoTime;

/**
 *
 * @author varsha
 */
public class HeapSort {

    private static int n;

    static long startListGenerationNanoTime;
    static  long endListGenerationNanoTime;
    public static void startHeapSort(long[] a) {
        //int[] a = {23, 55, 93, 42, 65, 86};
        System.out.println("Heap Sort:-");
        startListGenerationNanoTime = System.nanoTime();
        sort(a);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }
 endListGenerationNanoTime = System.nanoTime();
        System.out.println();
        System.out.println("Time elapsed for Heap Sort : " + (endListGenerationNanoTime - startListGenerationNanoTime)/1000000 + "ms");
    }

    public static void sort(long[] a) {
        heapify(a);
        //int n = a.length-1;
        for (int i = n; i > 0; i--) {
            long temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            n = n - 1;
            maxHeap(a, 0);
        }
    }

    public static void heapify(long[] a) {
        n = a.length - 1;
        for (int i = n / 2; i >= 0; i--) {
            maxHeap(a, i);
        }
    }

    public static void maxHeap(long[] a, int i) {
        
        int left = 2 * i;
        int right = 2 * i + 1;
        int max = i;
        if (left <= n && a[left] > a[i]) {
            max = left;

        }
        if (right <= n && a[right] > a[max]) {
            max = right;
        }
        if (max != i) {
            long temp = a[i];
            a[i] = a[max];
            a[max] = temp;
            maxHeap(a, max);
        }
       
    }

}
