/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Interfaces.PaseadorServices;
import Modelo.PaseadorDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaseadorDAO implements PaseadorServices{
    public static final String SQL_CONSULTA = "SELECT nombres, apellidos, genero, tipodocumento,"
                                            + " numerodocumento, direccion, correo, experiencia, descripcion FROM paseadores";
    
    public static final String SQL_INSERTAR = "INSERT INTO paseadores VALUES (?,?,?,?,?,?,?,?,?)";
    
    public static final String SQL_ACTUALIZAR = "UPDATE paseadores SET nombres = ?, apellidos = ?, genero = ?,"
                                              + "  tipodocumento = ?, direccion = ?, correo = ?, experiencia = ?, descripcion = ? WHERE numerodocumento = ?";
    
    public static final String SQL_ELIMINAR = "DELETE FROM paseadores WHERE numerodocumento = ?";
    
    public static final String SQL_CONSULTAR_BY_ID = "SELECT nombres, apellidos, genero, tipodocumento,"
                                                   + " direccion, correo, experiencia, descripcion FROM paseadores WHERE numerodocumento = ?";

    @Override
    public List<PaseadorDTO> consultar() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        PaseadorDTO paseador = null;
        List<PaseadorDTO> paseadores = new ArrayList<>();
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
                String experiencia = res.getString("experiencia");
                String descripcion = res.getString("descripcion");
                paseador = new PaseadorDTO(nombres, apellidos, genero, tipodocumento, numerodocumento, direccion, correo, experiencia, descripcion);
                paseadores.add(paseador);
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
        return paseadores;
    }

    @Override
    public int crear(PaseadorDTO paseador) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_INSERTAR);
            stmt.setString(1, paseador.getNombres());
            stmt.setString(2, paseador.getApellidos());
            stmt.setString(3, paseador.getGenero());
            stmt.setString(4, paseador.getTipoDocumento());
            stmt.setString(5, paseador.getNumeroDocumento());
            stmt.setString(6, paseador.getDireccion());
            stmt.setString(7, paseador.getCorreo());
            stmt.setString(8, paseador.getExperiencia());
            stmt.setString(9, paseador.getDescripcion());
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
    public int actualizar(PaseadorDTO paseador) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ACTUALIZAR);
            stmt.setString(1, paseador.getNombres());
            stmt.setString(2, paseador.getApellidos());
            stmt.setString(3, paseador.getGenero());
            stmt.setString(4, paseador.getTipoDocumento());
            stmt.setString(5, paseador.getDireccion());
            stmt.setString(6, paseador.getCorreo());
            stmt.setString(7, paseador.getExperiencia());
            stmt.setString(8, paseador.getDescripcion());
            stmt.setString(9, paseador.getNumeroDocumento());
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
    public int eliminar(PaseadorDTO paseador) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ELIMINAR);
            stmt.setString(1, paseador.getNumeroDocumento());
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
    
    public PaseadorDTO encontrar(PaseadorDTO p) {
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
            String experiencia = res.getString("experiencia");
            String descripcion = res.getString("descripcion");
            p.setNombres(nombres);
            p.setApellidos(apellidos);
            p.setGenero(genero);
            p.setTipoDocumento(tipodocumento);
            p.setDireccion(direccion);
            p.setCorreo(correo);
            p.setExperiencia(experiencia);
            p.setDescripcion(descripcion);
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
