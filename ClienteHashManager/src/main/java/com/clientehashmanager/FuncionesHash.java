/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clientehashmanager;

/**
 *
 * @author alem
 */
public class FuncionesHash {
    public static int hashModulo(String clave, int tamaño) {
        int hash = 0;
        for (char c : clave.toCharArray()) {
            hash += c;
        }
        return hash % tamaño;
    }
    
}
