/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clientehashmanager;

/**
 *
 * @author alem
 */
public class Cliente {
    public String codigo;
    public String nombres;
    public String apellidos;
    public String telefono;
    public String correo;
    public String direccion;
    public String codigoPostal;

    public Cliente(String codigo, String nombres, String apellidos, String telefono, String correo, String direccion, String codigoPostal) {
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.codigoPostal = codigoPostal;
    }

    public String getClave() {
        return nombres + apellidos;
    }
}
