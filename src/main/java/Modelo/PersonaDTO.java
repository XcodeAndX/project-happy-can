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
public class PersonaDTO {
    private String nombres;
    private String apellidos;
    private String genero;
    private String tipoDocumento;
    private String numeroDocumento;
    private String direccion;
    private String correo;
    
    public PersonaDTO(){}

    public PersonaDTO(String nombres, String apellidos, String genero, String tipoDocumento, String numeroDocumento, String direccion, String correo) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.direccion = direccion;
        this.correo = correo;
    }

    public PersonaDTO(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("nombres=").append(nombres);
        sb.append(", apellidos=").append(apellidos);
        sb.append(", genero=").append(genero);
        sb.append(", tipoDocumento=").append(tipoDocumento);
        sb.append(", numeroDocumento=").append(numeroDocumento);
        sb.append(", direccion=").append(direccion);
        sb.append(", correo=").append(correo);
        sb.append('}');
        return sb.toString();
    }
}
