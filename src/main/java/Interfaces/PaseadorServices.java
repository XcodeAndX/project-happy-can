/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.PaseadorDTO;
import java.util.List;


public interface PaseadorServices {
    public List<PaseadorDTO> consultar();
    public int crear(PaseadorDTO paseadorDTO);
    public int actualizar(PaseadorDTO paseadorDTO);
    public int eliminar(PaseadorDTO paseadorDTO);
}
