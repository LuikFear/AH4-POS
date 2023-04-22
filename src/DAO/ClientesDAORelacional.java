/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author LuikFear
 */
public class ClientesDAORelacional implements DAOCLientesInterface{
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    connection acceso = new connection();

    @Override
    public LinkedList<Clientes> listar() {
       
          String sql = "select * from clientes";
           
           LinkedList<Clientes> listar = new LinkedList<>();
            
        try {

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                
               
                   listar.add(new Clientes(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5)));
       
            }
            return listar;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    
    
    }

    @Override
    public Clientes obtener_cliente(int codigo) {
         String sql = "select * from clientes where codigo= ?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Clientes(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron Resultados");
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    

    @Override
    public void crear_cliente(Clientes cliente) {
       String sql = "insert into clientes (codigo,nombre,nit,correo,genero) values (?,?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, cliente.getCodigo());
            ps.setString(2, cliente.getNombre());
            ps.setInt(3, cliente.getNit());
            ps.setString(4, cliente.getCorreo());
            ps.setString(5, cliente.getGenero());
           

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void modificar_cliente(Clientes cliente) {
         String sql = "update clientes set nombre=?, nit=?, correo=?, genero=? where codigo=?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setInt(2, cliente.getNit());
            ps.setString(3, cliente.getCorreo());
            ps.setString(4, cliente.getGenero());
            ps.setInt(5, cliente.getCodigo());
       

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void eliminar_cliente(int codigo) {
         String sql = "DELETE FROM clientes WHERE codigo = ?;";

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

    
    
    
    
    
   