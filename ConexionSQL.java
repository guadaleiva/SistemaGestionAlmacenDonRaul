package com.mycompany.sistemacontroldonraul;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQL {

    private static final String URL = "jdbc:mysql://localhost:3306/SistemaGestionAlmacenDonRaul";
    private static final String USUARIO = "root";
    private static final String CONTRASENHA = "root";

    public static Connection conexion() {
        Connection conectar = null;

        try {
            System.out.println("Conectando a la URL: " + URL); // Mostrar la URL
            System.out.println("Usando usuario: " + USUARIO); // Mostrar el usuario
            // Intentar establecer la conexiOn
            conectar = DriverManager.getConnection(URL, USUARIO, CONTRASENHA);
            System.out.println("ConexiOn exitosa");

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos: " + e.getMessage());
        }

        return conectar;
    }
}
