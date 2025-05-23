/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ada03;

/**
 *
 * @author Alejandro
 */
public class Ackermann {

   public static int ackermann(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (n == 0) {
            return ackermann(m - 1, 1);
        } else {
            return ackermann(m - 1, ackermann(m, n - 1));
        }
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 4;
        System.out.println("Ackermann(" + m + ", " + n + ") = " + ackermann(m, n));
    }
}
