package org.example.view;

import org.example.repository.UsuarioRepository;

import javax.swing.*;
import java.awt.*;
import org.example.repository.UsuarioRepository;

public class Home {
    public static void main(String[] args) {
        mostrarLogin();

    }

    public static void home(String usuario) {
        JFrame frame;
        JPanel panelMain;
        JLabel labelBienvenida;

        frame = new JFrame("Home");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panelMain = new JPanel();
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
        panelMain.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        System.out.println("Usuario: " + usuario);
        System.out.println("Rol: " + new UsuarioRepository().obtenerRol(usuario));


    //comprobar rol del usuario
        UsuarioRepository usuarioRepository = new UsuarioRepository();

        if("encargado".equalsIgnoreCase(usuarioRepository.obtenerRol(usuario))){
            labelBienvenida = new JLabel("Bienvenido a la aplicación encargado", JLabel.CENTER);
            labelBienvenida.setFont(new Font("Arial", Font.BOLD, 18));
            labelBienvenida.setForeground(new Color(0, 102, 204));
            panelMain.add(labelBienvenida);

        }else if ("trabajador".equalsIgnoreCase(usuarioRepository.obtenerRol(usuario))){
            labelBienvenida = new JLabel("Bienvenido a la aplicación trabajador", JLabel.CENTER);
            labelBienvenida.setFont(new Font("Arial", Font.BOLD, 18));
            labelBienvenida.setForeground(new Color(0, 102, 204));
            panelMain.add(labelBienvenida);

        }else{
            labelBienvenida = new JLabel("No tienes rol, cierra y registrate", JLabel.CENTER);
            labelBienvenida.setFont(new Font("Arial", Font.BOLD, 18));
            labelBienvenida.setForeground(new Color(0, 102, 204));
            panelMain.add(labelBienvenida);
        }

        frame.add(panelMain);
        frame.setVisible(true);
    }

    public static void mostrarLogin(){
        Login.login();
    }

}