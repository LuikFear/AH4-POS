/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import MODEL.Productos;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
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
    
     private String leerarchivoP() {
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
            js.carga_masivaV();
            
    }
        
        
        
        
    public void carga_masivaP() throws FileNotFoundException, IOException, ParseException, SQLException {
        
        String archivo_retorno = leerarchivoP();
    JsonParser parse = new JsonParser();
    JsonArray matriz = parse.parse(archivo_retorno).getAsJsonArray();

    
    try {
       String sql = "insert into productos (codigo,nombre,descripcion,cantidad,precio) values (?,?,?,?,?);";
       

        for (int i = 0; i < matriz.size(); i++) {
            JsonObject object = matriz.get(i).getAsJsonObject();

            con = acceso.Conectar();
            ps = con.prepareStatement(sql);
         
            ps.setString(2, object.get("nombre").getAsString());
            ps.setString(3, object.get("descripcion").getAsString());
            ps.setInt(4, object.get("cantidad").getAsInt());
            ps.setFloat(5, object.get("precio").getAsFloat());
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

