use SistemaGestionAlmacenDonRaul;

-- Ingreso de Datos

INSERT INTO Producto (nombre, descripcion, precio, idCategoria, idProducto)
VALUES
('Pan francés', 'precio por kilogramo - Harina de trigo', 1000, 1, 1),
('Pan Roceta', 'precio por kilogramo - Harina de trigo', 1200, 1, 2),
('Queso Cheddar', 'precio por kilogramo', 8500, 2, 10),
('Jamón Cocido', 'precio por kilogramo', 7500, 2, 11),
('Jamón Crudo', 'precio por kilogramo', 19500, 2, 12),
('Cocacola 2.5L', 'Retornable- Precio no incluye envase', 2500, 2, 30),
('Cocacola 2L', 'Retornable- Precio no incluye envase', 2100, 2, 31);


INSERT INTO Categoria (nombre)
VALUES
('Lácteos'),
('Fiambrería'),
('Bebidas'),
('Panadería'),
('Congelados');

INSERT INTO Proveedor (nombreP, contacto, direccion, telefono, idProveedor)
VALUES
('Lácteos La Serena', 'Pedro Gómez', 'Calle 45 No. 123', '03515555678', 1),
('Carnes Don Juan', 'Juan Martínez', 'Av. Colón 200', '0351558910', 2),
('Panificados El Grano', 'Roberto López', 'Calle 25 de Mayo 600', '03515552345',3);

INSERT INTO Usuario (nombre, correo, contraseña, idRol)
VALUES
('user1', 'fabiammercado@example.com', 'contrasena2356', 1),
('user2', 'javiersosa@gmail.com', 'contrasena8956', 1),
('user3', 'nicolascabrera@gmail.com', 'contrasena2346', 2),
('admin1', 'joseluismestre@gmail.com', 'contrasena1234', 2);

-- Consulta de tabla producto 
SELECT * FROM Producto;

-- Consulta de tabla categoria
SELECT * FROM Categoria;

-- Consulta de tabla proovedores
SELECT * FROM Proveedor;

-- Consulta de tabla usuarios
SELECT * FROM Usuario WHERE estado = 'activo';

-- Borrar Producto 
DELETE FROM Producto WHERE idProducto = 1;

-- Borra Categoria 
DELETE FROM Categoria WHERE idCategoria = 2;







