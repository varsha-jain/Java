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
public class DoubleHashing {

    private int[] table;
    private double lambda;
    private int countElement;
    private double newLambda;
    private int[] newElements;

    public DoubleHashing(int arraySize,double lambda) {
        table = new int[arraySize];
        Arrays.fill(table, -1);
        this.lambda = lambda;
    }

    public void add(int element) {

        int hash1 = element % table.length;
        //int hash2 = element % table.length;
        int primeSize = 9967;
        int hash2 = primeSize - (element % primeSize);
        int i=1;
        while (table[hash1] != -1) {
            //hash1 += hash2;
            int actualHash = (hash1+ i*hash2)%table.length;
            i++;
            hash1=actualHash;
        }
        table[hash1] = element;
    }

    public void put(int element) {
        countElement++;   
        newLambda = (double)countElement/(double)table.length;
        if(newLambda > lambda){
            System.out.println("Resizing the array for LoadFactor: " + newLambda);
            resize();
        }else{
            add(element);
        }

    }

    public void resize() {
        int length = (table.length*2);
        int[] oldElements = table;
        table = new int[length];
        
        //int total = countElement;
        countElement=0;
        Arrays.fill(table,-1);
        for(int i=0 ;i<oldElements.length ;i++){
            if(oldElements[i]!=-1)
                add(oldElements[i]);
        }

    }
    public int search(int element) {
       
        
        int primeSize = 9967;
        int hash1 = element % table.length;
        int hash2 = primeSize - (element % primeSize);
        int i=1;
        int countCollision = 0;
        int tempIndex = hash1;
        int output = 0;
        if (table[hash1] == element) {
             System.out.println("element found");
            output = hash1;
        } else {
            int temp = (hash1+ i*hash2)%table.length;
            hash1=temp;
            countCollision++;
            while (table[hash1] != element && hash1 != tempIndex) {
                
                temp = (hash1+ i*hash2)%table.length;
                i++;
                countCollision++;
                hash1= temp;
                //if index=size of the array
                //index = (index) % table.length; //linear probing

            }
            if (table[hash1] != element && hash1 == tempIndex) {
                output = -1;
            } else {
                System.out.println("element"+element+" found after collisions: " + countCollision);
                output = hash1;
            }

        }
        return output;
    }
}
