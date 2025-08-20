package Modelo;

import Config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int resp;

    // Método Listar
    public List<Producto> listar() {
        String sql = "CALL sp_ListarProductos()";
        List<Producto> listaProducto = new ArrayList<>();

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Producto prod = new Producto();

                prod.setCodigoProducto(rs.getInt(1));
                prod.setNombreProducto(rs.getString(2));
                prod.setMarca(rs.getString(3));
                prod.setTalla(rs.getInt(4));
                prod.setColor(rs.getString(5));
                prod.setPrecioProducto(rs.getBigDecimal(6));
                prod.setStock(rs.getInt(7));

                listaProducto.add(prod);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProducto;
    }

    // Método Agregar
    public int agregar(Producto prod) {
        String sql = "CALL sp_AgregarProducto(?, ?, ?, ?, ?, ?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);

            ps.setString(1, prod.getNombreProducto());
            ps.setString(2, prod.getMarca());
            ps.setInt(3, prod.getTalla());
            ps.setString(4, prod.getColor());
            ps.setBigDecimal(5, prod.getPrecioProducto());
            ps.setInt(6, prod.getStock());

            resp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resp;
    }

    // Método Buscar por código
    public Producto listarPorCodigo(int id) {
        Producto prod = new Producto();

        String sql = "CALL sp_BuscarProducto(" + id + ")";
        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                prod.setCodigoProducto(rs.getInt(1));
                prod.setNombreProducto(rs.getString(2));
                prod.setMarca(rs.getString(3));
                prod.setTalla(rs.getInt(4));
                prod.setColor(rs.getString(5));
                prod.setPrecioProducto(rs.getBigDecimal(6));
                prod.setStock(rs.getInt(7));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prod;
    }

    // Método Actualizar
    public int actualizar(Producto prod) {
        String sql = "CALL sp_EditarProducto(?, ?, ?, ?, ?, ?,?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, prod.getCodigoProducto());
            ps.setString(2, prod.getNombreProducto());
            ps.setString(3, prod.getMarca());
            ps.setInt(4, prod.getTalla());
            ps.setString(5, prod.getColor());
            ps.setBigDecimal(6, prod.getPrecioProducto());
            ps.setInt(7, prod.getStock());

            resp = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resp;
    }

    // Método Eliminar
    public void eliminar(int codProducto) {
        String sql = "CALL sp_EliminarProducto(?)";

        try {
            con = cn.Conexion();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codProducto);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
