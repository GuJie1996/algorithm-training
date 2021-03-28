package com.gujie1996.bitoperation;

public class NumberOf1Bits {
    public static void main(String[] args) {
        System.out.println(new NumberOf1Bits().hammingWeight(0b1011));
    }
    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            n &= n-1;
            count++;
        }
        return count;
    }
}
