package com.gujie1996.bitoperation;

public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new PowerOfTwo().isPowerOfTwo(1));
    }
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & n-1) == 0;
    }
}
