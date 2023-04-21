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
                
               
                   listarV.add(new Vendedores(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5)));
       
            }
            return listarV;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    
    
    
    
   
    public Vendedores obtener_vendedor(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void crear_vendedor(Vendedores vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public void modificar_vendedor(Vendedores vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    public void eliminar_vendedor(int codigo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
