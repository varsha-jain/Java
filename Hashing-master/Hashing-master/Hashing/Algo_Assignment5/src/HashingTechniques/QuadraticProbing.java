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
public class QuadraticProbing {

    private int[] table;
    private double lambda;
    private int countElement;
    private double newLambda;
    private int[] newElements;
    public QuadraticProbing(int arraySize,double lambda) {
        table = new int[arraySize];
        Arrays.fill(table, -1);
        this.lambda = lambda;
    }
    public void add(int element){
        int h = 1;
        
        int index = (element) % table.length;
        int temp = index;
            while (table[temp] != -1) {
                //++index;
                
                
                temp = (index + h * h) % table.length; 
                h++;
            }
            table[temp] = element;
        
    }
    public void put(int element){
        countElement++;   
        newLambda = (double)countElement/(double)table.length;
        if(newLambda > lambda){
            System.out.println("Resizing the array for LoadFactor: " + newLambda);
            resize();
        }else{
            add(element);
        }
    }
    public void resize(){
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
        int index = (element) % table.length;
        int h = 1;
        int countCollision = 0;
        int tempIndex = index;
        int output = 0;
        if (table[index] == element) {
             System.out.println("element found");
            output = index;
        } else {
            
            int temp = (index + h * h) % table.length;;
            countCollision++;
            while (table[temp] != element && temp != tempIndex) {
                temp = (index + h * h) % table.length; //linear probing
                h++;
                countCollision++;
                //if index=size of the array
                //index = (index) % table.length; //linear probing

            }
            if (table[temp] != element && temp == tempIndex) {
                output = -1;
            } else {
                System.out.println("element"+element+" found after collisions: " + countCollision);
                output = index;
            }

        }
        return output;
    }
}
