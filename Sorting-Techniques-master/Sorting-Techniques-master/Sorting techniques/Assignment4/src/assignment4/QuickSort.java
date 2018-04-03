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
public class QuickSort {

    static long startListGenerationNanoTime;
    static  long endListGenerationNanoTime;
    public static void startQuickSort(long[] a) {
        //int[] a = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Quick Sort:-");
        int low = 0;
        int high = a.length - 1;
        //quickSortLastElement(a, low, high);
        //System.out.println("Last Element as pivot");
//        for (int i = 0; i < a.length; i++) {
//
//            System.out.print(a[i] + " ");
//        }
        System.out.println();
       // quickSortFirstElement(a, low, high);
       // System.out.println("First Element as pivot");
        //System.out.println();
        
        
//        for (int i = 0; i < a.length; i++) {
//
//            System.out.print(a[i] + " ");
//        }
        //System.out.println();
        startListGenerationNanoTime = System.nanoTime();
        quickSortMedianElement(a, low, high);
        endListGenerationNanoTime = System.nanoTime();
        System.out.println("Time elapsed for quick Sort with median element as pivot: " + (endListGenerationNanoTime - startListGenerationNanoTime)/1000000 + "ms");  
        
        
        //System.out.println("Median Element as pivot");
//        for (int i = 0; i < a.length; i++) {
//
//            System.out.print(a[i] + " ");
//        }
    }

    public static void quickSortLastElement(long[] a, int low, int high) {
        
        if (low >= high) {
            return;
        
        }
        
        int    j = partitionLastElement(a, low, high);
            quickSortLastElement(a, low, j - 1);
            quickSortLastElement(a, j + 1, high);
            
        
    }

    public static void quickSortMedianElement(long[] a, int low, int high) {
        if (low >= high) {
            return;
        
        }
        int j;
        
            j = partitionMedianElement(a, low, high);
            quickSortMedianElement(a, low, j - 1);
            quickSortMedianElement(a, j + 1, high);
        
    }

    public static void quickSortFirstElement(long[] a, int low, int high) {
        if (low >= high) {
            return;
        
        }
        int j;
        
            j = partitionFirstElement(a, low, high);
            quickSortFirstElement(a, low, j - 1);
            quickSortFirstElement(a, j + 1, high);
       
    }

    public static int partitionFirstElement(long[] a, int lb, int ub) {
        
        long x ,temp;
        int down, up;
        x = a[lb]; //last element as pivot
        up = ub;
        down = lb;
        while (down < up) {
            while (a[down] <= x && down < ub) {
                down++;
            }
            while (a[up] > x) {
                up--;
            }
            if (down < up) {
                temp = a[down];
                a[down] = a[up];
                a[up] = temp;

            }
        }
        temp = a[lb];
        a[lb] = a[up];
        a[up] = temp;
        
        return  up;
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
//        temp = a[lb];
//        a[lb]=a[up];
//        a[up] = temp;

        return down;
    }

    public static int partitionLastElement(long[] a, int lb, int ub) {
        long x,  temp;
        int down, up;
        x = a[ub]; //last element as pivot
        up = ub;
        down = lb - 1;
        while (down < up) {
            while (a[++down] <= x && down < ub) {
                //down++;
            }
            while (a[--up] > x && up > lb) {
                //up--;
            }
            if (down < up) {
                temp = a[down];
                a[down] = a[up];
                a[up] = temp;

            }
        }
        temp = a[ub];
        a[ub] = a[down];
        a[down] = temp;
        return down;
    }
}
