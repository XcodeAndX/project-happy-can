/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.PaseoDTO;
import java.util.List;


public interface PaseoServices {
    public List<PaseoDTO> consultar();
    public int crear(PaseoDTO paseoDTO);
    public int actualizar(PaseoDTO paseoDTO);
    public int eliminar(PaseoDTO paseoDTO);
}
