/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Vendedores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author LuikFear
 */
public class VendedoresDAORelacional implements DAOVendedoresInterface{ 
    
     
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    connection acceso = new connection();

    
    
    public LinkedList<Vendedores> listarV() {
        
        String sql = "select * from vendedores";
           
           LinkedList<Vendedores> listarV = new LinkedList<>();
            
        try {

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                
               
                   listarV.add(new Vendedores(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),rs.getString(1)));
       
            }
            return listarV;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    
    
    
    
   
    @Override
    public Vendedores obtener_vendedor(int codigo) {
        String sql = "select * from vendedores where codigo= ?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Vendedores(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),rs.getString(6));
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
    public void crear_vendedor(Vendedores vendedor) {
        String sql = "insert into vendedores (codigo,nombre,caja,ventas,genero,password) values (?,?,?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            
            ps.setInt(1, vendedor.getCodigo());
            ps.setString(2, vendedor.getNombre());
            ps.setInt(3, vendedor.getCaja());
            ps.setInt(4, vendedor.getVentas());
            ps.setString(5, vendedor.getGenero());
            ps.setString(6, vendedor.getPass());
           
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
        
        
        
        
    }

   
    @Override
    public void modificar_vendedor(Vendedores vendedor) {
       String sql = "update vendedores set nombre=?, caja=?, ventas=?, genero=?, password=? where codigo=?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, vendedor.getNombre());
            ps.setInt(2, vendedor.getCaja());
            ps.setInt(3, vendedor.getVentas());
            ps.setString(4, vendedor.getGenero());
            ps.setString(5, vendedor.getPass());
            ps.setInt(6, vendedor.getCodigo());
            
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    

  
    @Override
    public void eliminar_vendedor(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
   
    
}
