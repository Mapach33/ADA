/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clientehashmanager;

/**
 *
 * @author alem
 */
public class TablaHashLineal {
    private Cliente[] tabla;
    private int tamaño;

    public TablaHashLineal(int tamaño) {
        this.tamaño = tamaño;
        tabla = new Cliente[tamaño];
    }

    public void insertar(Cliente cliente) {
        int hash = FuncionesHash.hashModulo(cliente.getClave(), tamaño);
        while (tabla[hash] != null) {
            hash = (hash + 1) % tamaño;
        }
        tabla[hash] = cliente;
    }

    public Cliente buscar(String nombres, String apellidos) {
        int hash = FuncionesHash.hashModulo(nombres + apellidos, tamaño);
        while (tabla[hash] != null) {
            if (tabla[hash].nombres.equals(nombres) && tabla[hash].apellidos.equals(apellidos)) {
                return tabla[hash];
            }
            hash = (hash + 1) % tamaño;
        }
        return null;
    }
}
