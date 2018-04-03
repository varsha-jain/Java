/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment4;

import java.util.ArrayList;

/**
 *
 * @author varsha
 */
public class Assignment4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //int[] a = {3, 1, 5, 6, 2, 2}; //change to random 
        ArrayList<long[]> list = new ArrayList<>();

        long[] a;  //randomly shuffled array
        int temp = 10000;
        for (int i = 0; i < 100; i++) {
            a = Utilities.arrayGeneratorOfRandomNumbers(temp);
            temp = temp + 10000;
            list.add(a);
        }
        long[] a2;
        ArrayList<long[]> list2 = new ArrayList<>();
        int temp2 = 10000;
        for (int i = 0; i < 100; i++) {
            a2 = Utilities.arrayGeneratorPartiallySorted(temp2); //partially sorted array
            temp2 = temp2 + 10000;
            list2.add(a2);
        }
        long[] a1;
        ArrayList<long[]> list1 = new ArrayList<>();
        int temp1 = 10000;
        for (int i = 0; i < 100; i++) {
            a1 = Utilities.arrayGeneratorAscending(temp1); //sorted ascending order array
            temp1 = temp1 + 10000;
            list1.add(a1);
        }
        ///////////////////////////////////////
        /* for (int count = 0; count < 3; count++) {
            System.out.println("**Running Loop for count: **" + count);
            System.out.println();
            System.out.println("******Average Case Performance for each algorithm:****");
            System.out.println();
            for (long[] array : list) {
                System.out.println("Data Size: " + array.length);
                MergeSort.mergeStart(array);
                System.out.println();
                SelectionSort.startSelectionSort(array);
                System.out.println();
                QuickSort.startQuickSort(array);
                System.out.println();
                InsertionSort.startInsertionSort(array);
                System.out.println();
                HeapSort.startHeapSort(array);
                
                System.out.println();
                QuickInsertion.startQuickInsertion(array);
            }
            System.out.println();

            System.out.println("******Best Case Performance for each algorithm:*********");
            System.out.println();

            for (long[] array1 : list1) {
                System.out.println("Data Size: " + array1.length);
                MergeSort.mergeStart(array1);
                System.out.println();
                SelectionSort.startSelectionSort(array1);
                System.out.println();
                QuickSort.startQuickSort(array1);
                System.out.println();
                InsertionSort.startInsertionSort(array1);
                System.out.println();
                HeapSort.startHeapSort(array1);
                
                System.out.println();
                QuickInsertion.startQuickInsertion(array1);
            }

            System.out.println("********Worst Case Performance for each algorithm:******");
            System.out.println();
            for (long[] array2 : list2) {
                MergeSort.mergeStart(array2);
                System.out.println();
                SelectionSort.startSelectionSort(array2);
                System.out.println();
                QuickSort.startQuickSort(array2);
                System.out.println();
                InsertionSort.startInsertionSort(array2);
                System.out.println();
                HeapSort.startHeapSort(array2);
                
                System.out.println();
                QuickInsertion.startQuickInsertion(array2);
            }
        }*/
        /////////////////////////
       /* int n = 10000;
        int avg = 0;
        int sum = 0;
        for (int count = 1; count <= 100; count++) {
            System.out.println("******partially Case Performance for each algorithm:****");
            System.out.println("Data Size: " + n);
            System.out.println();
            long[] array = Utilities.arrayGeneratorPartiallySorted(n);
            for (int i = 0; i < 10; i++) {

                HeapSort.startHeapSort(array);
            }

            n = n + 10000;
        }*/

        /*for (int count = 1; count < 4; count++) {
            System.out.println("******Average Case Performance for each algorithm:****");
            System.out.println();
            for (long[] array : list) {
                System.out.println("Data Size: " + array.length);
                SelectionSort.startSelectionSort(array);

            }
        }
        
        for (int count = 1; count < 4; count++) {
            System.out.println("******Average Case Performance for each algorithm:****");
            System.out.println();
            for (long[] array : list) {
                System.out.println("Data Size: " + array.length);
                //System.out.println();
                QuickSort.startQuickSort(array);

            }
        }
        
        for (int count = 1; count < 4; count++) {
            System.out.println("******Average Case Performance for each algorithm:****");
            System.out.println();
            for (long[] array : list) {
                System.out.println("Data Size: " + array.length);
                InsertionSort.startInsertionSort(array);

            }
        }
        
        for (int count = 1; count < 4; count++) {
            System.out.println("******Average Case Performance for each algorithm:****");
            System.out.println();
            for (long[] array : list) {
                System.out.println("Data Size: " + array.length);
                HeapSort.startHeapSort(array);

            }
        }
        
        for (int count = 1; count < 4; count++) {
            System.out.println("******Average Case Performance for each algorithm:****");
            System.out.println();
            for (long[] array : list) {
                System.out.println("Data Size: " + array.length);
                QuickInsertion.startQuickInsertion(array);

            }
        }
        
        /////////////////////////
        for (int count = 1; count < 4; count++) {
            System.out.println("******Best Case Performance for each algorithm:*********");
            System.out.println();
            for (long[] array1 : list1) {
                System.out.println("Data Size: " + array1.length);
                MergeSort.mergeStart(array1);

            }
        }
        
        for (int count = 1; count < 4; count++) {
            System.out.println("******Best Case Performance for each algorithm:*********");
            System.out.println();
             for (long[] array1 : list1) {
                System.out.println("Data Size: " + array1.length);
                SelectionSort.startSelectionSort(array1);

            }
        }
        
        for (int count = 1; count < 4; count++) {
            System.out.println("******Best Case Performance for each algorithm:*********");
            System.out.println();
             for (long[] array1 : list1) {
                System.out.println("Data Size: " + array1.length);
                //System.out.println();
                QuickSort.startQuickSort(array1);

            }
        }
        
        for (int count = 1; count < 4; count++) {
            System.out.println("******Best Case Performance for each algorithm:*********");
            System.out.println();
            for (long[] array1 : list1) {
                System.out.println("Data Size: " + array1.length);
                InsertionSort.startInsertionSort(array1);

            }
        }
        
        for (int count = 1; count < 4; count++) {
            System.out.println("******Best Case Performance for each algorithm:*********");
            System.out.println();
            for (long[] array1 : list1) {
                System.out.println("Data Size: " + array1.length);
                HeapSort.startHeapSort(array1);

            }
        }
        
        for (int count = 1; count < 4; count++) {
           System.out.println("******Best Case Performance for each algorithm:*********");
            System.out.println();
            for (long[] array1 : list1) {
                System.out.println("Data Size: " + array1.length);
                QuickInsertion.startQuickInsertion(array1);

            }
        }

        /////////////////////////
        for (int count = 1; count < 4; count++) {
            System.out.println("******Worst Case Performance for each algorithm:*********");
            System.out.println();
            for (long[] array2 : list2) {
                System.out.println("Data Size: " + array2.length);
                MergeSort.mergeStart(array2);

            }
        }
        
        for (int count = 1; count < 4; count++) {
            System.out.println("******Worst Case Performance for each algorithm:*********");
            System.out.println();
             for (long[] array2 : list2) {
                System.out.println("Data Size: " + array2.length);
                SelectionSort.startSelectionSort(array2);

            }
        }
        
        for (int count = 1; count < 4; count++) {
            System.out.println("******Worst Case Performance for each algorithm:*********");
            System.out.println();
             for (long[] array2 : list2) {
                System.out.println("Data Size: " + array2.length);
                //System.out.println();
                QuickSort.startQuickSort(array2);

            }
        }
        
        for (int count = 1; count < 4; count++) {
        System.out.println("******Worst Case Performance for each algorithm:*********");
            System.out.println();
            for (long[] array2 : list2) {
                System.out.println("Data Size: " + array2.length);
                InsertionSort.startInsertionSort(array2);

            }
        }
        
        for (int count = 1; count < 4; count++) {
            System.out.println("******Worst Case Performance for each algorithm:*********");
            System.out.println();
            for (long[] array2 : list2) {
                System.out.println("Data Size: " + array2.length);
                HeapSort.startHeapSort(array2);

            }
        }
        
        for (int count = 1; count < 4; count++) {
           System.out.println("******Worst Case Performance for each algorithm:*********");
            System.out.println();
            for (long[] array2 : list2) {
                System.out.println("Data Size: " + array2.length);
                QuickInsertion.startQuickInsertion(array2);

            }
        }


    }*/
        //for (int count = 1; count < 4; count++) {
           System.out.println("******Best Case Performance for each algorithm:*********");
            System.out.println();
            for (long[] array1 : list) {
                System.out.println("Data Size: " + array1.length);
                QuickInsertion.startQuickInsertion(array1);

            }
        //}
    }
}
