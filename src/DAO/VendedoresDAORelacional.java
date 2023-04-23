/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Vendedores;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author LuikFear
 */
public class VendedoresDAORelacional implements DAOVendedoresInterface {

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

                listarV.add(new Vendedores(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(1)));

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
                return new Vendedores(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getString(6));
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
        String sql = "DELETE FROM vendedores WHERE codigo = ?;";

        try {
            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, codigo);
            ps.executeUpdate();
        } catch (Exception e) {
             System.out.println(e);
        }
    }

    public Vendedores consultar_vendedores (String correo, String contraseña){
         
         String sql = "select * from vendedores where nombre=? and password = ? ";
         
         try {
              con = acceso.Conectar();
            ps = con.prepareStatement(sql);
              ps.setString(1,correo);
              ps.setString(2,contraseña);
              
              rs= ps.executeQuery();
              
              
              if (rs.next()) {
                  Vendedores vendedor = new Vendedores(rs.getInt(1), rs.getString(2), rs.getString (6));
                  return vendedor;
             }
              
              
         } catch (Exception e) {
             System.out.println(e);
         }
         
         
         return null;
    
    }
    
        private String leerarchivoV() {
        JFileChooser fc = new JFileChooser();
        JPanel datos = new JPanel();
        int op = fc.showOpenDialog(datos);
        String content = "";
        if (op == JFileChooser.APPROVE_OPTION) {
            File pRuta = fc.getSelectedFile();
            String ruta = pRuta.getAbsolutePath();
            File archivo = null;
            FileReader fr = null;
            BufferedReader br = null;

            try {
                archivo = new File(ruta);
                fr = new FileReader(archivo);
                br = new BufferedReader(fr);
                String linea = "";

                while ((linea = br.readLine()) != null) {
                    content += linea + "\n";
                }
                return content;

            } catch (FileNotFoundException ex) {
                JOptionPane.showInputDialog(null, "No se encontro el archivo");
            } catch (IOException ex) {
                JOptionPane.showInputDialog(null, "No se pudo abrir el archivo");
            } finally {
                try {
                    if (null != fr) {
                        fr.close();
                    }
                } catch (Exception e2) {
                    JOptionPane.showInputDialog(null, "No se encontro el archivo");
                    return "";
                }
            }
            return content;
        }
        return null;
    }

        
        
        public static void main(String[] args) throws IOException, FileNotFoundException, ParseException, SQLException {
        VendedoresDAORelacional js = new VendedoresDAORelacional();
            js.carga_masiva();
            
    }
        
        
        
        
    public void carga_masiva() throws FileNotFoundException, IOException, ParseException, SQLException {
        
        String archivo_retorno = leerarchivoV();
    JsonParser parse = new JsonParser();
    JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();

    
    try {
       String sql = "insert into vendedores (codigo,nombre,caja,ventas,genero,password) values (?,?,?,?,?,?);";
       

        for (int i = 0; i < matriz.size(); i++) {
            JsonObject object = matriz.get(i).getAsJsonObject();

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
         
            ps.setString(2, object.get("nombre").getAsString());
            ps.setInt(3, object.get("caja").getAsInt());
            ps.setInt(4, object.get("ventas").getAsInt());
            ps.setString(5, object.get("genero").getAsString());
            ps.setString(6, object.get("password").getAsString());
            ps.setInt(1, object.get("codigo").getAsInt());
            ps.executeUpdate();
        }
    } finally {
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            con.close();
        }
    }
    
    
    
    
    }

    
    
    
    
    
}
