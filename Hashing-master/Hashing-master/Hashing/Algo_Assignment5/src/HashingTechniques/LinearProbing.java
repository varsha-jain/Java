/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashingTechniques;

import java.util.Arrays;

/**
 *
 * @author varsha
 */
public class LinearProbing {

    private int[] table;
    private double lambda;
    private int countElement;
    private int newCountElelment;
    private double newLambda;
    private int[] newElements;
    private int[] newTable;
    private static int t = 0;
    private int ele = 0;

    // private int[] oldElements;
    public LinearProbing(int arraySize, double lambda) {
        table = new int[arraySize];
        newTable = new int[arraySize * 3];

        //Arrays.fill(oldElements,-1);
        Arrays.fill(table, -1);
        Arrays.fill(newTable, -1);
        this.lambda = lambda;
    }

    public void add(int element) {

        int index = (element) % table.length;
        while (table[index] != -1) {
            ++index;
            //if index=size of the array
            index = (index) % table.length; //linear probing

        }
        table[index] = element; //insert the element as soon as empty spot is found
        ele++;
    }

    public void put(int element) {
        countElement++;
        newLambda = (double) countElement / (double) table.length;
        if (newLambda > lambda) {
            System.out.println("Resizing the array for LoadFactor: " + newLambda);
            resize();
        } else {
            add(element);
        }

    }

    public void put2(int element) {
        countElement++;
        newLambda = (double) countElement / (double) table.length;
        if (newLambda > 0.5) {
            //add2(element);
            //System.out.println("Inserting in new array for LoadFactor: " + newLambda);

            //add elements from old table
            //add2(oldElements[t++]); //first add old table element
            add2(element);//then add new table element
            

           // for (int j = 0; j < table.length; j++) {
                if (t < table.length) {
                    if (table[t] != -1) {
                        //add2(table[t]);
                        int index = (table[t]) % newTable.length;
                        while (newTable[index] != -1) {
                            ++index;
                            index = (index) % newTable.length;
                        }
                        newTable[index] = element;
                        ele--;
                    }
                    t++;

                }
           // }

        } else {
            add(element);
        }

    }

    public void add2(int element) {

        int index = (element) % newTable.length;
        while (newTable[index] != -1) {
            ++index;
            //if index=size of the array
            index = (index) % newTable.length; //linear probing

        }
        newTable[index] = element; //insert the element as soon as empty spot is found

    }

    public void resize() {
        int length = (table.length * 2);
        int[] oldElements = table;
        table = new int[length];

        //int total = countElement;
        countElement = 0;
        Arrays.fill(table, -1);
        for (int i = 0; i < oldElements.length; i++) {
            if (oldElements[i] != -1) {
                add(oldElements[i]);
            }
        }

    }

    public void print() {
        System.out.println("original small table!");
        for (int i : table) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("New bigger table!");
        for (int i : newTable) {
            System.out.print(i + " ");
        }
    }

    public int search(int element) {
        int index = (element) % table.length;
        int countCollision = 0;
        int tempIndex = index;
        int output = 0;
        if (table[index] == element) {
             System.out.println("element found");
            output = index;
            //return output;
        } else {
            ++index;
            countCollision++;
            while (table[index] != element && index != tempIndex) {
                ++index;
                countCollision++;
                //if index=size of the array
                index = (index) % table.length; //linear probing

            }
            if (table[index] != element && index == tempIndex) {
                output = -1;
            } else {
                System.out.println("element "+ element + " found after collisions: " + countCollision);
                output = index;
            }

        }

        //table[index] = element; //insert the element as soon as empty spot is found
        return output;
    }
}
