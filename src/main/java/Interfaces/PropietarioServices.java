/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.PropietarioDTO;
import java.util.List;


public interface PropietarioServices {
    public List<PropietarioDTO> consultar();
    public int crear(PropietarioDTO propietarioDTO);
    public int actualizar(PropietarioDTO propietarioDTO);
    public int eliminar(PropietarioDTO propietarioDTO);
}
