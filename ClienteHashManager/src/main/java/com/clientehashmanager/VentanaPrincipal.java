/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clientehashmanager;

/**
 *
 * @author alem
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {
    private JTextField txtCodigo, txtNombres, txtApellidos, txtTelefono, txtCorreo, txtDireccion, txtPostal;
    private JButton btnInsertar, btnBuscar;
    private JTextArea txtResultado;
    private TablaHashLineal tablaHash;

    public VentanaPrincipal() {
        setTitle("Hash con Swing - Resolución Lineal");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        tablaHash = new TablaHashLineal(37);

        JPanel panelFormulario = new JPanel(new GridLayout(8, 2));
        txtCodigo = new JTextField(); txtNombres = new JTextField(); txtApellidos = new JTextField();
        txtTelefono = new JTextField(); txtCorreo = new JTextField(); txtDireccion = new JTextField();
        txtPostal = new JTextField();

        panelFormulario.add(new JLabel("Código:")); panelFormulario.add(txtCodigo);
        panelFormulario.add(new JLabel("Nombres:")); panelFormulario.add(txtNombres);
        panelFormulario.add(new JLabel("Apellidos:")); panelFormulario.add(txtApellidos);
        panelFormulario.add(new JLabel("Teléfono:")); panelFormulario.add(txtTelefono);
        panelFormulario.add(new JLabel("Correo:")); panelFormulario.add(txtCorreo);
        panelFormulario.add(new JLabel("Dirección:")); panelFormulario.add(txtDireccion);
        panelFormulario.add(new JLabel("Código Postal:")); panelFormulario.add(txtPostal);

        btnInsertar = new JButton("Insertar");
        btnBuscar = new JButton("Buscar");
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnInsertar); panelBotones.add(btnBuscar);

        txtResultado = new JTextArea(5, 40);
        txtResultado.setEditable(false);

        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(new JScrollPane(txtResultado), BorderLayout.SOUTH);

        // Eventos
        btnInsertar.addActionListener(e -> insertarCliente());
        btnBuscar.addActionListener(e -> buscarCliente());
    }

    private void insertarCliente() {
        Cliente c = new Cliente(
            txtCodigo.getText(), txtNombres.getText(), txtApellidos.getText(),
            txtTelefono.getText(), txtCorreo.getText(),
            txtDireccion.getText(), txtPostal.getText()
        );
        long t0 = System.nanoTime();
        tablaHash.insertar(c);
        long t1 = System.nanoTime();
        txtResultado.setText("Cliente insertado en " + (t1 - t0) + " ns.");
    }

    private void buscarCliente() {
        String nombres = txtNombres.getText();
        String apellidos = txtApellidos.getText();
        long t0 = System.nanoTime();
        Cliente c = tablaHash.buscar(nombres, apellidos);
        long t1 = System.nanoTime();
        if (c != null) {
            txtResultado.setText("Cliente encontrado: " + c.codigo + "\nTiempo: " + (t1 - t0) + " ns.");
        } else {
            txtResultado.setText("Cliente no encontrado\nTiempo: " + (t1 - t0) + " ns.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaPrincipal().setVisible(true));
    }
}
