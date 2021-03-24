package com.gujie1996.recursion;

public class PowXN {

    public static void main(String[] args) {
        System.out.println(myPow(2, -2147483648));
    }

    public static double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n < 0) {
            if (n == Integer.MIN_VALUE) {
                return 1 / myPow(x, -(n + 1)) / x;
            }
            return 1 / myPow(x, -n);
        }
        return (n & 1) == 1 ? x * myPow(x * x, n >> 1) : myPow(x * x, n >> 1);
    }
}
