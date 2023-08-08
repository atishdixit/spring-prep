package com.ext.prep.interview.ds.search;

/**
 * Monotonic function means which always in same order(Like always increase)
 * <p>
 * like x^2 always
 * any fuction
 */
public class BinarySearchApplication {

    public static void main(String[] args) {
        System.out.println(search(100, 4, 8, 10, 81, 98, 99, 100));
    }

    private static int search(int to_search, int... elements) {
        int end = elements.length - 1;
        int beg = 0;
        int mid;
        while ((end - beg) > 1) {
            mid = (end + beg) >> 1;
            if (elements[mid] < to_search) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }

        if (elements[beg] == to_search) {
            return beg;
        } else if (elements[end] == to_search) {
            return end;
        } else
            return -1;
    }

    private static int searchBitWise(int to_search, int... elements) {
        int end = elements.length - 1;
        int beg = 0;
        int mid;
        while ((end - beg) > 1) {
            mid = (end + beg) >> 1;
            if (elements[mid] < to_search) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }

        if (elements[beg] == to_search) {
            return beg;
        } else if (elements[end] == to_search) {
            return end;
        } else
            return -1;
    }

    /**
     * Lower and upper bound
     */
    private static int application01(int to_search, int... elements) {
        int end = elements.length - 1;
        int beg = 0;
        int mid;
        while ((end - beg) > 1) {
            mid = (end + beg) >> 1;
            if (elements[mid] < to_search) {
                beg = mid + 1;
            } else {
                end = mid;
            }
        }

        if (elements[beg] == to_search) {
            return beg;
        } else if (elements[end] == to_search) {
            return end;
        } else
            return -1;
    }
}
