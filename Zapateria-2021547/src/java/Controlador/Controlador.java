package Controlador;

import Modelo.Producto;
import Modelo.ProductoDAO;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Controlador extends HttpServlet {

    Producto producto = new Producto();
    ProductoDAO productoDAO = new ProductoDAO();
    Proveedor proveedor = new Proveedor();
    ProveedorDAO proveedorDAO = new ProveedorDAO();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("Menu Principal")) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        if (menu != null) {
            switch (menu) {
                case "Producto":
                    switch (accion) {
                        case "Listar":
                            List listaProductos = productoDAO.listar();
                            request.setAttribute("productos", listaProductos);
                            break;

                        case "Agregar":
                            String nombreProducto = request.getParameter("txtNombreProducto");
                            String marca = request.getParameter("txtMarca");
                            int talla = Integer.parseInt(request.getParameter("txtTalla"));
                            String color = request.getParameter("txtColor");
                            BigDecimal precio = new BigDecimal(request.getParameter("txtPrecio"));
                            int stock = Integer.parseInt(request.getParameter("txtStock"));

                            producto.setNombreProducto(nombreProducto);
                            producto.setMarca(marca);
                            producto.setTalla(talla);
                            producto.setColor(color);
                            producto.setPrecioProducto(precio);
                            producto.setStock(stock);

                            productoDAO.agregar(producto);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                            break;

                        case "Editar":
                            int codigoProducto = Integer.parseInt(request.getParameter("codigoProducto"));
                            Producto prod = productoDAO.listarPorCodigo(codigoProducto);
                            request.setAttribute("producto", prod);

                            List listaProductosEditar = productoDAO.listar();
                            request.setAttribute("productos", listaProductosEditar);

                            request.getRequestDispatcher("producto.jsp").forward(request, response);
                            break;

                        case "Actualizar":
                            int codProd = Integer.parseInt(request.getParameter("txtCodigoProducto"));
                            nombreProducto = request.getParameter("txtNombreProducto");
                            marca = request.getParameter("txtMarca");
                            talla = Integer.parseInt(request.getParameter("txtTalla"));
                            color = request.getParameter("txtColor");
                            precio = new BigDecimal(request.getParameter("txtPrecio"));
                            stock = Integer.parseInt(request.getParameter("txtStock"));

                            producto.setCodigoProducto(codProd);
                            producto.setNombreProducto(nombreProducto);
                            producto.setMarca(marca);
                            producto.setTalla(talla);
                            producto.setColor(color);
                            producto.setPrecioProducto(precio);
                            producto.setStock(stock);

                            productoDAO.actualizar(producto);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                            break;

                        case "Eliminar":
                            int codEliminar = Integer.parseInt(request.getParameter("codigoProducto"));
                            productoDAO.eliminar(codEliminar);
                            request.getRequestDispatcher("Controlador?menu=Producto&accion=Listar").forward(request, response);
                            break;

                        case "Buscar":
                            int codigoBuscar = Integer.parseInt(request.getParameter("txtBuscarCodigo"));
                            Producto productoBuscado = productoDAO.listarPorCodigo(codigoBuscar);

                            List<Producto> listaBusqueda = new ArrayList<>();
                            if (productoBuscado.getCodigoProducto() != 0) {
                                listaBusqueda.add(productoBuscado);
                            }

                            request.setAttribute("productos", listaBusqueda);
                            break;

                        default:
                            throw new AssertionError();
                    }

                    request.getRequestDispatcher("producto.jsp").forward(request, response);
                    break;

                case "Proveedor":
                    switch (accion) {
                        case "Listar":
                            List<Proveedor> listaProveedores = proveedorDAO.listar();
                            request.setAttribute("proveedores", listaProveedores);
                            break;

                        case "Agregar":
                            String nombreProveedor = request.getParameter("txtNombreProveedor");
                            String apellidoProveedor = request.getParameter("txtApellidoProveedor");
                            String correoProveedor = request.getParameter("txtCorreoProveedor");
                            int codProducto = Integer.parseInt(request.getParameter("txtCodigoProducto"));

                            proveedor.setNombreProveedor(nombreProveedor);
                            proveedor.setApellidoProveedor(apellidoProveedor);
                            proveedor.setEmailProveedor(correoProveedor);

                            producto.setCodigoProducto(codProducto);
                            proveedor.setProducto(producto);

                            proveedorDAO.agregar(proveedor);
                            request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                            break;

                        case "Editar":
                            int codProveedor = Integer.parseInt(request.getParameter("codigoProveedor"));
                            Proveedor p = proveedorDAO.listarPorCodigo(codProveedor);
                            request.setAttribute("proveedor", p);

                            // Mantener la lista para mostrar en la tabla
                            List<Proveedor> listaProveedoresEditar = proveedorDAO.listar();
                            request.setAttribute("proveedores", listaProveedoresEditar);

                            request.getRequestDispatcher("proveedor.jsp").forward(request, response);
                            break;

                        case "Actualizar":
                            int codProveedorActualizar = Integer.parseInt(request.getParameter("txtCodigoProveedor"));
                            nombreProveedor = request.getParameter("txtNombreProveedor");
                            apellidoProveedor = request.getParameter("txtApellidoProveedor");
                            correoProveedor = request.getParameter("txtCorreoProveedor");
                            codProducto = Integer.parseInt(request.getParameter("txtCodigoProducto"));

                            proveedor.setCodigoProveedor(codProveedorActualizar);
                            proveedor.setNombreProveedor(nombreProveedor);
                            proveedor.setApellidoProveedor(apellidoProveedor);
                            proveedor.setEmailProveedor(correoProveedor);

                            producto = new Producto();
                            producto.setCodigoProducto(codProducto);
                            proveedor.setProducto(producto);

                            proveedorDAO.actualizar(proveedor);
                            request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                            break;

                        case "Eliminar":
                            codProveedor = Integer.parseInt(request.getParameter("codigoProveedor"));
                            proveedorDAO.eliminar(codProveedor);
                            request.getRequestDispatcher("Controlador?menu=Proveedor&accion=Listar").forward(request, response);
                            break;

                        case "Buscar":
                            int codigoBuscar = Integer.parseInt(request.getParameter("txtBuscarCodigo"));
                            Proveedor proveedorBuscado = proveedorDAO.listarPorCodigo(codigoBuscar);

                            List<Proveedor> listaBusqueda = new ArrayList<>();
                            if (proveedorBuscado.getCodigoProveedor() != 0) {
                                listaBusqueda.add(proveedorBuscado);
                            }

                            request.setAttribute("proveedores", listaBusqueda);
                            break;

                        default:
                            throw new AssertionError();
                    }

                    request.getRequestDispatcher("proveedor.jsp").forward(request, response);
                    break;

            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
