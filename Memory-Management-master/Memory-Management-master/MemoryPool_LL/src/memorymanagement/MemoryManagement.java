package memorymanagement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package memorymanagement;

import static memorymanagement.Utilities.queryMemory;

/**
 *
 * @author Soham
 */
public class MemoryManagement {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        
        long startNanoTime = System.nanoTime();
        long startListGenerationNanoTime = System.nanoTime();

        //memory generation
        LinkedList[] memoryBlock = new LinkedList[10];
        for (int i = 0; i < 10; i++) {
            memoryBlock[i] = new LinkedList();
            for (int j = 0; j < 100; j++) {
                memoryBlock[i].insertAtRear((int) Math.pow(2, i));
            }
        }
        System.out.println("-------MEMORY GENERATED IS-----");
        for (int i = 0; i < 10; i++) {
            memoryBlock[i].display(i);
        }

        long endListGenerationNanoTime = System.nanoTime();
        System.out.println(); 
        System.out.println("Time elapsed for Memory Generation : " + (endListGenerationNanoTime - startListGenerationNanoTime)/100000 + "ms");
        System.out.println();
        
        int failedRequest = 0;
        long startTimeAfterListGenerationNanoTime = System.nanoTime()/1000000;
        int counterFragmentation=0;
        
        //generating random data
        generationLoop:       
        for (int i = 0; i < 6400; i++) {
            int memoryNeeded = queryMemory();
            boolean requestFulfilled = false;

            //Allocating memory
            if (memoryBlock[memoryNeeded].getHead() != null) {
                memoryBlock[memoryNeeded].removeFromRear();
                requestFulfilled = true;
            } else if (memoryBlock[memoryNeeded].getHead() == null) {
                
                //fragmentation
                for (int j = memoryNeeded + 1 ; j <= 9; j++ ) {
                    if (memoryBlock[j].getHead() != null  && requestFulfilled == false) {
                        int count=1;
                        int n = memoryBlock[j].getRear().getBlockSize() / 2;
                        
                        while (n != Math.pow(2, memoryNeeded)) {
                            n = n / 2;
                            count++;
                            
                        }
                        
                        counterFragmentation += count;
                        memoryBlock[j].removeFromRear();
                        requestFulfilled = true;
                        for(int p=0;p<=count;p++)
                            memoryBlock[memoryNeeded].insertAtRear(n);

                        failedRequest++;
                        System.out.println("Current slot is out of memory, fragmenting.....");
                        System.out.println("Memory after fragmentation is available at location : " + j);

                    }
                    
                   // defragmentation
                } 
                if (memoryNeeded == 9 || requestFulfilled == false ) {
                    System.out.println("No higher memory available, defragmenting smaller memory blocks..");
                    failedRequest++;
                    int temp = 0;
                    for (int k = (memoryNeeded - 1); k >= 0; k--) {

                        if (memoryBlock[k].getHead() != null) {
                            while (memoryBlock[k].getHead() != null) {
                                if (temp < Math.pow(2, memoryNeeded)) {
                                    temp += memoryBlock[k].getRear().getBlockSize();
                                   System.out.println("Available memory to merge : ");
                                   memoryBlock[k].display(i);
                                   memoryBlock[k].removeFromRear();                                    
                                }
                                if (temp == Math.pow(2, memoryNeeded)) {
                                    break;
                                } else if (memoryBlock[k].getHead() == null) {
                                    failedRequest++;
                                }
                            }
                        } else if (memoryBlock[k].getHead() == null) {
                            failedRequest++;
                        }

                    }

                }
            }
            
            //check for remaining memory
            int counter = 0;
            for (int l = 0; l < 10; l++) {
                if (memoryBlock[l].getHead() == null) {
                    counter++;
                    if (counter == 10) {
                        System.out.println("Out of Memory. Your request cannot be completed!");
                        break generationLoop;
                    }
                }

            }

        }

        System.out.println("Final memory remaining after simulation :");
        for (int i = 0; i < 10; i++) {

            memoryBlock[i].display(i);
        }

        System.out.println(); 
        System.out.println("Total number of failed requests: " + failedRequest);
        System.out.println(); 
        System.out.println("Total number of timess fragmentation happened: " + counterFragmentation);
        long endTimeAfterLoopgenerationNanoTime = System.nanoTime()/1000000;
        
        long endNanoTime = System.nanoTime();
        System.out.println("Time elapsed for memomy management for requested memory : " + ( endTimeAfterLoopgenerationNanoTime-startTimeAfterListGenerationNanoTime) + " ms");
        System.out.println();      
        System.out.println("Total run time for the program : " + (endNanoTime - startNanoTime)/1000000 + " ms");

    }

    
}
