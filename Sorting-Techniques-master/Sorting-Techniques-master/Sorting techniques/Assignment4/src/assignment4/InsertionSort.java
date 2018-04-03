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
public class InsertionSort {

    static long startListGenerationNanoTime;
    static long endListGenerationNanoTime;

    public static void startInsertionSort(long[] a) {
        //int[] a = {4, 3, 5, 2, 6, 7, 1};
        System.out.println("Insertion Sort:-");
        startListGenerationNanoTime = System.nanoTime();
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    long temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
        endListGenerationNanoTime = System.nanoTime();
        System.out.println();
        System.out.println("Time elapsed for Insertion Sort : " + (endListGenerationNanoTime - startListGenerationNanoTime) / 100000 + "ms");

//        for (int t = 0; t < a.length; t++) {
//            System.out.print(a[t] + " ");
//        }
    }
}
