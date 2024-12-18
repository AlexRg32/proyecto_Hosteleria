package org.example.repository;

import org.example.database.ConexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepository {

    public UsuarioRepository() {
    }

    public void registrarUsuario(String nombreUsuario, String contraseña, String email, String rol) {
        String sql = "INSERT INTO usuarios (nombre_usuario, contraseña, email, rol) VALUES (?, ?, ?, ?)";

        try (Connection connection = ConexionBDD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nombreUsuario);
            statement.setString(2, contraseña);
            statement.setString(3, email);
            statement.setString(4, rol);

            int filasInsertadas = statement.executeUpdate();
            if (filasInsertadas > 0) {
                System.out.println("Usuario registrado exitosamente con rol: " + rol);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validarLogin(String nombreUsuario, String contraseña) {
        String sql = "SELECT * FROM usuarios WHERE nombre_usuario = ? AND contraseña = ?";
        try (Connection connection = ConexionBDD.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, nombreUsuario);
            statement.setString(2, contraseña);


            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String obtenerRol(String usuario) {
        String rol = null;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = ConexionBDD.getConnection();
            String query = "SELECT rol FROM usuarios WHERE nombre_usuario = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, usuario);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                rol = resultSet.getString("rol");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rol;
    }
}
