package com.ext.prep.interview.ds.array;

import java.util.ArrayList;
import java.util.List;

public class Union {
    public static void main(String[] args) {
        int a[]={1,3,2,4,5,6,7};
        int b[]={1,9,4,6,7,8,4};

        List<Integer> list  = new ArrayList<>();

        for (int x: a){
            list.add(x);
        }

        for (int x: b){
            if (!list.contains(x)) {
                list.add(x);
            }
        }
        System.out.println(list);
    }
}
