package edu.neu.coe.info6205.union_find;

import java.util.Random;
 
public class ClientUF {
 
    public static int count(int n) {
        UF_HWQUPC obj = new UF_HWQUPC(n);
 
        int counter = 0;
        Random randomNumber = new Random();
        while (obj.components() > 1) {
            int x = randomNumber.nextInt(n);
            int y = randomNumber.nextInt(n);
 
            if (!obj.connected(x, y)) {
                obj.union(x, y);
            }
            counter++;
        }
        return counter;
    }
 
    public static void main(String[] args) {
        System.out.printf("%-10s %-10s %-30s %-20s\n", "n", "m", "fn = 0.5 * n * ln(n)", "offset = (fn - m) / m");
        for (int i = 100; i < 1000000; i *= 2) {
            int sum = 0;
            for (int j = 0; j < 10; j++) {
                sum += count(i);
            }
 
            double m = sum / 10.0;
            int fn = (int) (0.5 * i * Math.log(i));
 
            System.out.printf("%-10s %-10s %-30s %-20s\n", i, (int) m, fn, (fn - m) / m);
        }
 
    }
}
