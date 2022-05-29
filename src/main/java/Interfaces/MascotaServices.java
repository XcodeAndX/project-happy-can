/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.MascotaDTO;
import java.util.List;


public interface MascotaServices {
    public List<MascotaDTO> consultar();
    public int crear(MascotaDTO mascotaDTO);
    public int actualizar(MascotaDTO mascotaDTO);
    public int eliminar(MascotaDTO mascotaDTO);
}
