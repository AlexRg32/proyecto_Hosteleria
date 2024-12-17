package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {

    public static void main(String[] args) {
        login();
    }

    public static void login() {
        JFrame frame;
        JPanel panelUsuario, panelContraseña, panelBienvenida, panelBotones, panelMain;
        JLabel labelUser, labelPassword, labelBienvenida;
        JTextField inputUsuario;
        JPasswordField inputContraseña;
        JButton botonIngresar, botonRegistrarse;

        frame = new JFrame("Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Espaciado alrededor

        panelBienvenida = new JPanel();
        labelBienvenida = new JLabel("Bienvenido a la aplicación", JLabel.CENTER);
        labelBienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        labelBienvenida.setForeground(new Color(0, 102, 204));
        panelBienvenida.add(labelBienvenida);
        panelMain.add(panelBienvenida);

        panelUsuario = new JPanel();
        labelUser = new JLabel("Usuario: ");
        labelUser.setFont(new Font("Arial", Font.PLAIN, 14));
        inputUsuario = new JTextField(20);
        inputUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        inputUsuario.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204), 1));
        panelUsuario.add(labelUser);
        panelUsuario.add(inputUsuario);
        panelMain.add(panelUsuario);

        panelContraseña = new JPanel();
        labelPassword = new JLabel("Contraseña: ");
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        inputContraseña = new JPasswordField(20);
        inputContraseña.setFont(new Font("Arial", Font.PLAIN, 14));
        inputContraseña.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204), 1));
        panelContraseña.add(labelPassword);
        panelContraseña.add(inputContraseña);
        panelMain.add(panelContraseña);

        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        botonIngresar = new JButton("Ingresar");
        botonIngresar.setFont(new Font("Arial", Font.BOLD, 14));
        botonIngresar.setBackground(new Color(0, 102, 204));
        botonIngresar.setForeground(Color.WHITE);
        botonIngresar.setFocusPainted(false);
        botonIngresar.setPreferredSize(new Dimension(120, 40));

        botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.setFont(new Font("Arial", Font.BOLD, 14));
        botonRegistrarse.setBackground(new Color(0, 153, 51));
        botonRegistrarse.setForeground(Color.WHITE);
        botonRegistrarse.setFocusPainted(false);
        botonRegistrarse.setPreferredSize(new Dimension(120, 40));

        panelBotones.add(botonIngresar);
        panelBotones.add(botonRegistrarse);
        panelMain.add(panelBotones);

        frame.add(panelMain);
        frame.setVisible(true);

        botonIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = inputUsuario.getText();
                String contraseña = new String(inputContraseña.getPassword());

                if (usuario.equals("admin") && contraseña.equals("admin")) {
                    JOptionPane.showMessageDialog(frame, "Bienvenido " + usuario);
                } else {
                    JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        botonRegistrarse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Redirigiendo a la página de registro...");
                // Aquí puedes redirigir al formulario de registro
            }
        });
    }
}
