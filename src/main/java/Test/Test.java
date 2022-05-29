/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import Datos.PaseoDAO;
import Modelo.PaseoDTO;
import java.util.ArrayList;
import java.util.List;
import Modelo.PaseadorDTO;
import Datos.PaseadorDAO;
import Modelo.PropietarioDTO;
import Datos.PropietarioDAO;
import Modelo.MascotaDTO;
import Datos.MascotaDAO;


public class Test {
    public static void main(String[] args) {
        //Propietarios
        PropietarioDAO po = new PropietarioDAO();
        List<PropietarioDTO> propietarios = new ArrayList<>();
        
        //Mascotas
        MascotaDAO m = new MascotaDAO();
        List<MascotaDTO> mascotas = new ArrayList<>();
        
        //Paseadores
        PaseadorDAO pa = new PaseadorDAO();
        List<PaseadorDTO> paseadores = new ArrayList<>();
        
        //Paseos
        PaseoDAO p = new PaseoDAO();
        List<PaseoDTO> paseos = new ArrayList<>();
        
        //Imprimir consultas
        paseadores = pa.consultar();
        paseos = p.consultar();
        propietarios = po.consultar();
        mascotas = m.consultar();
        
        System.out.println("Propietarios:");
        for(PropietarioDTO pro : propietarios) System.out.println(pro);
        System.out.println("----------------------------------------");
        
        System.out.println("Paseadores:");
        for(PaseadorDTO pas : paseadores) System.out.println(pas);
        System.out.println("----------------------------------------");
        
        System.out.println("Mascotas:");
        for(MascotaDTO ma : mascotas) System.out.println(ma);
        System.out.println("----------------------------------------");
        
        System.out.println("Paseos:");
        for(PaseoDTO pp : paseos) System.out.println(pp);
    }
}
