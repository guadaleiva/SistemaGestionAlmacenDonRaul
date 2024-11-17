package com.mycompany.sistemacontroldonraul;

import java.sql.Connection; 
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoBD {
     private final Connection connection; 
     
     public ProductoBD(Connection connection){
         this.connection =connection;
         
     }
     public void insertarProducto(Producto producto)throws SQLException{
         String sql = "INSERT INTO producto(nombre, descripcion, precio, idCategoria, idProducto, marca, proveedor) "
                 + "VALUES(?,?,?,?,?,?,?)";
        
         try(PreparedStatement statement = connection.prepareStatement(sql)){
             statement.setString(1,producto.getNombre());
             statement.setString(2,producto.getDescripcion());
             statement.setFloat(3,producto.getPrecio());
             statement.setString(4,producto.getCategoria());
             statement.setInt(5,producto.getIdProducto());
             statement.setString(5,producto.getMarca());
             statement.setString(5,producto.getProveedor());
             
             
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Producto agregado correctamente.");
            }
        } catch (SQLException e) {
            System.out.println("Error al agregar producto: " + e.getMessage());
            throw e;
         }
     }
       public List<Producto> listarProductos() throws SQLException {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM producto";
        
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Producto producto = new Producto();
                
                producto.setNombre(resultSet.getString("Nombre"));
                producto.setDescripcion(resultSet.getString("Descripcion"));
                producto.setPrecio(resultSet.getFloat("Precio"));
                producto.setCategoria(resultSet.getString("idCategoria")); 
                producto.setIdProducto(resultSet.getInt("idProducto"));
                producto.setMarca(resultSet.getString("Marca")); 
                producto.setProveedor(resultSet.getString("Proveedor"));
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("Error al listar productos: " + e.getMessage());
            throw e;
        }
        
        return productos;
    }
}
