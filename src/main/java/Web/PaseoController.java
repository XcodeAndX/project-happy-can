/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Web;

import Datos.PaseoDAO;
import Modelo.PaseoDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/paseos")
public class PaseoController extends HttpServlet {

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
                    this.listarPaseos(request, response);
            }
        } else {
            this.listarPaseos(request, response);
        }
    }

    private void listarPaseos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaseoDAO paseo = new PaseoDAO();
        List<PaseoDTO> paseos = paseo.consultar();
        HttpSession session = request.getSession();
        session.setAttribute("paseos", paseos);
        response.sendRedirect("vista/listaPaseos.jsp");
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
                    this.listarPaseos(request, response);
            }
        } else {
            this.listarPaseos(request, response);
        }
    }

    private void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_mascota = request.getParameter("id_mascota");
        String numeroDocumento_paseador = request.getParameter("numerodocumento_paseador");
        String horaSalida = request.getParameter("horasalida");
        String horaEntrada = request.getParameter("horaentrega");
        String fechaPaseo = request.getParameter("fechapaseo");

        PaseoDTO paseo = new PaseoDTO(id_mascota, numeroDocumento_paseador, horaSalida, horaEntrada, fechaPaseo);
        int registros = new PaseoDAO().crear(paseo);
        this.listarPaseos(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fechaPaseo = request.getParameter("fechapaseo");
        PaseoDTO paseoDto = new PaseoDAO().encontrar(new PaseoDTO(fechaPaseo));
        request.setAttribute("paseodto", paseoDto);
        request.getRequestDispatcher("/WEB-INF/paseos/editarPaseo.jsp").forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fechaPaseo = request.getParameter("fechapaseo");
        int registros = new PaseoDAO().eliminar(new PaseoDTO(fechaPaseo));
        this.listarPaseos(request, response);
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id_mascota = request.getParameter("id_mascota");
        String numeroDocumento_paseador = request.getParameter("numerodocumento_paseador");
        String horaSalida = request.getParameter("horasalida");
        String horaEntrada = request.getParameter("horaentrega");
        String fechaPaseo = request.getParameter("fechapaseo");

        PaseoDTO paseo = new PaseoDTO(id_mascota, numeroDocumento_paseador, horaSalida, horaEntrada, fechaPaseo);
        int registros = new PaseoDAO().actualizar(paseo);
        this.listarPaseos(request, response);
    }
}
