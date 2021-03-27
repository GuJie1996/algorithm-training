package com.gujie1996.binarysearch;

public class Sqrtx {
    public static void main(String[] args) {
        Sqrtx sqrtx = new Sqrtx();
        System.out.println(sqrtx.mySqrt(2147395599));
    }
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int left = 0;
        int right = x;
        while (right - left > 1) {
            long middle = (left + right) >> 1;
            if (middle * middle > x) {
                right = (int) middle;
            } else {
                left = (int) middle;
            }
        }
        return left;
    }
}
