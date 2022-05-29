/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Datos;

import Interfaces.PaseoServices;
import Modelo.PaseoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PaseoDAO implements PaseoServices{
    public static final String SQL_CONSULTA = "SELECT id_mascota, numerodocumento_paseador, horasalida, horaentrega, fechapaseo FROM paseos";
    
    public static final String SQL_INSERTAR = "INSERT INTO paseos VALUES (?,?,?,?,?)";
    
    public static final String SQL_ACTUALIZAR = "UPDATE paseos SET  id_mascota = ?, numerodocumento_paseador = ?, horasalida = ?, horaentrega = ? WHERE fechapaseo = ?";
    
    public static final String SQL_ELIMINAR = "DELETE FROM paseos WHERE fechapaseo = ?";
    
    public static final String SQL_CONSULTAR_BY_ID = "SELECT id_mascota, numerodocumento_paseador, horasalida, horaentrega FROM paseos WHERE fechapaseo = ?";

    @Override
    public List<PaseoDTO> consultar() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        PaseoDTO paseo = null;
        List<PaseoDTO> paseos = new ArrayList<>();
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_CONSULTA);
            res = stmt.executeQuery();
            while (res.next()) {
                String id_mascota = res.getString("id_mascota");
                String numerodocumento_paseador = res.getString("numerodocumento_paseador");
                String horasalida = res.getString("horasalida");
                String horaentrega = res.getString("horaentrega");
                String fechapaseo = res.getString("fechapaseo");
                paseo = new PaseoDTO(id_mascota, numerodocumento_paseador, horasalida, horaentrega, fechapaseo);
                paseos.add(paseo);
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
        return paseos;
    }

    @Override
    public int crear(PaseoDTO paseos) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_INSERTAR);
            stmt.setString(1, paseos.getId_mascota());
            stmt.setString(2, paseos.getNumeroDocumento_paseador());
            stmt.setString(3, paseos.getHoraSalida());
            stmt.setString(4, paseos.getHoraEntrada());
            stmt.setString(5, paseos.getFechaPaseo());
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
    public int actualizar(PaseoDTO paseos) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ACTUALIZAR);
            stmt.setString(1, paseos.getId_mascota());
            stmt.setString(2, paseos.getNumeroDocumento_paseador());
            stmt.setString(3, paseos.getHoraSalida());
            stmt.setString(4, paseos.getHoraEntrada());
            stmt.setString(5, paseos.getFechaPaseo());
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
    public int eliminar(PaseoDTO paseos) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ELIMINAR);
            stmt.setString(1, paseos.getFechaPaseo());
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
    
    public PaseoDTO encontrar(PaseoDTO p) {
        Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        try {
            con = ConexionBD.getConnection();
            sen = con.prepareStatement(SQL_CONSULTAR_BY_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            sen.setString(1, p.getFechaPaseo());
            res = sen.executeQuery();
            res.absolute(1);//primer registro devuelto
            String id_mascota = res.getString("id_mascota");
            String numerodocumento_paseador = res.getString("numerodocumento_paseador");
            String horasalida = res.getString("horasalida");
            String horaentrega = res.getString("horaentrega");
            p.setId_mascota(id_mascota);
            p.setNumeroDocumento_paseador(numerodocumento_paseador);
            p.setHoraSalida(horasalida);
            p.setHoraEntrada(horaentrega);
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
