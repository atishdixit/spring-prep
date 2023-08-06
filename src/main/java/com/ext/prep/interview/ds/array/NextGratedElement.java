package com.ext.prep.interview.ds.array;

import java.util.Stack;

public class NextGratedElement {

    public static void main(String[] args) {
        int array[] = {4, 5, 2, 25, 7, 8};
        int nge[] = getNextGtrElementOpt(array);
        for (int i = 0; i < 6; i++) {
            System.out.println(array[i] + " ==> " + (nge[i] == -1 ? -1 : array[nge[i]]));
        }

    }

    public static int getNextGtrElement(int element, int... elements) {
        int index = -1;
        for (int i = 0; i < elements.length; i++) {
            if (element == elements[i]) {
                index = i;
            }
        }

        int nextGraterElement = 0;
        for (int i = index; i < elements.length; i++) {
            if (elements[i] > element) {
                nextGraterElement = elements[i];
                break;
            }
        }

        return nextGraterElement;
    }

    public static int[] getNextGtrElementOpt(int... elements) {
        int nge[] = new int[elements.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < elements.length; i++) {
            while (!stack.empty() && (elements[i] > elements[stack.peek()])) {
                nge[stack.pop()] = i;
            }
            stack.push(i);
        }

        if (!stack.empty()) {
            while (!stack.empty()) {
                nge[stack.pop()] = -1;
            }
        }

        return nge;
    }
}
