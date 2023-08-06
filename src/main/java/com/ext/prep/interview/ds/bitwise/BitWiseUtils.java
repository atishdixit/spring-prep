package com.ext.prep.interview.ds.bitwise;

import java.util.ArrayList;
import java.util.List;

public class BitWiseUtils {

    public static void printBinary(int number){
        printBinary(number, 10);
    }

    public static void printBinary(int number, int length){
        for (int i=length; i>=0; --i){
            System.out.print(number>>i&1);
        }
        System.out.println();
    }

    public static boolean isSetBit(int number, int pos){
        return (number &(1<<pos))!=0;
    }

    public static boolean isEven(int number){
        return (number&1)==0;
    }

    public static boolean isOdd(int number){
        return !isEven(number);
    }

    public static int revers(int number){
        return ~number;
    }

    public static int setBit(int number, int pos, boolean isSet){
        int setBitAtPosition = 1<<pos;
        return isSet? (number| setBitAtPosition) : (number&revers(setBitAtPosition)) ;
    }

    public static int countSetBits(int number){
        return countSetBits(number, 10);
    }

    public static int countSetBits(int number, int length){
        int count=0;
        for (int i = length; i>=0;--i){
            if(isSetBit(number, i)){
                count++;
            }
        }
        return count;
    }

    public static void swap(int a, int b){
        a= a^b;
        b=b^a;
        a=a^b;
    }

   public static void divideBy2(int num){
       System.out.println(num>>1);
    }


    public static void multiplyBy2(int num){
        System.out.println(num<<1);
    }



    public static char toLowerCase(char ch){
        if (ch>='A' && ch<='A'){
            ch= (char) (ch|1<<5);
        }
        return ch;
    }

    public static char toUpperCase(char ch){
        if (ch>='a' && ch<='b'){
            ch= (char) (ch &(~(1<<5)));
        }
        return ch;
    }

    public static boolean isGivenNumberPowerOf2(int num){
           return (num & (num-1))==0;
    }

    public static void findAllOddNumber(int... nums){
        for (int i:nums){
            if(isOdd(i)){
                System.out.println(i);
            }
        }
    }

    public static void findAllEvenNumber(int... nums){
        for (int i:nums){
            if(isEven(i)){
                System.out.println(i);
            }
        }
    }


    public static void findDuplicates(int... nums){
      List<Integer> list = new ArrayList<>(nums.length);
        for (int i=0;i<nums.length;i++){
            int data = nums[i];
            for (int j=0;j<nums.length;j++){
                if (i==j) continue;
                if(((data^nums[j])==0)&& !list.contains(data)){
                    list.add(data);
                    break;
                }
            }
        }

        System.out.println(list);
    }

}
