package org.example.view;

import org.example.repository.UsuarioRepository;

import javax.swing.*;
import java.awt.*;

public class Registro {

    public static void registro() {
        JFrame frame;
        JPanel panelUsuario, panelContraseña, panelCorreoElectronico, panelBienvenida, panelBotones, panelMain;
        JLabel labelUser, labelPassword, labelCorreoElectronico, labelBienvenida;
        JTextField inputUsuario, inputCorreoElectronico;
        JPasswordField inputContraseña;
        JButton botonRegistrarse;

        frame = new JFrame("Registro");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panelMain = new JPanel(new GridBagLayout());
        panelMain.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        panelBienvenida = new JPanel();
        labelBienvenida = new JLabel("Bienvenido a la aplicación", JLabel.CENTER);
        labelBienvenida.setFont(new Font("Arial", Font.BOLD, 18));
        labelBienvenida.setForeground(new Color(0, 102, 204));
        panelBienvenida.add(labelBienvenida);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panelMain.add(panelBienvenida, gbc);

        labelUser = new JLabel("Usuario: ");
        labelUser.setFont(new Font("Arial", Font.PLAIN, 14));
        inputUsuario = new JTextField(20);
        inputUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
        inputUsuario.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204), 1));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panelMain.add(labelUser, gbc);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panelMain.add(inputUsuario, gbc);

        labelCorreoElectronico = new JLabel("Correo Electrónico: ");
        labelCorreoElectronico.setFont(new Font("Arial", Font.PLAIN, 14));
        inputCorreoElectronico = new JTextField(20);
        inputCorreoElectronico.setFont(new Font("Arial", Font.PLAIN, 14));
        inputCorreoElectronico.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204), 1));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panelMain.add(labelCorreoElectronico, gbc);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panelMain.add(inputCorreoElectronico, gbc);

        labelPassword = new JLabel("Contraseña: ");
        labelPassword.setFont(new Font("Arial", Font.PLAIN, 14));
        inputContraseña = new JPasswordField(20);
        inputContraseña.setFont(new Font("Arial", Font.PLAIN, 14));
        inputContraseña.setBorder(BorderFactory.createLineBorder(new Color(204, 204, 204), 1));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panelMain.add(labelPassword, gbc);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panelMain.add(inputContraseña, gbc);

        panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());
        botonRegistrarse = new JButton("Registrarse");
        botonRegistrarse.setFont(new Font("Arial", Font.BOLD, 14));
        botonRegistrarse.setBackground(new Color(0, 153, 51));
        botonRegistrarse.setForeground(Color.WHITE);
        botonRegistrarse.setFocusPainted(false);
        botonRegistrarse.setPreferredSize(new Dimension(120, 40));
        panelBotones.add(botonRegistrarse);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panelMain.add(panelBotones, gbc);

        botonRegistrarse.addActionListener(e -> {
            String usuario = inputUsuario.getText();
            String correoElectronico = inputCorreoElectronico.getText();
            String contraseña = new String(inputContraseña.getPassword());

            UsuarioRepository usuarioRepository = new UsuarioRepository();
            usuarioRepository.registrarUsuario(usuario, contraseña, correoElectronico, "trabajador");
            Login.login();
            frame.dispose();
        });

        frame.add(panelMain);
        frame.setVisible(true);
    }
}