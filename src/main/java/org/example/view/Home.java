package org.example.view;

import org.example.repository.UsuarioRepository;

import javax.swing.*;
import java.awt.*;
import org.example.repository.UsuarioRepository;

public class Home {
    public static JFrame frame;
    public static JPanel panelMain;
    public static JPanel panelCuentas, panelProductos, panelCategorias;
    public static JPanel panelCentral;
    public static JPanel barraSuperior;
    public static JPanel barraInferior;


    public static void main(String[] args) {
        Login.login();

    }

    public static void home(String usuario) {
        JPanel panelMain;
        JLabel labelBienvenida;

        frame = new JFrame("Home");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


    //comprobar rol del usuario
        UsuarioRepository usuarioRepository = new UsuarioRepository();
        switch (usuarioRepository.obtenerRol(usuario)){
            case "encargado":
                crearInterfazEncargado();
                break;
            case "trabajador":
                crearInterfazTrabajador();
                break;
            default:
                labelBienvenida = new JLabel("No tienes rol, cierra y registrate", JLabel.CENTER);
                labelBienvenida.setFont(new Font("Arial", Font.BOLD, 18));
                labelBienvenida.setForeground(new Color(0, 102, 204));
                panelMain.add(labelBienvenida);
                break;
        }

        frame.add(panelMain);
        frame.setVisible(true);
    }

    public static void crearInterfazEncargado(){
        JLabel labelBienvenida;

        frame = new JFrame("Home");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        labelBienvenida = new JLabel("Bienvenido a la aplicación encargado", JLabel.CENTER);
        labelBienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        labelBienvenida.setForeground(new Color(0, 102, 204));
        panelMain.add(labelBienvenida);

        frame.add(panelMain);
        frame.setVisible(true);
    }

    public static void crearInterfazTrabajador(){
        JLabel labelBienvenida;
        JLabel labelCuentas, labelProductos, labelCategorias;

        frame = new JFrame("Home");
        frame.setSize(1400, 900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panelMain = new JPanel();
        panelMain.setLayout(new BorderLayout());
        panelMain.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelCentral = new JPanel(new GridLayout(1,3));

         crearPanelCuentas();
         crearPanelProductos();
         crearPanelCategorias();
         crearBarraSuperior();
            crearBarraInferior();

         panelCentral.add(panelCuentas);
         panelCentral.add(panelProductos);
         panelCentral.add(panelCategorias);

            panelMain.add(panelCentral, BorderLayout.CENTER);
            panelMain.add(barraSuperior, BorderLayout.NORTH);
            panelMain.add(barraInferior, BorderLayout.SOUTH);

        frame.add(panelMain);
        frame.setVisible(true);
    }

    public static void crearPanelCuentas(){
        JPanel panelBotones;
        JButton botonCobrar, botonEliminar;
        JTextArea textAreaCuenta;
        JScrollPane scrollPane;

        textAreaCuenta = new JTextArea();
        textAreaCuenta.setEditable(false);
        scrollPane = new JScrollPane(textAreaCuenta);

        panelCuentas = new JPanel();
        panelCuentas.setLayout(new GridLayout(3,1));
        panelCuentas.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1,2));

        botonCobrar = new JButton("Cobrar");
        botonEliminar = new JButton("Eliminar");

        panelBotones.add(botonCobrar);
        panelBotones.add(botonEliminar);

        panelCuentas.add(scrollPane);
        panelCuentas.add(panelBotones);

    }

    public static void crearPanelProductos(){
        panelProductos = new JPanel(new GridLayout(10,10));
        panelProductos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (int i = 0; i < 20; i++) {
            panelProductos.add(new JButton("Producto " + i));
        }

        panelMain.add(panelProductos);
    }

    public static void crearPanelCategorias(){
        panelCategorias = new JPanel(new GridLayout(5,5));
        panelCategorias.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        for (int i = 0; i < 5; i++) {
            panelCategorias.add(new JButton("Categoria " + i));
        }

        panelMain.add(panelCategorias);
    }

    public static void crearBarraSuperior(){
        barraSuperior = new JPanel();
        barraSuperior.setBackground(new Color(0, 102, 204));

    }

    public static void crearBarraInferior(){
        barraInferior = new JPanel();
        barraInferior.setBackground(new Color(0, 102, 204));
    }

}