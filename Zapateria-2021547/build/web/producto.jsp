<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <title>Essenza | Gestión de Productos</title>
        <link rel="stylesheet" href="Styles/proveedor.css" />
    </head>
    <body>

        <div class="contenedor-principal">

            <div class="form-container">
                <h2>Gestión de Productos</h2>

                <form action="Controlador?menu=Producto" method="POST" class="formulario">
                    <input type="text" value="${producto.codigoProducto}" name="txtCodigoProducto" placeholder="ID" readonly />
                    <input type="text" value="${producto.nombreProducto}" name="txtNombreProducto" placeholder="Nombre Producto" required />
                    <input type="text" value="${producto.marca}" name="txtMarca" placeholder="Marca" required />
                    <input type="number" value="${producto.talla}" name="txtTalla" placeholder="Talla" required />
                    <input type="text" value="${producto.color}" name="txtColor" placeholder="Color" required />
                    <input type="number" step="0.01" value="${producto.precioProducto}" name="txtPrecio" placeholder="Precio" required />
                    <input type="number" value="${producto.stock}" name="txtStock" placeholder="Stock" required />

                    <div class="botones">
                        <button type="submit" name="accion" value="Agregar">Agregar</button>
                        <button type="submit" name="accion" value="Actualizar">Actualizar</button>
                    </div>
                </form>

                <!-- Formulario para buscar producto por código -->
                <form action="Controlador?menu=Producto" method="POST" class="formulario" style="margin-top: 20px;">
                    <input type="number" name="txtBuscarCodigo" placeholder="Buscar por código..." required />
                    <button type="submit" name="accion" value="Buscar">Buscar</button>
                </form>
            </div>

            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>Marca</th>
                            <th>Talla</th>
                            <th>Color</th>
                            <th>Precio</th>
                            <th>Stock</th>
                            <th>Opciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="producto" items="${productos}">
                            <tr>
                                <td>${producto.codigoProducto}</td>
                                <td>${producto.nombreProducto}</td>
                                <td>${producto.marca}</td>
                                <td>${producto.talla}</td>
                                <td>${producto.color}</td>
                                <td>${producto.precioProducto}</td>
                                <td>${producto.stock}</td>
                                <td>
                                    <a href="Controlador?menu=Producto&accion=Editar&codigoProducto=${producto.codigoProducto}" class="btn btn-editar">Editar</a>
                                    <a href="Controlador?menu=Producto&accion=Eliminar&codigoProducto=${producto.codigoProducto}" class="btn btn-eliminar">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

    </body>
</html>
