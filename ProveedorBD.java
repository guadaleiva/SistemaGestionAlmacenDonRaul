package com.mycompany.sistemacontroldonraul;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorBD {
    private final Connection connection;

    public ProveedorBD(Connection connection) {
        this.connection = connection ;
    }

    public void insertarProveedor(Proveedor proveedor) throws SQLException {
        String sql = "INSERT INTO proveedor (nombre, idProveedor, contacto, direccion, telefono) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            
            statement.setString(1, proveedor.getNombre());
            statement.setInt(2, proveedor.getIdProveedor());
            statement.setString(3, proveedor.getContacto());
            statement.setString(4, proveedor.getDireccion());
            statement.setFloat(5, proveedor.getTelefono());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Proveedor agregado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar proveedor: " + e.getMessage());
            throw e;
        }
    }

    public List<Proveedor> listarProveedores() throws SQLException {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM Proveedor";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Proveedor proveedor = new Proveedor();
                
                proveedor.setIdProveedor(resultSet.getInt("idProveedor"));   
                proveedor.setNombre(resultSet.getString("nombre"));
                proveedor.setContacto(resultSet.getString("contacto")); 
                proveedor.setDireccion(resultSet.getString("direccion"));
                proveedor.setTelefono(resultSet.getFloat("telefono"));
                proveedor.add(proveedor);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar proveedor: " + e.getMessage());
            throw e;
        }

        return proveedores;
    }
}

