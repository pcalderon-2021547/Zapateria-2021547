package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    // Método Listar
    public List<Proveedor> listar() {
        String sql = "call sp_ListarProveedores()";
        List<Proveedor> listaProveedor = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Proveedor prov = new Proveedor();
                Producto prod = new Producto();

                prov.setCodigoProveedor(rs.getInt(1));
                prov.setNombreProveedor(rs.getString(2));
                prov.setApellidoProveedor(rs.getString(3));
                prov.setEmailProveedor(rs.getString(4));

                prod.setCodigoProducto(rs.getInt(5));
                prov.setProducto(prod);

                listaProveedor.add(prov);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProveedor;
    }

    // Método Agregar
    public int agregar(Proveedor prov) {
        String sql = "call sp_AgregarProveedor(?, ?, ?, ?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, prov.getNombreProveedor());
            ps.setString(2, prov.getApellidoProveedor());
            ps.setString(3, prov.getEmailProveedor());
            ps.setInt(4, prov.getProducto().getCodigoProducto());

            resp = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resp;
    }

    // Método Buscar por código (listar un proveedor)
    public Proveedor listarPorCodigo(int id) {
        Proveedor prov = new Proveedor();
        Producto prod = new Producto();

        String sql = "CALL sp_BuscarProveedor(" + id + ")";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                prov.setCodigoProveedor(rs.getInt(1));
                prov.setNombreProveedor(rs.getString(2));
                prov.setApellidoProveedor(rs.getString(3));
                prov.setEmailProveedor(rs.getString(4));
                prod.setCodigoProducto(rs.getInt(5));
                prov.setProducto(prod);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prov;
    }

    // Método Actualizar
    public int actualizar(Proveedor prov) {
        String sql = "call sp_editarProveedor(?, ?, ?, ?, ?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setInt(1, prov.getCodigoProveedor());
            ps.setString(2, prov.getNombreProveedor());
            ps.setString(3, prov.getApellidoProveedor());
            ps.setString(4, prov.getEmailProveedor());
            ps.setInt(5, prov.getProducto().getCodigoProducto());

            resp = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resp;
    }

    // Método Eliminar
    public void eliminar(int codProveedor) {
        String sql = "call sp_eliminarProveedor(?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codProveedor);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
