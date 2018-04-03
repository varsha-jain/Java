/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashingTechniques;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author varsha
 */
public class HashingTechniques {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] elements = arrayGenerator(23);
        //int[] newElements = arrayGenerator(11);

        LinearProbing linear;
        QuadraticProbing quadratic;
        DoubleHashing doubleHashing;
        //linear probing
        System.out.println("***Linear Probing***");
        long startLinearProbingMain = System.nanoTime();
        for (double i = 0.1; i < 0.98; i = i + 0.1) {
            long startLinearProbing = System.nanoTime();

            linear = new LinearProbing(elements.length, i);
            for (int j = 0; j < elements.length; j++) {

                linear.put(elements[j]);
            }
            long endLinearProbing = System.nanoTime();
            System.out.println("Total time to insert " + elements.length + " elements is: " + (endLinearProbing - startLinearProbing) / 1000000 + " ms");

            //int result = linear.search(elements[999]);
            //System.out.println("value "+ elements[999] + " found at location " + result);
        }
        long endLinearProbingMain = System.nanoTime();
        System.out.println("Total time for Linear Probing: " + elements.length + " elements is: " + (endLinearProbingMain - startLinearProbingMain) / 1000000 + " ms");

        //Quadratic probing
        System.out.println();
        System.out.println("***Quadratic Probing***");
        for (double i = 0.1; i < 0.98; i = i + 0.1) {
            long startQuadProbing = System.nanoTime();

            quadratic = new QuadraticProbing(elements.length, i);
            for (int j = 0; j < elements.length; j++) {

                quadratic.put(elements[j]);
            }
            long endQuadProbing = System.nanoTime();
            System.out.println("Total time to insert " + elements.length + " elements is: " + (endQuadProbing - startQuadProbing) / 1000000 + " ms");

        }
        //Double Hashing
        /* System.out.println();
        System.out.println("***Double Hashing***");
        for (double i = 0.1; i < 0.98; i = i + 0.1) {
            long startDoubleHashing = System.nanoTime();
            doubleHashing = new DoubleHashing(elements.length, i);

            for (int j = 0; j < elements.length; j++) {

                doubleHashing.put(elements[j]);
            }
            long endDoubleHashing = System.nanoTime();
            System.out.println("Total time to insert " + elements.length + " elements is: " + (endDoubleHashing - startDoubleHashing) / 1000000 + " ms");

        }*/

        //we have load factor as 0.5 for linear probing, we then insert data 
        //into table and implement search function
        LinearProbing linear1;
        System.out.println("////Linear Probing Search ////"); //part1
        //long startLinearProbing1 = System.nanoTime();
        linear1 = new LinearProbing(elements.length, 0.5);
        for (int j = 0; j < elements.length; j++) {

            linear1.put(elements[j]);
        }
        for (int i = 0; i < elements.length; i++) {
            int result = linear1.search(elements[i]);
            System.out.println("value " + elements[i] + " found at location " + result);
        }

        //search for quadratic probing
        QuadraticProbing quad = new QuadraticProbing(elements.length, 0.5);
        System.out.println();
        System.out.println("***Quadratic Probing Search!!****");
        for (int i = 0; i < elements.length; i++) {
            quad.put(elements[i]);
        }
        for(int i=0; i<elements.length ;i++){
        int op = quad.search(elements[i]);
        //System.out.println();
        System.out.println("value " + elements[i] + " found at location: " + op);
        }

        //search for double hashing
        System.out.println("Double hashing search****");
        DoubleHashing dh = new DoubleHashing(elements.length, 0.5);
        for (int i = 0; i < elements.length; i++) {
            dh.put(elements[i]);
        }
        for (int i = 0; i < elements.length; i++) {
            int oph = dh.search(elements[i]);
            System.out.println("value found at location: " + oph);
        }

        //part-2
        LinearProbing linear2;
        System.out.println("////Linear Probingpart-2////");
        linear2 = new LinearProbing(elements.length, 0.6);
        //for (double i = 0.1; i < 0.98; i = i + 0.1) {
        long startLinearProbing2 = System.nanoTime();
        for (int j = 0; j < elements.length; j++) {
            linear2.put2(elements[j]);
        }
        long endLinearProbing2 = System.nanoTime();
        System.out.println("Total time to insert " + elements.length + " elements is: " + (endLinearProbing2 - startLinearProbing2) / 1000000 + " ms");

        //}
        //linear2.print();
    }

    public static int[] arrayGenerator(int valueSize) {
        Random random = new Random();
        int max = 999999;
        int min = 100;
        int[] randomValue = new int[valueSize];
        for (int i = 0; i < valueSize; i++) {
            randomValue[i] = (int) (Math.random() * (max - min)) + min;
        }

        return randomValue;
    }

}
