<%-- 
    Document   : index
    Created on : 20/08/2025, 00:12:43
    Author     : pcc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Menú Principal</title>
        <link rel="stylesheet" href="Styles/index.css">
    </head>
    <body>
        <nav>
            <ul>
                <li><a href="Controlador?menu=Producto&accion=Listar" target="contenido">Productos</a></li>
                <li><a href="Controlador?menu=Proveedor&accion=Listar" target="contenido">Proveedores</a></li>
            </ul>
        </nav>

        <div class="panel">
            <h2>Bienvenido a la ventana de Administrador</h2>
        </div>

        <div class="contenido">
            <iframe name="contenido" frameborder="0"></iframe>
        </div>

    </body>
</html>



