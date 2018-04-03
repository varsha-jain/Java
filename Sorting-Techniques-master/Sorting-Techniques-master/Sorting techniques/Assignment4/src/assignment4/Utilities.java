package assignment4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
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
    public static long[] arrayGeneratorOfRandomNumbers(long temp) {
        Random random = new Random();
        long max = 5; long min = 1;
        //int[] randomValue = new int[5];
        //int temp = 100;
        long[] randomValue = new long[(int)temp];
        
        for(int i=0 ; i<temp;  i++){
            
            randomValue[i]= (long)(Math.random()*(max-min)) + min;
            
        }
        int n = randomValue.length;
        //shuffle array using Knuth's shuffle algorithm  
        for(int i = n-1 ; i > 0; i-- ){
                      //(long)(Math.random()*(max-min)) + min;

            int j = (int) (Math.random() * (i + 1));
            long temp1 = randomValue[i];
            randomValue[i] = randomValue[j];
            randomValue[j] = temp1;
        }
        return randomValue;
    }
    public static long[] arrayGeneratorAscending(long temp) {
        Random random = new Random();
        long max = 5; long min = 1;
        long[] randomValue = new long[(int)temp];
        for(int i=0 ; i<temp;  i++){
            randomValue[i]= (long)(Math.random()*(max-min)) + min;
        }
        
        Arrays.sort(randomValue);
        return randomValue;
    }
    public static long[] arrayGeneratorPartiallySorted(long temp) {
        Random random = new Random();
        long max = 25; long min = 1;
        long[] randomValue = new long[(int)temp];
        for(int i=0 ; i<temp;  i++){
            randomValue[i]= (long)(Math.random()*(max-min)) + min;
        }
        Arrays.sort(randomValue);
        int n = randomValue.length;
        
        long max1 = temp;
        long min1 = temp/2;
        //shuffle array using Knuth's shuffle algorithm  
        for(int i = n-1 ; i > n/2; i-- ){
            long j = (long)(Math.random()*(max1-min1)) + min1;
            long temp1 = randomValue[i];
            randomValue[(int)i] = randomValue[(int)j];
            randomValue[(int)j] = temp1;
        }
        return randomValue;
    }
}
