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
public class PropietarioDTO extends PersonaDTO{
    private String estrato;
    
    public PropietarioDTO(){}

    public PropietarioDTO(String nombres, String apellidos, String genero, String tipoDocumento, String numeroDocumento, String direccion, String correo, String estrato) {
        super(nombres, apellidos, genero, tipoDocumento, numeroDocumento, direccion, correo);
        this.estrato = estrato;
    }

    public PropietarioDTO(String numeroDocumento) {
        super(numeroDocumento);
    }

    public String getEstrato() {
        return estrato;
    }

    public void setEstrato(String estrato) {
        this.estrato = estrato;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PropietarioDTO{").append(super.toString());
        sb.append(", estrato=").append(estrato);
        sb.append('}');
        return sb.toString();
    }
}
