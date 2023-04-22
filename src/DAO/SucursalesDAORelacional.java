
package DAO;


import MODEL.Sucursales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JOptionPane;




public class SucursalesDAORelacional {
    
     Connection con;
    PreparedStatement ps;
    ResultSet rs;
    connection acceso = new connection();
    
    public LinkedList<Sucursales> listar() {
       
          String sql = "select * from sucursales";
           
           LinkedList<Sucursales> listar = new LinkedList<>();
            
        try {

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                
               
                   listar.add(new Sucursales(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
       
            }
            return listar;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    
    
    }
    
     public Sucursales obtener_sucursal(int codigo) {
         String sql = "select * from sucursales where codigo= ?";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Sucursales(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron Resultados");
            }
            return null;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
    
    public void crear_sucursal(Sucursales sucursal) {
       String sql = "insert into sucursales (codigo,nombre,direccion,correo,telefono) values (?,?,?,?,?);";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);

            ps.setInt(1, sucursal.getCodigo());
            ps.setString(2, sucursal.getNombre());
            ps.setString(3, sucursal.getDireccion());
            ps.setString(4, sucursal.getCorreo());
            ps.setInt(5, sucursal.getTelefono());
           

            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
     public void modificar_sucursal(Sucursales sucursal) {
         String sql = "update sucursales set nombre=?, direccion=?, correo=?, telefono=? where codigo=?;";
        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, sucursal.getNombre());
            ps.setString(2, sucursal.getDireccion());
            ps.setString(3, sucursal.getCorreo());
            ps.setInt(4, sucursal.getTelefono());
            ps.setInt(5, sucursal.getCodigo());
       

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    
     public void eliminar_sucursal(int codigo) {
         String sql = "DELETE FROM sucursales WHERE codigo = ?;";

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
