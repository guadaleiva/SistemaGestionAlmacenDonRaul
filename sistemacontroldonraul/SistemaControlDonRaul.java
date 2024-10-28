
package com.mycompany.sistemacontroldonraul;

import java.util.Scanner;

public class SistemaControlDonRaul {

    private static Iterable<Producto> productos;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion = 0;
            String tipoUsuario = seleccionarTipoUsuario(scanner); 
            

            do {
                mostrarMenu();  
                System.out.print("Seleccione una opción: ");
                opcion = obtenerOpcion(scanner); 
                scanner.nextLine();  
                
                switch (opcion) {
                    case 1:
                        if (tipoUsuario.equals("Administrativo")) {
                            
                            gestionarProductos(scanner);
                        } else {
                            System.out.println("Acceso denegado. Solo usuarios administrativos pueden gestionar productos.");
                        }
                        
                        break;
                    case 2:
                        verCarrito();
                        break;
                    case 3:
                        generarComprobante();
                        break;
                    case 4:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                        
                    case 5:
                        System.out.println("Cambiando usuario...");
                        iniciarSesion(scanner); 
                        break;
                }
            } while (opcion != 5);
        }
    }

    public static String seleccionarTipoUsuario(Scanner scanner) {
        System.out.println("Seleccione el tipo de usuario:");
        System.out.println("1. Administrativo");
        System.out.println("2. Atención al Público");
        int opcion = obtenerOpcion(scanner);
        switch (opcion) {
            case 1 -> {
                return "Administrativo";
            }
            case 2 -> {
                return "AtencionAlPublico";
            }
            default -> {
                System.out.println("Opción no válida. Se asignará Atención al Público por defecto.");
                return "AtencionAlPublico";
            }
        }


    }

    public static void mostrarMenu() {
        System.out.println("========= MENÚ PRINCIPAL =========");
        System.out.println("1. Gestionar Productos");
        System.out.println("2. Ver Carrito");
        System.out.println("3. Agregar producto al carrito");
        System.out.println("4. Generar Comprobante");
        System.out.println("5. Salir");
        System.out.println("6.Volver seleccion tipo de usuario");
        System.out.println("==================================");
        
    }

    // Opción 1: 
    public static void gestionarProductos(Scanner scanner) {
        System.out.print("Ingrese su nombre o ID: ");

        System.out.print("Ingrese su contraseña: ");
        
        System.out.println("--- Gestión de Productos ---");
        System.out.println("Buscar producto por:");
        System.out.println("1. Nombre");
        System.out.println("2. Marca");
        System.out.println("3. ID");
        int opcionBusqueda = obtenerOpcion(scanner);
        scanner.nextLine();  

        Producto productoEncontrado = null;
        switch (opcionBusqueda) {
            case 1 -> {
                System.out.print("Ingrese el nombre del producto: ");
                String nombre = scanner.nextLine();
                productoEncontrado = buscarProductoPorNombre(nombre);
            }
            case 2 -> {
                System.out.print("Ingrese la marca del producto: ");
                String marca = scanner.nextLine();
                productoEncontrado = buscarProductoPorMarca(marca);
            }
            case 3 -> {
                System.out.print("Ingrese el ID del producto: ");
                int id = obtenerOpcion(scanner);
                productoEncontrado = buscarProductoPorId(id);
            }
            default -> System.out.println("Opción no válida.");
        }

        if (productoEncontrado != null) {
            System.out.println("Producto encontrado: " + productoEncontrado);
            System.out.println("¿Qué desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Marca");
            System.out.println("3. Precio");
            int opcionModificar = obtenerOpcion(scanner);
            scanner.nextLine(); 

            switch (opcionModificar) {
                case 1 -> {
                    System.out.print("Ingrese el nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    productoEncontrado.setNombre(nuevoNombre);
                    System.out.println("Nombre actualizado.");
                }
                case 2 -> {
                    System.out.print("Ingrese la nueva marca: ");
                    String nuevaMarca = scanner.nextLine();
                    productoEncontrado.setMarca(nuevaMarca);
                    System.out.println("Marca actualizada.");
                }
                case 3 -> {
                    System.out.print("Ingrese el nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    productoEncontrado.setPrecio(nuevoPrecio);
                    System.out.println("Precio actualizado.");
                }
                default -> System.out.println("Opción no válida.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    public static Producto buscarProductoPorNombre(String nombre) {
        for (Producto p : productos) {
            if (!p.getNombre().equalsIgnoreCase(nombre)) {
            } else {
                return p;
            }
        }
        return null;
    }
  
    public static Producto buscarProductoPorMarca(String marca) {
        for (Producto p : productos) {
            if (p.getMarca().equalsIgnoreCase(marca)) {
                return p;
            }
        }
        return null;
    }

    public static Producto buscarProductoPorId(int id) {
        for (Producto p : productos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    // Opción 2:
    public static void verCarrito() {
        System.out.println("--- Ver Carrito ---");
        System.out.println("Carrito vacío (por implementar).");
    }

    //Opcion 3: 
   private static final Carrito carrito = new Carrito(1, "Usuario actual", ""); 
   
    public static void agregarProductoAlCarrito(Scanner scanner) {
       System.out.print("Ingrese el ID del producto a agregar al carrito: ");
       int id = scanner.nextInt();
       scanner.nextLine(); 
    
       Producto producto = buscarProductoPorId(id);  
       if (producto != null) {
            System.out.print("Ingrese la cantidad del producto: ");
            int cantidad = scanner.nextInt();
            carrito.agregarProducto(producto, cantidad);  
        } else {
        System.out.println("Producto no encontrado.");
    }
}
   
    // Opción 4: 
    public static void generarComprobante() {
        System.out.println("--- Generar Comprobante ---");
        System.out.println("Comprobante generado (por implementar).");
    }


    public static int obtenerOpcion(Scanner scanner) {
        int opcion = -1;
        try {
            opcion = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Error: Debe ingresar un número.");
            scanner.nextLine(); 
        }
        return opcion;
    }

    private static void iniciarSesion(Scanner scanner) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

}

    

