package com.mycompany.sistemacontroldonraul;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioBD {
    private final Connection connection;

    public UsuarioBD(Connection connection) {
        this.connection = connection ;
    }

    public void insertarUsuario(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario (nombre, idUsuario, idRol,contrasenha) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, usuario.getNombre());
            statement.setInt(2, Usuario.getIdUsuario());
            statement.setInt(3, usuario.getIdRol());
             statement.setString(4, usuario.getContrasenha());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Usuario agregado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar usuario: " + e.getMessage());
            throw e;
        }
    }

    public List<Usuario> listarUsuarios() throws SQLException {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setNombre(resultSet.getString("nombre"));
                usuario.setIdRol(resultSet.getInt("idRol"));               
                usuario.setIdUsuario(resultSet.getInt("idUsuario")); 
                usuario.setContrasenha(resultSet.getString("contrasenha"));
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar usuarios: " + e.getMessage());
            throw e;
        }

        return usuarios;
    }
}
