/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Interfaces.PropietarioServices;
import Modelo.PropietarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PropietarioDAO implements PropietarioServices{
    public static final String SQL_CONSULTA = "SELECT nombres, apellidos, genero, tipodocumento,"
                                                                           + " numerodocumento, direccion, correo, estrato FROM propietarios";
    
    public static final String SQL_INSERTAR = "INSERT INTO propietarios VALUES (?,?,?,?,?,?,?,?)";
    
    public static final String SQL_ACTUALIZAR = "UPDATE propietarios SET nombres = ?, apellidos = ?, genero = ?,"
                                                                              + "  tipodocumento = ?, direccion = ?, correo = ?, estrato = ? WHERE numerodocumento = ?";
    
    public static final String SQL_ELIMINAR = "DELETE FROM propietarios WHERE numerodocumento = ?";
    
    public static final String SQL_CONSULTAR_BY_ID = "SELECT nombres, apellidos, genero, tipodocumento,"
                                                                           + " direccion, correo, estrato FROM propietarios WHERE numerodocumento = ?";

    @Override
    public List<PropietarioDTO> consultar() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        PropietarioDTO propietario = null;
        List<PropietarioDTO> propietarios = new ArrayList<>();
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_CONSULTA);
            res = stmt.executeQuery();
            while (res.next()) {
                String nombres = res.getString("nombres");
                String apellidos = res.getString("apellidos");
                String genero = res.getString("genero");
                String tipodocumento = res.getString("tipodocumento");
                String numerodocumento = res.getString("numerodocumento");
                String direccion = res.getString("direccion");
                String correo = res.getString("correo");
                String estrato = res.getString("estrato");
                propietario = new PropietarioDTO(nombres, apellidos, genero, tipodocumento, numerodocumento, direccion, correo, estrato);
                propietarios.add(propietario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ConexionBD.close(res);
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(PropietarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return propietarios;
    }

    @Override
    public int crear(PropietarioDTO propietario) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_INSERTAR);
            stmt.setString(1, propietario.getNombres());
            stmt.setString(2, propietario.getApellidos());
            stmt.setString(3, propietario.getGenero());
            stmt.setString(4, propietario.getTipoDocumento());
            stmt.setString(5, propietario.getNumeroDocumento());
            stmt.setString(6, propietario.getDireccion());
            stmt.setString(7, propietario.getCorreo());
            stmt.setString(8, propietario.getEstrato());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    @Override
    public int actualizar(PropietarioDTO propietario) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ACTUALIZAR);
            stmt.setString(1, propietario.getNombres());
            stmt.setString(2, propietario.getApellidos());
            stmt.setString(3, propietario.getGenero());
            stmt.setString(4, propietario.getTipoDocumento());
            stmt.setString(5, propietario.getDireccion());
            stmt.setString(6, propietario.getCorreo());
            stmt.setString(7, propietario.getEstrato());
            stmt.setString(8, propietario.getNumeroDocumento());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    @Override
    public int eliminar(PropietarioDTO propietario) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ELIMINAR);
            stmt.setString(1, propietario.getNumeroDocumento());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }
    
    public PropietarioDTO encontrar(PropietarioDTO p) {
        Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        try {
            con = ConexionBD.getConnection();
            sen = con.prepareStatement(SQL_CONSULTAR_BY_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            sen.setString(1, p.getNumeroDocumento());
            res = sen.executeQuery();
            res.absolute(1);//primer registro devuelto
            String nombres = res.getString("nombres");
            String apellidos = res.getString("apellidos");
            String genero = res.getString("genero");
            String tipodocumento = res.getString("tipodocumento");
            String direccion = res.getString("direccion");
            String correo = res.getString("correo");
            String estrato = res.getString("estrato");
            p.setNombres(nombres);
            p.setApellidos(apellidos);
            p.setGenero(genero);
            p.setTipoDocumento(tipodocumento);
            p.setDireccion(direccion);
            p.setCorreo(correo);
            p.setEstrato(estrato);
        } 
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } 
        finally {
            try {
                ConexionBD.close(res);
                ConexionBD.close(sen);
                ConexionBD.close(con);
            } 
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
       return p;
    }
}
