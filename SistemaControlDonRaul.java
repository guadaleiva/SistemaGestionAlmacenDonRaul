package com.mycompany.sistemacontroldonraul;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SistemaControlDonRaul{

    
    private static Connection conectar;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = null;

        try {
            // Conexión con la base de datos
            conectar = ConexionSQL.conexion();
         
            if (conectar == null) {
                System.out.println("No se pudo establecer conexión con la base de datos. "
                        + "El programa no puede continuar.");
                return;
            }
            conectar.setAutoCommit(false);

            String tipoUsuario = seleccionarTipoUsuario(scanner);
            int opcion;

            do {
                mostrarMenu();
                opcion = obtenerOpcion(scanner);

                switch (opcion) {
                    case 1 -> gestionarUsuario(scanner);
                    
                    case 2 -> {
                        if (tipoUsuario.equals("Administrativo")) {
                            gestionarProductos(scanner);
                        } else {
                            System.out.println("Acceso denegado. Solo usuarios administrativos pueden gestionar productos.");
                        }
                    }
                    case 3 -> gestionarCategoria(scanner);
                    case 4 -> gestionarProveedores(scanner);
                    case 5 -> gestionarCarrito(scanner);
                    case 6 -> generarComprobante(scanner);
                    case 0 -> System.out.println("Saliendo del sistema... ¡Hasta pronto!");
                    default -> System.out.println("Opción no válida. Intente nuevamente.");
                }
            } while (opcion != 0);

        } catch (SQLException e) {
            System.out.println("Error en la conexión con la base de datos: " + e.getMessage());
            if (conectar != null) {
                try {
                    conectar.rollback();
                } catch (SQLException ex) {
                    System.out.println("Error al realizar rollback: " + ex.getMessage());
                }
            }
        } finally {
            if (conectar != null) {
                try {
                    conectar.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("========= MENU PRINCIPAL =========");
        System.out.println("1. Gestionar Usuario");
        System.out.println("2. Gestionar Productos");
        System.out.println("3. Gestionar Categorías");
        System.out.println("4. Gestionar Proveedores");
        System.out.println("5. Gestionar Carrito");
        System.out.println("6. Generar Comprobante");
        System.out.println("0. Salir");
        System.out.println("==================================");
    }

    private static String seleccionarTipoUsuario(Scanner scanner) {
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Administrativo");
        System.out.println("2. Atención al Público");

        int opcion = obtenerOpcion(scanner);
        
        return switch (opcion) {
            case 1 -> "Administrativo";
            case 2 -> "AtencionAlPublico";
            default -> {
                System.out.println("Opción no válida. Se asignará Atención al Público por defecto.");
                yield "AtencionAlPublico";
            }
        };
    }

    private static int obtenerOpcion(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error: Debe ingresar un número válido.");
            scanner.nextLine(); 
            return -1;
        }
    }

    private static void gestionarUsuario(Scanner scanner) {
        System.out.println("--- Gestión de Usuarios ---");
        System.out.println("1. Agregar Usuario");
        System.out.println("2. Listar Usuarios");
        System.out.println("0. Volver al menú principal");

        int opcion = obtenerOpcion(scanner);
        switch (opcion) {
            case 1 -> {
            scanner.nextLine();
            System.out.print("Ingrese el nombre del usuario: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el ID del usuario: ");
            String idUsuario = scanner.nextLine();
            System.out.print("Ingrese el Id del rol del usuario: ");
            String idRol = scanner.nextLine();
            System.out.print("Ingrese la contraseña del usuario: ");
            String contrasenha = scanner.nextLine();

              Usuario usuario = new Usuario(nombre,idUsuario, idRol, contrasenha);

              try {
                UsuarioBD.insertarUsuario(usuario);
                System.out.println("Usuario agregado correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al agregar usuario: " + e.getMessage());
            }
        }
        case 2 -> {
            try {
                List<Usuario> usuarios = UsuarioBD.listarUsuarios();
                usuarios.forEach(System.out::println);
            } catch (SQLException e) {
                System.out.println("Error al listar usuarios: " + e.getMessage());
            }
        }
        case 0 -> System.out.println("Volviendo al menú principal...");
        default -> System.out.println("Opción no válida.");
    }
    }

    private static void gestionarProductos(Scanner scanner){
      
    }

    private static void gestionarCategoria(Scanner scanner) {
     System.out.println("--- Gestión de Categorías ---");
    System.out.println("1. Agregar Categoría");
    System.out.println("2. Listar Categorías");
    System.out.println("0. Volver al menú principal");

    int opcion = obtenerOpcion(scanner);
    switch (opcion) {
        case 1 -> {
            scanner.nextLine();
            System.out.print("Ingrese el nombre de la categoría: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Ingrese el Id de la categoría: ");
            String idCategoria = scanner.nextLine();
            
            Categoria categoria = new Categoria();
            
            try {
                CategoriaBD.insertarCategoria(categoria);
                System.out.println("Categoría agregada correctamente.");
            } catch (SQLException e) {
                System.out.println("Error al agregar categoría: " + e.getMessage());
            }
        }
        case 2 -> {
            try {
                List<Categoria> categorias = CategoriaBD.listarCategorias();
                categorias.forEach(System.out::println);
            } catch (SQLException e) {
                System.out.println("Error al listar categorías: " + e.getMessage());
            }
        }
        case 0 -> System.out.println("Volviendo al menú principal...");
        default -> System.out.println("Opción no válida.");
    }
    }

    private static void gestionarProveedores(Scanner scanner) {
        System.out.println("--- Gestionar Proveedores ---");
        System.out.println("1. Agregar Proveedor");
        System.out.println("2. Lista Proveedores");
        System.out.println("0. Volver al menú principal");
        int opcion = scanner.nextInt();
        
        switch (opcion) {
          case 1 -> {
             scanner.nextLine(); 
       System.out.print("Ingrese el ID del proveedor: ");
        String idProveedor = scanner.nextLine();
       
       System.out.print("Ingrese el nombre del proveedor: ");
       String nombre = scanner.nextLine();
       
       System.out.print("Ingrese el contacto del proveedor: ");
       String contacto = scanner.nextLine();
       
       System.out.print("Ingrese la dirección del proveedor: ");
       String direccion = scanner.nextLine();
       
       System.out.print("Ingrese la telefono del proveedor: ");
            String  telefono = scanner.nextLine();
       
       scanner.nextLine(); 
 
       
       Proveedor proveedor;
                proveedor = new Proveedor( idProveedor,nombre, contacto, direccion, telefono);
         
         try {
        ProveedorBD.insertarProveedor(proveedor);
        System.out.println("Proveedor agregado correctamente.");
        } catch (SQLException e) {
        System.out.println("Error al agregar el proveedor: " + e.getMessage());
        }
        }

        case 2 -> {
        
            try {
         List<Proveedor> proveedores;
                proveedores = ProveedorBD.listarProveedores();
         System.out.println("=== Lista de Proveedores ===");
         for (Proveedor p : proveedores) {
         System.out.println(p);
         }
         
        } catch (SQLException e) {
        System.out.println("Error al listar proveedores: " + e.getMessage());
        }
        }
         case 0 -> System.out.println("Regresando al menú principal...");
         default -> System.out.println("Opción no válida.");
         }
        } 

    private static void gestionarCarrito(Scanner scanner) {
     System.out.println("--- Gestión del Carrito ---");
    System.out.println("1. Agregar Producto al Carrito");
    System.out.println("2. Ver Carrito");
    System.out.println("3. Eliminar Producto del Carrito");
    System.out.println("0. Volver al menú principal");

    int opcion = obtenerOpcion(scanner);
    switch (opcion) {
        case 1 -> {
            System.out.print("Ingrese el ID del producto: ");
            int idProducto = scanner.nextInt();
            System.out.print("Ingrese la cantidad: ");
            int cantidad = scanner.nextInt();
            try {
                Producto producto = ProductoBD.obtenerProducto(idProducto);
                if (producto != null) {
                    Carrito.agregarProducto(producto, cantidad);
                    System.out.println("Producto agregado al carrito.");
                } else {
                    System.out.println("Producto no encontrado.");
                }
            } catch (SQLException e) {
                System.out.println("Error al agregar al carrito: " + e.getMessage());
            }
        }
        case 2 -> Carrito.mostrarCarrito();
        case 3 -> {
            System.out.print("Ingrese el ID del producto a eliminar: ");
            int idProducto = scanner.nextInt();
            Carrito.eliminarProducto(idProducto);
            System.out.println("Producto eliminado del carrito.");
        }
        case 0 -> System.out.println("Volviendo al menú principal...");
        default -> System.out.println("Opción no válida.");
    }
    }

    private static void generarComprobante(Scanner scanner) {
        System.out.println("--- Generar Comprobante ---");
        System.out.println("1.Imprimir comprobante.");
    }
    
}

