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
public class PaseadorDTO extends PersonaDTO{
    private String experiencia;
    private String descripcion;
    
    public PaseadorDTO(){}

    public PaseadorDTO(String nombres, String apellidos, String genero, String tipoDocumento, String numeroDocumento, String direccion, String correo, String experiencia, String descripcion) {
        super(nombres, apellidos, genero, tipoDocumento, numeroDocumento, direccion, correo);
        this.experiencia = experiencia;
        this.descripcion = descripcion;
    }

    public PaseadorDTO(String numeroDocumento) {
        super(numeroDocumento);
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PaseadorDTO{").append(super.toString());
        sb.append(", experiencia=").append(experiencia);
        sb.append(", descripcion=").append(descripcion);
        sb.append('}');
        return sb.toString();
    }
}
