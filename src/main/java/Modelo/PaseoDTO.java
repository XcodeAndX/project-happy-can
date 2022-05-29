/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 * 
 * @author HappyCan
 */
public class PaseoDTO {
    private String id_mascota;
    private String numeroDocumento_paseador;
    private String horaSalida;
    private String horaEntrada;
    private String fechaPaseo;
    
    public PaseoDTO(){}

    public PaseoDTO(String id_mascota, String numeroDocumento_paseador, String horaSalida, String horaEntrada, String fechaPaseo) {
        this.id_mascota = id_mascota;
        this.numeroDocumento_paseador = numeroDocumento_paseador;
        this.horaSalida = horaSalida;
        this.horaEntrada = horaEntrada;
        this.fechaPaseo = fechaPaseo;
    }

    public PaseoDTO(String fechaPaseo) {
        this.fechaPaseo = fechaPaseo;
    }

    public String getId_mascota() {
        return id_mascota;
    }

    public void setId_mascota(String id_mascota) {
        this.id_mascota = id_mascota;
    }

    public String getNumeroDocumento_paseador() {
        return numeroDocumento_paseador;
    }

    public void setNumeroDocumento_paseador(String numeroDocumento_paseador) {
        this.numeroDocumento_paseador = numeroDocumento_paseador;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getFechaPaseo() {
        return fechaPaseo;
    }

    public void setFechaPaseo(String fechaPaseo) {
        this.fechaPaseo = fechaPaseo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaseoDTO{id_mascota=").append(id_mascota);
        sb.append(", numeroDocumento_paseador=").append(numeroDocumento_paseador);
        sb.append(", horaSalida=").append(horaSalida);
        sb.append(", horaEntrada=").append(horaEntrada);
        sb.append(", fechaPaseo=").append(fechaPaseo);
        sb.append('}');
        return sb.toString();
    }
}
