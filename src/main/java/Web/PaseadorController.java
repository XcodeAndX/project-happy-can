/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Web;

import Datos.PaseadorDAO;
import Modelo.PaseadorDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/paseadores")
public class PaseadorController extends HttpServlet {

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
                    this.listarPaseadores(request, response);
            }
        } else {
            this.listarPaseadores(request, response);
        }
    }

    private void listarPaseadores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PaseadorDAO paseador = new PaseadorDAO();
        List<PaseadorDTO> paseadores = paseador.consultar();
        HttpSession session = request.getSession();
        session.setAttribute("paseadores", paseadores);
        response.sendRedirect("vista/listaPaseadores.jsp");
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
                    this.listarPaseadores(request, response);
            }
        } else {
            this.listarPaseadores(request, response);
        }
    }

    private void crear(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String genero = request.getParameter("genero");
        String tipodocumento = request.getParameter("tipodocumento");
        String numerodocumento = request.getParameter("numerodocumento");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String experiencia = request.getParameter("experiencia");
        String descripcion = request.getParameter("descripcion");
        
        PaseadorDTO paseador = new PaseadorDTO(nombres, apellidos, genero, tipodocumento, numerodocumento, direccion, correo, experiencia, descripcion);
        int registros = new PaseadorDAO().crear(paseador);
        this.listarPaseadores(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numerodocumento = request.getParameter("numerodocumento");
        PaseadorDTO paseadorDto = new PaseadorDAO().encontrar(new PaseadorDTO(numerodocumento));
        request.setAttribute("paseadordto", paseadorDto);
        request.getRequestDispatcher("/WEB-INF/paseadores/editarPaseador.jsp").forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numerodocumento = request.getParameter("numerodocumento");
        int registros = new PaseadorDAO().eliminar(new PaseadorDTO(numerodocumento));
        this.listarPaseadores(request, response);
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String genero = request.getParameter("genero");
        String tipodocumento = request.getParameter("tipodocumento");
        String numerodocumento = request.getParameter("numerodocumento");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String experiencia = request.getParameter("experiencia");
        String descripcion = request.getParameter("descripcion");
        
        PaseadorDTO paseador = new PaseadorDTO(nombres, apellidos, genero, tipodocumento, numerodocumento, direccion, correo, experiencia, descripcion);
        int registros = new PaseadorDAO().actualizar(paseador);
        this.listarPaseadores(request, response);
    }
}
