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
public class SelectionSort {
    static long startListGenerationNanoTime;
    static  long endListGenerationNanoTime;

    public static void startSelectionSort(long[] array) {
        //int[] array = {5,6,3,7,1,4};
        System.out.println("Selection Sort:-");
        int minIndex =0 ;
        long min ;
        long temp ;
        startListGenerationNanoTime = System.nanoTime();
        for (int i = 0; i < array.length; i++) {
            min = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] < min) { //ascending order
                    min = array[j];
                    minIndex = j;
                }
            }
            if (min > array[i]) {

                temp = array[i];
                array[i] = array[minIndex];
                array[minIndex] = temp;

            }
        }
        endListGenerationNanoTime = System.nanoTime();
        System.out.println();
        System.out.println("Time elapsed for Selection Sort : " + (endListGenerationNanoTime - startListGenerationNanoTime) / 1000000 + "ms");
//        for (int i = 0; i < array.length; i++) {
//            System.out.print(array[i] + " ");
//        }
    }
}
