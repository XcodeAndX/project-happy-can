/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;


public class MascotaDTO {
    private String id;
    private String nombre;
    private String fechaNacimiento;
    private String raza;
    private String color;
    private String documentoPropietario;
    
    public MascotaDTO(){}

    public MascotaDTO(String id, String nombre, String fechaNacimiento, String raza, String color, String documentoPropietario) {
        this.id = id;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.raza = raza;
        this.color = color;
        this.documentoPropietario = documentoPropietario;
    }

    public MascotaDTO(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDocumentoPropietario() {
        return documentoPropietario;
    }

    public void setDocumentoPropietario(String documentoPropietario) {
        this.documentoPropietario = documentoPropietario;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MascotaDTO{ID=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", raza=").append(raza);
        sb.append(", color=").append(color);
        sb.append(", documentoPropietario=").append(documentoPropietario);
        sb.append('}');
        return sb.toString();
    }
}
