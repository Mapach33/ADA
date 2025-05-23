/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ada03;
import java.util.Stack;
/**
 *
 * @author Alejandro
 */
public class AckermannIterativo {
    public static int ackermann(int m, int n) {
        Stack<Integer> stack = new Stack<>();

        stack.push(m);

        while (!stack.isEmpty()) {
            m = stack.pop();

            if (m == 0) {
                n = n + 1;
            } else if (n == 0) {
                stack.push(m - 1);
                n = 1;
            } else {
                stack.push(m - 1);
                stack.push(m);
                n = n - 1;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        int m = 3;
        int n = 4;
        System.out.println("Ackermann iterativo(" + m + ", " + n + ") = " + ackermann(m, n));
    }
    
}
