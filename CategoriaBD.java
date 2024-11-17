package com.mycompany.sistemacontroldonraul;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CategoriaBD {
   private final Connection connection;

    public CategoriaBD(Connection connection) {
        this.connection = connection ;
    }

    public void insertarCategoria(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO categoria (nombre, idCategoria) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, categoria.getNombre());
            statement.setInt(2, categoria.getIdCategoria());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Categoria agregado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar categoria: " + e.getMessage());
            throw e;
        }
    }

    public List<Categoria> listarCategorias() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categoria";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Categoria categoria = new Categoria();
                
                categoria.setNombre(resultSet.getString("nombre"));
                categoria.setIdCategoria(resultSet.getInt("idCategoria"));                 
                
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar categorias: " + e.getMessage());
            throw e;
        }

        return categorias;
    }
    
}
