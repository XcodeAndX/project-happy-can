/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Web;

import Datos.MascotaDAO;
import Modelo.MascotaDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/mascotas")
public class MascotaController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "eliminar":
                    this.eliminar(request, response);
                    break;
                case "editar":
                    this.editar(request, response);
                    break;
                default:
                    this.listarMascotas(request, response);
            }
        } else {
            this.listarMascotas(request, response);
        }
    }

    private void listarMascotas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        MascotaDAO mascota = new MascotaDAO();
        List<MascotaDTO> mascotas = mascota.consultar();
        HttpSession session = request.getSession();
        session.setAttribute("mascotas", mascotas);
        response.sendRedirect("vista/listaMascotas.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "crear":
                    this.crear(request, response);
                    break;
                case "modificar":
                    this.modificar(request, response);
                    break;
                default:
                    this.listarMascotas(request, response);
            }
        } else {
            this.listarMascotas(request, response);
        }
    }

    private void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String fechaNacimiento = request.getParameter("fechanacimiento");
        String raza = request.getParameter("raza");
        String color = request.getParameter("color");
        String documentoPropietario = request.getParameter("propietario_numerodocumento");

        MascotaDTO mascota = new MascotaDTO(id, nombre, fechaNacimiento, raza, color, documentoPropietario);
        int registros = new MascotaDAO().crear(mascota);
        this.listarMascotas(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        MascotaDTO mascotaDto = new MascotaDAO().encontrar(new MascotaDTO(id));
        request.setAttribute("mascotadto", mascotaDto);
        request.getRequestDispatcher("/WEB-INF/mascotas/editarMascota.jsp").forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        int registros = new MascotaDAO().eliminar(new MascotaDTO(id));
        this.listarMascotas(request, response);
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String fechaNacimiento = request.getParameter("fechanacimiento");
        String raza = request.getParameter("raza");
        String color = request.getParameter("color");
        String documentoPropietario = request.getParameter("propietario_numerodocumento");

        MascotaDTO mascota = new MascotaDTO(id, nombre, fechaNacimiento, raza, color, documentoPropietario);
        int registros = new MascotaDAO().actualizar(mascota);
        this.listarMascotas(request, response);
    }
}
