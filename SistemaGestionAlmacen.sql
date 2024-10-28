create database SistemaGestionAlmacenDonRaul;
USE SistemaGestionAlmacenDonRaul;

-- Tabla Producto
CREATE TABLE Producto (
    idProducto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255),
    precio DECIMAL(10, 2) NOT NULL,
    idCategoria Int,
    CONSTRAINT fk_categoria FOREIGN KEY (idCategoria) REFERENCES Categoria(idCategoria),
    CONSTRAINT fk_proveedor FOREIGN KEY (idProveedor) REFERENCES Proveedor(idProveedor)
);

-- Tabla Categoria
CREATE TABLE Categoria (
    idCategoria INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

-- Tabla Proovedores
CREATE TABLE Proveedor (
    idProveedor INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    contacto VARCHAR(100),
    direccion VARCHAR(255),
    telefono VARCHAR(20)
);

-- Tabla Usuario
CREATE TABLE Usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    contraseña VARCHAR(255) NOT NULL, 
    idRol INT,
    CONSTRAINT fk_rol_usuario FOREIGN KEY (idRol) REFERENCES Rol(idRol)
);

-- Tabla Comprobante Venta
CREATE TABLE ComprobanteVenta(
    idComprobante INT AUTO_INCREMENT PRIMARY KEY,
    fechaComprobante TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10, 2) NOT NULL,
    idCliente INT,
    idUsuario INT,
    CONSTRAINT fk_usuario_comprobante FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario),
    CONSTRAINT fk_cliente FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);

-- Tabla Clientes
CREATE TABLE Cliente (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    telefono VARCHAR(20),
    email VARCHAR(255) UNIQUE
);

-- Tabla Carrito de Compras
CREATE TABLE Carrito (
    idCarrito INT AUTO_INCREMENT PRIMARY KEY,
    idUsuario INT,
	idProducto INT,
    fechaCreacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    cantidad INT NOT NULL,
    precioUnitario DECIMAL(10, 2) NOT NULL,
    total DECIMAL(10, 2) DEFAULT 0.00,
    CONSTRAINT fk_usuario_carrito FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

-- Tabla Rol (Administrativo/Atencion al publico)
CREATE TABLE Rol (
    idRol INT AUTO_INCREMENT PRIMARY KEY,
    nombreRol VARCHAR(50) NOT NULL, 
    
);





