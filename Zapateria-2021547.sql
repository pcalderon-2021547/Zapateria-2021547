drop database if exists DB_Zapateria;
create database DB_Zapateria;
use DB_Zapateria;
create table Productos (
    codigoProducto int not null auto_increment,
    nombreProducto varchar(255) ,
    marca varchar(255),
    talla int,
    color varchar(255),
    precioProducto decimal(10,2),
    stock int,
    primary key PK_codigoProducto(codigoProducto)
);
create table Proveedores (
codigoProveedor int not null auto_increment,
nombreProveedor varchar(255),
apellidoProveedor varchar(255),
emailProveedor varchar(255),
primary key PK_codigoProveedor(codigoProveedor),
codigoProducto int,
constraint FK_producto foreign key (codigoProducto) 
        references Productos(codigoProducto) on delete cascade
);
Delimiter //
create procedure sp_AgregarProducto(
    in nombreProducto varchar(255),
    in marca varchar(255),
    in talla int,
    in color varchar(255),
    in precioProducto decimal(10,2),
    in stock int)
begin
    insert into Productos (nombreProducto, marca, talla, color, precioProducto, stock)
    values (nombreProducto, marca, talla, color, precioProducto, stock);
end //
Delimiter ;
call sp_AgregarProducto('Zapatos Deportivos', 'Nike', 42, 'Negro', 89.99, 150);
call sp_AgregarProducto('Zapatos Casual', 'Adidas', 40, 'Blanco', 75.50, 100);
call sp_AgregarProducto('Botines', 'Puma', 41, 'Marrón', 120.00, 60);
call sp_AgregarProducto('Zapatillas Running', 'Asics', 43, 'Azul', 95.00, 80);
call sp_AgregarProducto('Zapatos de Cuero', 'Clarks', 44, 'Negro', 150.00, 40);
call sp_AgregarProducto('Sandalias', 'Birkenstock', 39, 'Beige', 55.00, 70);
call sp_AgregarProducto('Zapatos Formales', 'Cole Haan', 42, 'Marrón', 140.00, 50);
call sp_AgregarProducto('Zapatillas Skate', 'Vans', 41, 'Negro', 65.00, 90);
call sp_AgregarProducto('Zapatos de Seguridad', 'Caterpillar', 43, 'Amarillo', 130.00, 30);
call sp_AgregarProducto('Zapatos para Correr', 'New Balance', 44, 'Gris', 100.00, 120);
 

Delimiter //
create procedure sp_ListarProductos()
begin
    select codigoProducto, nombreProducto, marca, talla, color, precioProducto, stock
    from Productos;
end //
Delimiter ;
call sp_ListarProductos();
Delimiter //
create procedure sp_EliminarProducto(in codigoP int)
begin
    delete from Productos
    where codigoProducto = codigoP;
end //
Delimiter ;
-- call sp_EliminarProducto(1);
Delimiter //
create procedure sp_BuscarProducto(in codigoP int)
begin
    select codigoProducto, nombreProducto, marca, talla, color, precioProducto, stock
    from Productos
    where codigoProducto = codigoP;
end //
Delimiter ;
call sp_BuscarProducto(2);

Delimiter //
create procedure sp_EditarProducto(
    in codigoP int,
    in nombreP varchar(255),
    in marcaP varchar(255),
    in tallaP int,
    in colorP varchar(255),
    in precioP decimal(10,2),
    in stockP int)
begin
    update Productos
    set nombreProducto = nombreP,
        marca = marcaP,
        talla = tallaP,
        color = colorP,
        precioProducto = precioP,
        stock = stockP
    where codigoProducto = codigoP;
end //
Delimiter ;
call sp_EditarProducto(3, 'Zapatillas', 'Puma', 41, 'Negro', 89.99, 150);
-- ----------------------------------------------------------------------------
Delimiter //
create procedure sp_AgregarProveedor(
    in nombreProveedor varchar(255),
    in apellidoProveedor varchar(255),
    in emailProveedor varchar(255),
    in codigoProducto int)
begin
    insert into Proveedores (nombreProveedor, apellidoProveedor, emailProveedor, codigoProducto)
    values (nombreProveedor, apellidoProveedor, emailProveedor, codigoProducto);
end //
Delimiter ;
 
call sp_AgregarProveedor('Juan', 'Gómez', 'juan@gmail.com', 3);
call sp_AgregarProveedor('Luis', 'Martínez', 'luis@hotmail.com', 7);
call sp_AgregarProveedor('Carlos', 'López', 'carlos@gmail.com', 1);
call sp_AgregarProveedor('Ana', 'Ramírez', 'ana@gmail.com', 10);
call sp_AgregarProveedor('María', 'Fernández', 'maria@hotmail.com', 5);
call sp_AgregarProveedor('Pedro', 'Sánchez', 'pedro@gmail.com', 9);
call sp_AgregarProveedor('Laura', 'Vega', 'laura@hotmail.com', 2);
call sp_AgregarProveedor('Miguel', 'Torres', 'miguel@gmail.com', 6);
call sp_AgregarProveedor('Sofía', 'Castillo', 'sofia@hotmail.com', 8);
call sp_AgregarProveedor('Jorge', 'Díaz', 'jorge@gmail.com', 4);
 

Delimiter //
create procedure sp_ListarProveedores()
begin
    select codigoProveedor, nombreProveedor, apellidoProveedor, emailProveedor, codigoProducto
    from Proveedores;
end //
Delimiter ;
call sp_ListarProveedores();
Delimiter //
create procedure sp_EliminarProveedor(in codigoP int)
begin
    delete from Proveedores
    where codigoProveedor = codigoP;
end //
Delimiter ;
-- call sp_EliminarProveedor(1);
Delimiter //
create procedure sp_BuscarProveedor(in codigoP int)
begin
    select codigoProveedor, nombreProveedor, apellidoProveedor, emailProveedor, codigoProducto
    from Proveedores
    where codigoProveedor = codigoP;
end //
Delimiter ;
call sp_BuscarProveedor(2);
Delimiter //
create procedure sp_EditarProveedor(
    in codigoP int,
    in nombreP varchar(255),
    in apellidoP varchar(255),
    in emailP varchar(255),
    in codigoProd int)
begin
    update Proveedores
    set nombreProveedor = nombreP,
        apellidoProveedor = apellidoP,
        emailProveedor = emailP,
        codigoProducto = codigoProd
    where codigoProveedor = codigoP;
end //
Delimiter ;
call sp_EditarProveedor(3,'Carlos', 'López', 'carlos@outlook.com', 2);