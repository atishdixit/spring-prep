package com.ext.prep.interview.ds.precompute;

// Note why M=10^9+7
//Formulas
// (a+b)%M=> ((a%M)+(b%M))%M
// (a*b)%M=>((a%M)*(b%M))%M
// (a-b)%M=> ((a%M)-(b%M)+M)%M
// (a/b)%M=>((a%m)*(b pow-1)%M)%M

// M means modular(Its a prim number)

import java.math.BigInteger;
import java.util.stream.IntStream;

public class PrefixComputeTech {
    private int fact[] =  new int[Integer.MAX_VALUE];

    public static void main(String[] args) {
        IntStream.range(1,101).forEach(val->{
            System.out.println(factorial2(val));
        });
    }

    /**
     * Given a number N, Print its factorials.
     * Constraints
     *  1<=N<=100
     */

    /**
     * https://stackoverflow.com/questions/5317732/when-calculating-the-factorial-of-100-100-with-java-using-integers-i-get-0#:~:text=When%20doing%20this%3A,println(result)%3B
     */
    private static BigInteger factorial1(long n) {
        BigInteger result = BigInteger.ONE;
        for (long i = 2; i <= n; i++)
            result = result.multiply(BigInteger.valueOf(i));
        return result;
    }

    public static BigInteger factorial2(int num){
        if (num<=1)
            return BigInteger.ONE;
        else
            return factorial2(num-1).multiply(BigInteger.valueOf(num));
    }

    private static void factorial3(int n){
        long fact = 1;
        for(int i=2;i<=n;i++){
            fact*=i;
        }
        System.out.println(n+ " Factorials "+fact);
    }

/**
 * Given T test cases and in each test case a number N. Print its factorial for each test case %M
 * where M=10^9+7;
  */
    public static void solution(){

    }
}




