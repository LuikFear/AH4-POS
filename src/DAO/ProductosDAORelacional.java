/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author LuikFear
 */
public class ProductosDAORelacional {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    connection acceso = new connection();
    
     public LinkedList<Productos> listarP() {

        String sql = "select * from productos";

        LinkedList<Productos> listarP = new LinkedList<>();

        try {

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                listarP.add(new Productos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5)));

            }
            return listarP;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
    
    
    
    public void crear_pro(Productos pro) {
        String sql = "insert into Productos (codigo,nombre,descripcion,cantidad,precio) values (?,?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setString(3, pro.getDescripcion());
            ps.setInt(4, pro.getCantidad());
            ps.setFloat(5, pro.getPrecio());
           

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
    
    
     public void modificar_pro(Productos pro) {
        String sql = "update productos set nombre=?,descripcion=?, cantidad=?, precio=? where codigo=?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getNombre());
            ps.setString(2, pro.getDescripcion());
            ps.setInt(3, pro.getCantidad());
            ps.setFloat(4, pro.getPrecio());
            ps.setInt(5, pro.getCodigo());
       

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
    
    public Productos obtener_pro(int codigo) {
        String sql = "select * from productos where codigo= ?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Productos(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getFloat(5));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron Resultados");
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    
    
    public void eliminar_pro(int codigo) {
        String sql = "DELETE FROM productos WHERE codigo = ?;";

        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
             System.out.println(e);
        }
    }
    
    
    
    
    
    
    
}

