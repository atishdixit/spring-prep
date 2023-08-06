package com.ext.prep.interview.ds.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// https://www.hackerrank.com/challenges/balanced-brackets/problem
public class StackProblems {
    private static Map<Character, Integer> brackets = new HashMap<>();

    static {
        brackets.put('[', 1);
        brackets.put(']', -1);
        brackets.put('{', 2);
        brackets.put('}', -2);
        brackets.put('(', 3);
        brackets.put(')', -3);
    }

    public static void main(String[] args) {
        System.out.println(isBalancedBrackets("{{[[(())]]}}]"));
    }

    public static boolean isBalancedBrackets(String expression) {
        char[] expr = expression.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char ch : expr) {
            if (isOpening(ch)) {
                stack.push(ch);
            } else {
                if (stack.empty()) return false;
                char thisChar = stack.pop();
                if (getValue(thisChar) + getValue(ch) != 0) return false;
            }
        }

        return stack.empty();
    }

    private static boolean isOpening(char ch) {
        return brackets.get(ch) > 0;
    }

    private static boolean isClosing(char ch) {
        return brackets.get(ch) < 0;
    }

    private static int getValue(char ch) {
        return brackets.get(ch);
    }


}
