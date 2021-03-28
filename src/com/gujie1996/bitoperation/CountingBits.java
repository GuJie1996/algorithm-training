package com.gujie1996.bitoperation;

public class CountingBits {
    public static void main(String[] args) {
        for (int i : new CountingBits().countBits(5)) {
            System.out.println(i + ",");
        }
    }
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; i++) {
            result[i] = result[i & i - 1] + 1;
        }
        return result;
    }
}
