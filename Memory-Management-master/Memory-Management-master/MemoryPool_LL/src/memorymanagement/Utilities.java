package memorymanagement;

import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author varsha
 */
public class Utilities {
    public static int queryMemory() {
        Random random = new Random();
        int[] randomMemoryValue = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int memoryRequested = randomMemoryValue[random.nextInt(randomMemoryValue.length)];
        System.out.println("Requested memory is : " + memoryRequested);
        return memoryRequested;
    }
}
