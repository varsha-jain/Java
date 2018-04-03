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
public class QuickInsertion {
    static long startListGenerationNanoTime;
    static  long endListGenerationNanoTime;
    public static void startQuickInsertion(long[] array){
        System.out.println("Combination:-");
        int low = 0;
        int high = array.length - 1;
        startListGenerationNanoTime = System.nanoTime();
        quickSortMedianElement(array, low, high);
        endListGenerationNanoTime = System.nanoTime();
//        System.out.println();
//        for(int i = 0 ; i < array.length ; i++){
//            System.out.print(array[i] + " ");
//        }
        System.out.println();
         System.out.println("Time elapsed for Selection Sort : " + (endListGenerationNanoTime - startListGenerationNanoTime) / 1000000 + "ms");
    }
    public static void quickSortMedianElement(long[] array, int low, int high) {
        if (low >= high) {
            return;
        
        }
        else if(low < high){
            if((high - low) < 9){
                
                insertionSort(array, low, high+1);
            }else
            {
                int j;
        
            j = partitionMedianElement(array, low, high);
            quickSortMedianElement(array, low, j - 1);
            quickSortMedianElement(array, j + 1, high);
        
            }
        }
        
    }
    public static int partitionMedianElement(long[] a, int lb, int ub) {
        long x;
        int down, up;
        x = a[(lb + ub) / 2]; //median element as pivot
        up = ub;
        down = lb;
        while (down <= up) {
            while (a[down] < x) {
                down++;
            }
            while (a[up] > x) {
                up--;
            }
            if (down <= up) {
                long temp = a[down];
                a[down] = a[up];
                a[up] = temp;
                
                down ++;
                up--;

            }
        }

        return down;
    }
    public static void insertionSort(long[] array, int start, int end){
        for (int x = start + 1; x < end; x++)
        {
            long val = array[x];
            int j = x-1;
            while (j >= 0 && val < array[j])
            {
                array[j + 1] = array[j];
               j--;
            }
            array[j + 1] = val;
        }
    }
    
}
