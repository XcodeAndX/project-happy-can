/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Datos.PropietarioDAO;
import Modelo.PropietarioDTO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/propietarios")
public class PropietarioController extends HttpServlet {

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
                    this.listarPropietarios(request, response);
            }
        } else {
            this.listarPropietarios(request, response);
        }
    }

    private void listarPropietarios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PropietarioDAO propietario = new PropietarioDAO();
        List<PropietarioDTO> propietarios = propietario.consultar();
        HttpSession session = request.getSession();
        session.setAttribute("propietarios", propietarios);
        response.sendRedirect("vista/listaPropietarios.jsp");
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
                    this.listarPropietarios(request, response);
            }
        } else {
            this.listarPropietarios(request, response);
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
        String estrato = request.getParameter("estrato");

        PropietarioDTO propietario = new PropietarioDTO(nombres, apellidos, genero, tipodocumento, numerodocumento, direccion, correo, estrato);
        int registros = new PropietarioDAO().crear(propietario);
        this.listarPropietarios(request, response);
    }

    private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numerodocumento = request.getParameter("numerodocumento");
        PropietarioDTO propietarioDto = new PropietarioDAO().encontrar(new PropietarioDTO(numerodocumento));
        request.setAttribute("propietariodto", propietarioDto);
        request.getRequestDispatcher("/WEB-INF/propietarios/editarPropietario.jsp").forward(request, response);
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String numerodocumento = request.getParameter("numerodocumento");
        int registros = new PropietarioDAO().eliminar(new PropietarioDTO(numerodocumento));
        this.listarPropietarios(request, response);
    }

    private void modificar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        String genero = request.getParameter("genero");
        String tipodocumento = request.getParameter("tipodocumento");
        String numerodocumento = request.getParameter("numerodocumento");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String estrato = request.getParameter("estrato");

        PropietarioDTO propietario = new PropietarioDTO(nombres, apellidos, genero, tipodocumento, numerodocumento, direccion, correo, estrato);
        int registros = new PropietarioDAO().actualizar(propietario);
        this.listarPropietarios(request, response);
    }
}
