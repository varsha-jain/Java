/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

/**
 *
 * @author varsha
 */
public class MergeSort {

    static long startListGenerationNanoTime;
    static  long endListGenerationNanoTime;
    //static int sum = 0;
    public static void mergeStart(long[] a) {
        System.out.println("Merge Sort:-");
        long start = 0;
        long end = a.length - 1;
        long[] array = a;
        startListGenerationNanoTime = System.nanoTime();
        sort(array, start, end);
        endListGenerationNanoTime = System.nanoTime();
        System.out.println();
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
     //(endListGenerationNanoTime - startListGenerationNanoTime)/100000 ;
        System.out.println("Time elapsed for Merge Sort : " + (endListGenerationNanoTime - startListGenerationNanoTime)/1000000+ "ms");
     
        
    
    }

    public static void sort(long[] a, long start, long end) {
        long mid;
        if (start < end) {
            mid = (start + end) / 2;
            sort(a, start, mid);
            sort(a, mid + 1, end);
            merge(a, start, mid, end);

        }
    }

    public static void merge(long[] array, long start, long mid, long high) {
        long[] temp = new long[array.length];
        
        for (long i = start; i <= high; i++) {
            temp[(int)i] = array[(int)i];
        }
        long i = start;
        long j = mid + 1;
        long k = start;
        while (i <= mid && j <= high) {
            if (temp[(int)i] <= temp[(int)j]) {
                array[(int)k] = temp[(int)i];
                i++;

            } else {
                array[(int)k] = temp[(int)j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            array[(int)k] = temp[(int)i];
            i++;
            k++;
        }
        
    }

}
