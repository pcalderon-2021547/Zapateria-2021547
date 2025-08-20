<%-- 
    Document   : proveedor
    Created on : 20/08/2025, 00:12:43
    Author     : pcc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8" />
        <title>Essenza | Gestión de Proveedores</title>
        <link rel="stylesheet" href="Styles/proveedor.css" />
    </head>
    <body>

        <nav>
            <!-- Aquí podrías agregar tu navegación si la necesitas -->
        </nav>

        <div class="contenedor-principal">

            <div class="form-container">
                <h2>Gestión de Proveedores</h2>
                <form action="Controlador?menu=Proveedor" method="POST" class="formulario">
                    <input type="text" value="${proveedor.codigoProveedor}" name="txtCodigoProveedor" placeholder="ID" readonly />
                    <input type="text" value="${proveedor.nombreProveedor}" name="txtNombreProveedor" placeholder="Nombre" required />
                    <input type="text" value="${proveedor.apellidoProveedor}" name="txtApellidoProveedor" placeholder="Apellido" required />
                    <input type="email" value="${proveedor.emailProveedor}" name="txtCorreoProveedor" placeholder="Correo" required />
                    <input type="number" value="${proveedor.producto.codigoProducto}" name="txtCodigoProducto" placeholder="Código de Producto" required />

                    <div class="botones">
                        <button type="submit" name="accion" value="Agregar">Agregar</button>
                        <button type="submit" name="accion" value="Actualizar">Actualizar</button>
                    </div>
                </form>
                <form action="Controlador?menu=Proveedor" method="POST" class="formulario" style="margin-top: 20px;">
                    <input type="number" name="txtBuscarCodigo" placeholder="Buscar por código..." required />
                    <button type="submit" name="accion" value="Buscar">Buscar</button>
            </div>

            <div class="table-container">
                <table>
                    <thead>
                        <tr>
                            <th>Código</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Correo</th>
                            <th>Cód. Producto</th>
                            <th>Opciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="proveedor" items="${proveedores}">
                            <tr>
                                <td>${proveedor.codigoProveedor}</td>
                                <td>${proveedor.nombreProveedor}</td>
                                <td>${proveedor.apellidoProveedor}</td>
                                <td>${proveedor.emailProveedor}</td>
                                <td>${proveedor.producto.codigoProducto}</td>
                                <td>
                                    <a href="Controlador?menu=Proveedor&accion=Editar&codigoProveedor=${proveedor.codigoProveedor}" 
                                       class="btn btn-editar">Editar</a>
                                
                             
                                    <a href="Controlador?menu=Proveedor&accion=Eliminar&codigoProveedor=${proveedor.codigoProveedor}" 
                                       class="btn btn-eliminar">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>

        </div>

    </body>
</html>
